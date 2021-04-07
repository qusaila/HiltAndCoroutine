package com.example.myapplicationtest.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coroutine.data.model.Post

@Database(entities = [Post::class], version = 1,exportSchema = false )

public  abstract class RoomDb :RoomDatabase(){

    abstract fun postDao(): PostDao


}