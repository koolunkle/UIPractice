package com.neppplus.ui_practice_20211101.ui.activity.buy

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivityBuyBinding
import com.neppplus.ui_practice_20211101.ui.activity.send.SendActivity

class BuyActivity : com.neppplus.ui_practice_20211101.BaseActivity() {

  private lateinit var binding: ActivityBuyBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_buy)
    setupEvents()
    setValues()
  }

  override fun setupEvents() {
    binding.imgContinue.setOnClickListener {
      val myIntent = Intent(this, SendActivity::class.java)
      startActivity(myIntent)
    }
  }

  override fun setValues() {}
}