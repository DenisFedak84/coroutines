package com.fedak.denis.valtech.di

import android.content.Context
import com.fedak.denis.mvvmcoroutine.di.module.AppModule
import com.fedak.denis.valtech.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}