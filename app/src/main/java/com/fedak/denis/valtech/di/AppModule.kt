package com.fedak.denis.mvvmcoroutine.di.module

import com.fedak.denis.valtech.di.DatabaseModule
import com.fedak.denis.valtech.di.NetworkModule
import com.fedak.denis.valtech.di.ViewModelModule
import dagger.Module
import dagger.android.AndroidInjectionModule


@Module(
    includes = [AndroidInjectionModule::class, ActivityModule::class, ViewModelModule::class, NetworkModule::class, DatabaseModule::class]
)
class AppModule