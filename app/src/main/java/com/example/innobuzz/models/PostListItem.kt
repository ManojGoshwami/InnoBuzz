package com.example.innobuzz.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postTable")
data class PostListItem(

    val body: String,

    @PrimaryKey
    val id: Int,

    val title: String,

    val userId: Int
)