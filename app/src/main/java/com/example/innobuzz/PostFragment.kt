package com.example.innobuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzz.adapter.PostAdapter
import com.example.innobuzz.viewmodels.PostViewModel
import com.example.innobuzz.viewmodels.PostViewModelFactory


class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_post, container, false)


//        findNavController(view).navigate(R.id.action_AFragment_to_BFragment)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var mainViewModel: PostViewModel

        val repository = (getActivity()?.getApplicationContext() as PostApplication).postRepository

        mainViewModel =
            ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)


        // this creates a vertical layout Manager

        mainViewModel.post.observe(this, Observer {
            val data = it.get(PostFragmentArgs.fromBundle(arguments!!).position)

         val   post_id=view.findViewById<TextView>(R.id.post_id)
         val   User_Id=view.findViewById<TextView>(R.id.User_Id)
         val   postTitle=view.findViewById<TextView>(R.id.PostTitle)
         val   txtBody=view.findViewById<TextView>(R.id.txtBody)

          post_id.text= data.id.toString()
          User_Id.text=data.userId.toString()
          postTitle.text=data.title
          txtBody.text=data.body

//            Toast.makeText(context, "Data  ${data.body}", Toast.LENGTH_LONG).show()

        })




    }

}