package com.neppplus.ui_practice_20211101.ui.activity.retrofit

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivityRetrofitBinding
import com.neppplus.ui_practice_20211101.ui.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : BaseActivity<ActivityRetrofitBinding, RetrofitViewModel>(R.layout.activity_retrofit) {

  private val retrofitViewModel: RetrofitViewModel by viewModels()

  override val getViewModel: RetrofitViewModel
    get() = retrofitViewModel

  private lateinit var mRetrofitRecyclerViewAdapter: RetrofitRecyclerViewAdapter

  override fun initView() {
    initRecyclerView()
  }

  private fun initRecyclerView() {
    mRetrofitRecyclerViewAdapter = RetrofitRecyclerViewAdapter()
    binding.recyclerView.adapter = mRetrofitRecyclerViewAdapter
    binding.recyclerView.layoutManager = LinearLayoutManager(this)
  }

  override fun observe() {
    super.observe()
    retrofitViewModel.getLiveDataObserver().observe(this, Observer {
      if (it != null) {
        mRetrofitRecyclerViewAdapter.setDataList(it)
        mRetrofitRecyclerViewAdapter.notifyDataSetChanged()
      } else {
        Toast.makeText(this, "데이터를 가져오는데 실패하였습니다", Toast.LENGTH_SHORT).show()
      }
    })
    retrofitViewModel.loadDataList()
  }

}