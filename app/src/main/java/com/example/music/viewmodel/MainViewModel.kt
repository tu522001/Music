package com.example.music.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.music.data.Music
import com.example.music.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val readData = repository.readData().asLiveData()

    fun insertData(music: Music){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(music)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Music>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }

}