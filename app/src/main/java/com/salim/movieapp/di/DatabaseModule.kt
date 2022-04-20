package com.salim.movieapp.di

import android.app.Application
import androidx.room.Room
import com.salim.movieapp.dao.MovieDao
import com.salim.movieapp.dao.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: MoviesDatabase.Callback): MoviesDatabase{
        return Room.databaseBuilder(application, MoviesDatabase::class.java, "alpha_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideMovieAppDao(db: MoviesDatabase): MovieDao{
        return db.getMovieDao()
    }
}