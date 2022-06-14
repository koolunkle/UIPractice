package com.neppplus.ui_practice_20211101.network

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {
  @GET("/users")
  fun getRequestUsers(): Call<List<RetrofitData>>
}