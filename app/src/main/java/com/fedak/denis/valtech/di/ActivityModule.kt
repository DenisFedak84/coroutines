package com.fedak.denis.mvvmcoroutine.di.module

import com.fedak.denis.valtech.di.MainActivityModule
import dagger.Module

@Module(
    includes = [MainActivityModule::class]
)
class ActivityModule