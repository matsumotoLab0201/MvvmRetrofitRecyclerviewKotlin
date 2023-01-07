package com.velmurugan.mvvmretrofitrecyclerviewkotlin

data class JsonA(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val station: String,
    val walk: Int,
    val time: Int,
    var cost1: Int,
    val cost2: Int,
    )