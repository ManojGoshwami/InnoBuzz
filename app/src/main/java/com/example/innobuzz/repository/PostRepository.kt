package com.example.innobuzz.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.innobuzz.api.PostService
import com.example.innobuzz.db.PostDatabase
import com.example.innobuzz.models.PostList
import com.example.innobuzz.models.PostListItem
import com.example.innobuzz.utils.NetworkUtils


class PostRepository(
    private val postService: PostService,
    private val postDatabase: PostDatabase,
    private val applicationContext: Context
) {

    private val postLiveData = MutableLiveData<PostList>()

    val post: LiveData<PostList>
        get() = postLiveData



    suspend fun getPost() {
//        val result = postService.getPosts()
//
////        if (result.body() != null) {
////            postLiveData.postValue(result.body())
////        }



        if (NetworkUtils.isInternetAvailable(applicationContext)) {

            val result = postService.getPosts()
            if (result?.body() != null) {

                val list = ArrayList<PostListItem>()

                list.addAll(result.body()!!)

                postDatabase.postDao().addPost(list)
                postLiveData.postValue(result.body())

            }
        } else {
            val list = PostList()

            list.addAll(postDatabase.postDao().getPost())
            postLiveData.postValue(list)

            Log.d("Nanu", list.toString())

//            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
//            postLiveData.postValue(postDatabase.postDao().getPost())
        }
    }


}







