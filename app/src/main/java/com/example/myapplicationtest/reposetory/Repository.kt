package com.example.myapplicationtest.reposetory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.coroutine.data.model.Post
import com.example.hiltwithroomandcoroutine.data.remote.ApiServices
import com.example.hiltwithroomandcoroutine.listeners.ResponseListener
import com.example.myapplicationtest.db.PostDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class Repository {

    var apiService: ApiServices
//    var postDao: PostDao

    @Inject
    constructor(apiService: ApiServices ) {
        this.apiService = apiService
//        this.postDao = postDao


    }

    suspend fun getPost(responseListener: ResponseListener) {
        try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
//                addPosts(response.body()!!)

                responseListener.sucess(response.body()!!)

            } else {
                responseListener.error("error occured")
            }
        } catch (e: Exception) {
            Log.d("Ex", "e")
        }

    }
fun addPosts(posts:ArrayList<Post>){
//    postDao.addPosts(posts)
}

}