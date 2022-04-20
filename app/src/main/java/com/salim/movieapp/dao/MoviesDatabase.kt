package com.salim.movieapp.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salim.movieapp.di.ApplicationScope
import com.salim.movieapp.model.Movies
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Movies::class], version = 1, exportSchema = false)
abstract class MoviesDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    class Callback @Inject constructor(
        private val database: Provider<MoviesDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}