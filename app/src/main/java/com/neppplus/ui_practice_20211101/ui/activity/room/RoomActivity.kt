package com.neppplus.ui_practice_20211101.ui.activity.room

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivityRoomBinding
import com.neppplus.ui_practice_20211101.ui.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomActivity : BaseActivity<ActivityRoomBinding, RoomViewModel>(R.layout.activity_room) {

  private val roomViewModel: RoomViewModel by viewModels()

  override val getViewModel: RoomViewModel
    get() = roomViewModel

  private lateinit var mRoomRecyclerViewAdapter: RoomRecyclerViewAdapter

  override fun initView() {
    initRecyclerView()
    observe()
  }

  private fun initRecyclerView() {
    mRoomRecyclerViewAdapter = RoomRecyclerViewAdapter()

    binding.recyclerView.apply {
      adapter = mRoomRecyclerViewAdapter
      layoutManager = LinearLayoutManager(this@RoomActivity)
    }
    divider()
  }

  override fun observe() {
    super.observe()
    lifecycleScope.launch {
      roomViewModel.getAllRecords().collectLatest {
        mRoomRecyclerViewAdapter.submitData(it)
      }
    }
    roomViewModel.insertAppRecords()
  }

  private fun divider() {
    val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
    binding.recyclerView.addItemDecoration(decoration)
  }

}