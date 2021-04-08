package com.example.myapplicationtest.repository

import android.util.Log
import com.example.coroutine.data.model.Post
import com.example.hiltwithroomandcoroutine.data.remote.ApiServices
import com.example.hiltwithroomandcoroutine.listeners.ResponseListener
import com.example.myapplicationtest.db.PostDao
import java.lang.Exception
import javax.inject.Inject

class Repository {

    var apiService: ApiServices
    var postDao: PostDao
var posts:ArrayList<Post>
    @Inject
    constructor(apiService: ApiServices ,postDao: PostDao) {
        this.apiService = apiService
        this.postDao = postDao

        posts= ArrayList()

    }

    suspend fun getPost(responseListener: ResponseListener) {
        try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
            addPosts(response.body()!!)

                responseListener.sucess(response.body()!!)

            } else {
                responseListener.error("error occured")
            }
        } catch (e: Exception) {
            Log.d("Ex", "e")
        }

    }
suspend fun addPosts(posts:ArrayList<Post>){
    posts.addAll(posts)
    postDao.addPosts(posts)
}
suspend  fun getAllPosts():ArrayList<Post>{

    return postDao.getAllPosts() as ArrayList<Post>
}

}