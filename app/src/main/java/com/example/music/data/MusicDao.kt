package com.example.music.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface MusicDao {
    @Query("SELECT * FROM music_table ORDER BY id ASC")
    fun readData(): kotlinx.coroutines.flow.Flow<List<Music>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(music: Music)

    @Query("SELECT * FROM music_table WHERE nameMusic LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): kotlinx.coroutines.flow.Flow<List<Music>>
}