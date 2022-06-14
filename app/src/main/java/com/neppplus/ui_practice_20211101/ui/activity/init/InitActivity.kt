package com.neppplus.ui_practice_20211101.ui.activity.init

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivityInitBinding
import com.neppplus.ui_practice_20211101.BaseActivity
import com.neppplus.ui_practice_20211101.ui.activity.retrofit.RetrofitActivity
import com.neppplus.ui_practice_20211101.ui.activity.room.RoomActivity

class InitActivity : BaseActivity<ActivityInitBinding, InitViewModel>(R.layout.activity_init) {

  private val initViewModel: InitViewModel by viewModels()

  override val getViewModel: InitViewModel
    get() = initViewModel

  override fun initView() {
    observe()
  }

  override fun observe() {
    super.observe()
    initViewModel.initNavigation.observe(this, Observer {
      when (it) {
        InitNavigation.MOVE_RETROFIT -> {
          startActivity(Intent(this, RetrofitActivity::class.java))
        }
        InitNavigation.MOVE_ROOM -> {
          startActivity(Intent(this, RoomActivity::class.java))
        }
        else -> Unit
      }
    })
  }

}