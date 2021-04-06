package com.example.myapplicationtest.ui

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutine.data.model.Post
import com.example.hiltwithroomandcoroutine.ui.MainViewModel
import com.example.myapplicationtest.R
import com.example.myapplicationtest.adapters.MainAdapter
import com.example.myapplicationtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val  model:MainViewModel by viewModels()
  lateinit  var mainAdapter:MainAdapter
    var posts:ArrayList<Post>?=null
  lateinit  var  layoutMange:LinearLayoutManager
  lateinit  var bind:ActivityMainBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         bind=DataBindingUtil.setContentView(this,R.layout.activity_main)
         posts= ArrayList()
         model.getPost()
         bind.rv.setHasFixedSize(true)
         layoutMange= LinearLayoutManager(this)
         layoutMange.orientation=LinearLayoutManager.VERTICAL
         bind.rv.layoutManager= layoutMange
         mainAdapter= MainAdapter(posts!!)
         bind.rv.adapter=mainAdapter

         lifecycleScope.launchWhenStarted {
            model.getTitle().collect {
            if (it!=null){
                posts!!.addAll(it)
                mainAdapter.notifyList(posts!!)
             }
        } }

    }
}