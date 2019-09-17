package br.com.caelum.twittelum.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.caelum.twittelum.dao.TweetDao

import br.com.caelum.twittelum.modelo.Tweet


@Database(entities = [Tweet::class], version = 1)
abstract  class TwittelumDatabase : RoomDatabase() {

    abstract  fun tweetDao() : TweetDao
    companion object{
        private  val DATABASE = "twittelum"
        private var instance : TwittelumDatabase? = null

        fun getIntance(contexto:Context):TwittelumDatabase{

            return instance ?: criaBanco(contexto).also{ instance = it}
        }

        private  fun criaBanco(contexto: Context)=
            Room.databaseBuilder(contexto,TwittelumDatabase::class.java,DATABASE)
                .allowMainThreadQueries()
                .build()

    }


}