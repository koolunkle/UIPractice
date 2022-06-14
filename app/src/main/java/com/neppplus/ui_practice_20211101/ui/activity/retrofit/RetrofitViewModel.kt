package com.neppplus.ui_practice_20211101.ui.activity.retrofit

import androidx.lifecycle.MutableLiveData
import com.neppplus.ui_practice_20211101.network.RetrofitData
import com.neppplus.ui_practice_20211101.network.RetrofitRepository
import com.neppplus.ui_practice_20211101.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RetrofitViewModel @Inject constructor(private val repository: RetrofitRepository) : BaseViewModel() {
  var liveDataList: MutableLiveData<List<RetrofitData>> = MutableLiveData()

  fun getLiveDataObserver(): MutableLiveData<List<RetrofitData>> {
    return liveDataList
  }

  fun loadDataList() {
    repository.callApi(liveDataList)
  }
}