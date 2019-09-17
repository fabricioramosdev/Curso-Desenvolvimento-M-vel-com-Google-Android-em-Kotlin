package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.dao.TweetDao
import br.com.caelum.twittelum.database.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)


        fab.setOnClickListener {
            Snackbar.make(lista_tweets, "Indo para o TweetActivity", Snackbar.LENGTH_LONG).show()

            val vaiProFormulario = Intent(this, MainActivity::class.java)
            startActivity(vaiProFormulario)
        }


    }


    override fun onResume() {
        super.onResume()
        val tweetDao =  TwittelumDatabase.getIntance(this).tweetDao()
        val tweets : List<Tweet> = tweetDao.lista()

        lista_tweets.adapter = ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)

    }
}