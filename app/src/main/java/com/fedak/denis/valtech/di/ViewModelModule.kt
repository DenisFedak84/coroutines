package com.fedak.denis.valtech.di

import androidx.lifecycle.ViewModelProvider
import com.fedak.denis.mvvmcoroutine.base.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}