package com.example.myapplicationtest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutine.data.model.Post
import com.example.hiltwithroomandcoroutine.ui.MainViewModel
import com.example.myapplicationtest.R
import com.example.myapplicationtest.adapters.MainAdapter
import com.example.myapplicationtest.base.BaseActivity
import com.example.myapplicationtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    val  model:MainViewModel by viewModels()
  lateinit  var mainAdapter:MainAdapter
   lateinit  var  layoutMange:LinearLayoutManager
  lateinit  var bind:ActivityMainBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         bind=DataBindingUtil.setContentView(this,R.layout.activity_main)
          model.getPost()
         bind.rv.setHasFixedSize(true)
         layoutMange= LinearLayoutManager(this)
         layoutMange.orientation=LinearLayoutManager.VERTICAL
         bind.rv.layoutManager= layoutMange
         mainAdapter= MainAdapter(ArrayList())
         bind.rv.adapter=mainAdapter

         lifecycleScope.launchWhenStarted {
            model.getposts().collect {
            if (it!=null){

                mainAdapter.notifyList(it!!)
             }
        } }

    }
}