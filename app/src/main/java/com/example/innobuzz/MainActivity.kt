package com.example.innobuzz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.innobuzz.viewmodels.PostViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: PostViewModel
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        navController=navHostFragment.navController
        setupActionBarWithNavController(this, navController)

//        val repository = (application as PostApplication).postRepository
//
//        mainViewModel = ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)

//
//        mainViewModel.post.observe(this,Observer{
//            Log.d("Manoj","On Create ${it.toString()}")
//            Toast.makeText(this@MainActivity, "Data get Successfully ${it.toString()}", Toast.LENGTH_LONG).show()
//        })
//
//        mainViewModel.posts.observe(this, Observer {
//            Toast.makeText(this@MainActivity, "Data get Successfully", Toast.LENGTH_SHORT).show()
//        })
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}