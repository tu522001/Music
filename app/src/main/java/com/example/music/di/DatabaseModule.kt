package com.example.music.di

import android.content.Context
import androidx.room.Room
import com.example.music.data.MusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MusicDatabase::class.java,
        "music_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: MusicDatabase) = database.musicDao()

}