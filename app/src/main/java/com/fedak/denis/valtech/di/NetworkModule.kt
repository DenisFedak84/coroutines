package com.fedak.denis.valtech.di

import com.fedak.denis.valtech.network.NotesApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    internal fun providePostApi(retrofit: Retrofit): NotesApi {
        return retrofit.create(NotesApi::class.java)
    }

    @Provides
    internal fun provideRetrofitInterface(): Retrofit {

           return Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttp())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    fun createOkHttp(): OkHttpClient {

        val okhttp = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okhttp.addInterceptor(loggingInterceptor)
        return okhttp.build()
    }
}
