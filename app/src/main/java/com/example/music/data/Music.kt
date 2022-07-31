package com.example.music.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "music_table")
data class Music(
    var sTT : Int,
    var nameMusic: String,
    var time : String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}