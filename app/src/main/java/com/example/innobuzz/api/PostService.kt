package com.example.innobuzz.api

import com.example.innobuzz.models.PostList
import com.example.innobuzz.models.PostListItem
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    suspend fun getPosts() : Response<PostList>
}