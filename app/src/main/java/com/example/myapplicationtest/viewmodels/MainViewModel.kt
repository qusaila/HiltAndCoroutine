package com.example.hiltwithroomandcoroutine.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutine.data.model.Post
import com.example.hiltwithroomandcoroutine.listeners.ResponseListener
import com.example.myapplicationtest.BaseApplication
import com.example.myapplicationtest.reposetory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel : ViewModel {
    var repository: Repository
    lateinit var mutableStateFlow: MutableStateFlow<ArrayList<Post>>

    @Inject
    public constructor(repository: Repository) {
        this.repository = repository
        mutableStateFlow = MutableStateFlow(ArrayList())
        if (isInternetConnected(BaseApplication.instance)) {
            getPost()

        } else {
            getAllPosts()

        }

    }

    @Inject
    fun isInternetConnected( application: Application): Boolean {
        val conMgr =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        return if (netInfo == null) false else true
    }

    fun getPost() = viewModelScope.launch {
        repository.getPost(object : ResponseListener {
            override fun sucess(obj: Any) {
                mutableStateFlow.value = obj as ArrayList<Post>
            }

            override fun error(msg: String) {

            }

            override fun loading() {


            }
        })


    }


    fun getposts(): StateFlow<ArrayList<Post>> {
        return mutableStateFlow
    }

    fun getAllPosts() {
        viewModelScope.launch {
            mutableStateFlow.value = repository.getAllPosts()
            Log.d("ex", mutableStateFlow.value.size.toString())
        }

    }
}