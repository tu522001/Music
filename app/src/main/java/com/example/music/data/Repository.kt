package com.example.music.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val musicDao: MusicDao
) {

    fun readData(): Flow<List<Music>> {
        return musicDao.readData()
    }

    suspend fun insertData(music: Music) {
        musicDao.insertData(music)
    }

    fun searchDatabase(searchQuery: String): Flow<List<Music>> {
        return musicDao.searchDatabase(searchQuery)
    }
}

