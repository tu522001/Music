package com.example.music.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Music::class],
    version = 1,
    exportSchema = false
)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun musicDao(): MusicDao

}