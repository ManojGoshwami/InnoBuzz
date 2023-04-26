package com.example.innobuzz

import android.app.Application
import com.example.innobuzz.repository.PostRepository
import com.example.innobuzz.api.PostService
import com.example.innobuzz.api.RetrofitHelper
import com.example.innobuzz.db.PostDatabase



class PostApplication : Application() {

    lateinit var postRepository: PostRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(PostService::class.java)
        val database = PostDatabase.getDatabase(applicationContext)
        postRepository = PostRepository(quoteService,database, applicationContext)
    }
}