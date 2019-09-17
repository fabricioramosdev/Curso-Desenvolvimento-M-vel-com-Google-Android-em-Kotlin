package br.com.caelum.twittelum.modelo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Tweet (val mensagem:String,
             @PrimaryKey(autoGenerate = true) val id: Int = 0){


}