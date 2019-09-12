package com.fedak.denis.valtech.network

import com.fedak.denis.mvvmcoroutine.model.StackOverflowModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NotesApi {
    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    fun getNotes(@Query("page") pageNumber: Int, @Query("pagesize") pageSize: Int): Deferred<StackOverflowModel>
}