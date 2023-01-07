package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<JsonA>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllJsonA() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<JsonA>> {
            override fun onResponse(call: Call<List<JsonA>>, response: Response<List<JsonA>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<JsonA>>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.d("test0201","$t")
            }
        })
    }
}