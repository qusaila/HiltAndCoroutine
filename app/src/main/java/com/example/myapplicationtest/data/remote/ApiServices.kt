package com.example.hiltwithroomandcoroutine.data.remote

import com.example.coroutine.data.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("/posts ")

    suspend fun getPosts( ): Response<ArrayList<Post>>
}