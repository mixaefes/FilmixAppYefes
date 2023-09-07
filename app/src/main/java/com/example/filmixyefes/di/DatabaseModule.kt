package com.example.filmixyefes.di

import android.content.Context
import androidx.room.Room
import com.example.filmixyefes.utils.Constants
import com.example.filmixyefes.data.local.Dao
import com.example.filmixyefes.data.local.FilmsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideFilmsDao(filmsDatabase: FilmsDatabase): Dao {
        return filmsDatabase.favoritesFilmsDao()
    }
    @Provides
    @Singleton
    fun provideFilmsDatabase(@ApplicationContext appContext: Context): FilmsDatabase {
        return Room.databaseBuilder(
            appContext,
            FilmsDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }
}