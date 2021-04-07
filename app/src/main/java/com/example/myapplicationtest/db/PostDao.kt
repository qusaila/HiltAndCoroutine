package com.example.myapplicationtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coroutine.data.model.Post
import kotlinx.coroutines.flow.MutableStateFlow


@Dao
interface PostDao {
    @Query("select * from postTable")
   suspend fun getAllPosts(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun addPosts(posts: List<Post>)


}