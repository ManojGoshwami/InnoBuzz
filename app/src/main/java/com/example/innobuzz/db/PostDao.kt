package com.example.innobuzz.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.innobuzz.models.PostListItem

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(quotes:List<PostListItem>)

    @Query("SELECT * FROM postTable")
    suspend fun getPost() : List<PostListItem>

}