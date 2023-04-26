package com.example.innobuzz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzz.adapter.PostAdapter
import com.example.innobuzz.viewmodels.PostViewModel
import com.example.innobuzz.viewmodels.PostViewModelFactory


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)

        return view;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var mainViewModel: PostViewModel

        val repository = (getActivity()?.getApplicationContext() as PostApplication).postRepository

        mainViewModel = ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)


        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(context)

        mainViewModel.post.observe(this, Observer{
//            Log.d("Manoj","On Create ${it.toString()}")
//            Toast.makeText(this@MainActivity, "Data get Successfully ${it.toString()}", Toast.LENGTH_LONG).show()
            val adapter = PostAdapter(it)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
        })
        // This will pass the ArrayList to our Adapter

    }

}