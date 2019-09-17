package br.com.caelum.twittelum.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.caelum.twittelum.modelo.Tweet

@Dao
interface TweetDao {

    @Insert
    fun salva(tweet:Tweet)

    @Query("SELECT * FROM Tweet")
    fun lista(): List<Tweet>
}