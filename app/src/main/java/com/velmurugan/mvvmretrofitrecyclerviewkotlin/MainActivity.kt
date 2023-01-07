package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setJsonAList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllJsonA()

        binding.btn1.setOnClickListener {
            val context = binding.root.context

            Intent(Intent.ACTION_VIEW).also {
                val url = "https://www.google.co.jp"
                it.data = Uri.parse(url)
                context.startActivity(it)
            }
        }

    }
}