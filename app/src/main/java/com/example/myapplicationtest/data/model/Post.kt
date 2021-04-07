package com.example.coroutine.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postTable")
data class Post(
    @PrimaryKey
    var id: Int, var title: String
)