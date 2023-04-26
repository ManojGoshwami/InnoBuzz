package com.example.innobuzz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzz.models.PostList
import com.example.innobuzz.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class PostViewModel(private val postRepository: PostRepository) : ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPost()
        }
    }

    val post: LiveData<PostList>
    get()=postRepository.post
}