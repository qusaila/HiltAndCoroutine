package com.example.myapplicationtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coroutine.data.model.Post
import kotlinx.coroutines.flow.MutableStateFlow


@Dao
interface PostDao {
@Query("select * from posts")
fun getAllPosts():MutableStateFlow<ArrayList<Post>>

    @Insert
fun addPosts(posts:ArrayList<Post>)


}