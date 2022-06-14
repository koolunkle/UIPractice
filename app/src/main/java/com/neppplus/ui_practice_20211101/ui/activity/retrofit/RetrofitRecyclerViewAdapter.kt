package com.neppplus.ui_practice_20211101.ui.activity.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neppplus.ui_practice_20211101.databinding.AdapterRetrofitBinding
import com.neppplus.ui_practice_20211101.network.RetrofitData

class RetrofitRecyclerViewAdapter : RecyclerView.Adapter<RetrofitRecyclerViewAdapter.RetrofitViewHolder>() {
  private var dataList: List<RetrofitData>? = null

  fun setDataList(dataList: List<RetrofitData>?) {
    this.dataList = dataList
  }

  inner class RetrofitViewHolder(private val binding: AdapterRetrofitBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: RetrofitData) {
      Glide.with(binding.imgUser).load(data.avatarUrl).into(binding.imgUser)
      binding.txtUser.text = data.login
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
    val binding = AdapterRetrofitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RetrofitViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
    holder.onBind(dataList?.get(position)!!)
    // RecyclerView Item Interval Control
    val layoutParams = holder.itemView.layoutParams
    layoutParams.height = 100
    holder.itemView.requestLayout()
  }

  override fun getItemCount(): Int {
    if (dataList == null) return 0
    return dataList?.size!!
  }
}