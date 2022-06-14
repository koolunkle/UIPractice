package com.neppplus.ui_practice_20211101.ui.activity.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.ui_practice_20211101.databinding.AdapterRoomBinding
import com.neppplus.ui_practice_20211101.db.entity.AppEntity

class RoomRecyclerViewAdapter() : PagingDataAdapter<AppEntity, RoomRecyclerViewAdapter.RoomViewHolder>(DiffUtilCallback()) {
  inner class RoomViewHolder(private val binding: AdapterRoomBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(appEntity: AppEntity) {
      binding.txtName.text = appEntity.name
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomRecyclerViewAdapter.RoomViewHolder {
    val binding = AdapterRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RoomViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RoomRecyclerViewAdapter.RoomViewHolder, position: Int) {
    holder.bind(getItem(position)!!)
    // RecyclerView Item Interval Control
    val layoutParams = holder.itemView.layoutParams
    layoutParams.height = 100
    holder.itemView.requestLayout()
  }

  /**
   * 기존 및 업데이트 된 List 차이를 계산하고 실제로 변환할 List Item 결과를 반환하는 Utility Class
   * RecyclerView Adapter 의 업데이트를 계산하는데 사용되고 List Adapter (또는 Paging Adapter) 에서 활용
   */
  class DiffUtilCallback : DiffUtil.ItemCallback<AppEntity>() {
    // 두 아이템이 동일한 아이템인지 체크: 보통 고유한 'id' 를 기준으로 비교
    override fun areItemsTheSame(oldItem: AppEntity, newItem: AppEntity): Boolean {
      return oldItem.id == newItem.id
    }

    // 두 아이템이 동일한 내용을 가지고 있는지 체크: areItemsTheSame()이 true 일 때 호출
    override fun areContentsTheSame(oldItem: AppEntity, newItem: AppEntity): Boolean {
      return oldItem == newItem
    }
  }
}