package com.example.myapplicationtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coroutine.data.model.Post

@Database(entities = arrayOf(Post::class), version = 1 )

public  abstract class RoomDb :RoomDatabase(){

    abstract fun postDao(): PostDao

}