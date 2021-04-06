package com.example.hiltwithroomandcoroutine.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutine.data.model.Post
 import com.example.hiltwithroomandcoroutine.listeners.ResponseListener
import com.example.myapplicationtest.reposetory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
 import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel   : ViewModel  {
    var repository: Repository
    lateinit var mutableStateFlow:MutableStateFlow<ArrayList<Post>>

    @Inject
  public  constructor(repository: Repository){
    this.repository=repository
     mutableStateFlow= MutableStateFlow(ArrayList())
        getPost()

    }





    fun getPost() = viewModelScope.launch {
         repository.getPost(object : ResponseListener {
            override fun sucess(obj: Any) {
                 mutableStateFlow.value=obj as ArrayList<Post>

             }

            override fun error(msg: String) {

            }

             override fun loading() {


             }
        })



    }
    fun getTitle(): StateFlow<ArrayList<Post>> {
    return mutableStateFlow
}

}