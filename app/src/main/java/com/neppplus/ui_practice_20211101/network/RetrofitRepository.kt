package com.neppplus.ui_practice_20211101.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {
  fun callApi(livedataList: MutableLiveData<List<RetrofitData>>) {
    val call: Call<List<RetrofitData>> = retrofitServiceInstance.getRequestUsers()
    call?.enqueue(object : Callback<List<RetrofitData>> {
      override fun onResponse(call: Call<List<RetrofitData>>, response: Response<List<RetrofitData>>) {
        livedataList.postValue(response.body())
      }

      override fun onFailure(call: Call<List<RetrofitData>>, t: Throwable) {
        livedataList.postValue(null)
      }
    })
  }
}