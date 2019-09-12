package com.fedak.denis.valtech.di

import android.content.Context
import com.fedak.denis.mvvmcoroutine.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
internal class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context) = AppDatabase.get(context)

    @Provides
    fun provideUserDao(database: AppDatabase) = database.userDao()
}