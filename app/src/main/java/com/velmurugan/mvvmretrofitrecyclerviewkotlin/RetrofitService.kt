package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    //https://raw.githubusercontent.com/matumotokohei/testJson/master/json/sample.json

    @GET("sample.json")
    fun getAllJsonA() : Call<List<JsonA>>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/matumotokohei/testJson/master/json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}