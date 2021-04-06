package com.example.coroutine.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey

data class Post(var title:String, @PrimaryKey(autoGenerate = true)
var id:Int) {

}