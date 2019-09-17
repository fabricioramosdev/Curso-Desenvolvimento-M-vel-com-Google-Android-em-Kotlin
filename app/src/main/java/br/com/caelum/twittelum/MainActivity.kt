package br.com.caelum.twittelum

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.dao.TweetDao
import br.com.caelum.twittelum.database.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.btn_salvar -> {
                publicaTweet()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun publicaTweet() {

        val mensagemDoTweet = mensagem.text.toString()

        var tweet = Tweet(mensagemDoTweet)
        val TweetDao = TwittelumDatabase.getIntance(this).tweetDao()

        TweetDao.salva(tweet)

        Toast.makeText(this, "$mensagemDoTweet", Toast.LENGTH_LONG).show()
        finish()
    }


}
