package com.example.innobuzz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzz.HomeFragmentDirections
import com.example.innobuzz.R
import com.example.innobuzz.models.PostListItem

class PostAdapter(private val postListItem: List<PostListItem>):RecyclerView.Adapter<PostAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.title_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return postListItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text=postListItem.get(position).title

        holder.textView.setOnClickListener{

            val directions: NavDirections =
                HomeFragmentDirections.actionHomeFragmentToPostFragment(position)

            findNavController(it).navigate(directions)

//            findNavController(it).navigate(R.id.action_homeFragment_to_postFragment)
        }
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.postTitle)
    }

}