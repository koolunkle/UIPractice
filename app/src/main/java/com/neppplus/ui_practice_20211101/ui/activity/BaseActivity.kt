package com.neppplus.ui_practice_20211101.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.neppplus.ui_practice_20211101.R

abstract class BaseActivity : AppCompatActivity() {
  lateinit var mContext: Context
  lateinit var imgBack: ImageView
  lateinit var txtTitle: TextView
  lateinit var imgHome: ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mContext = this
    supportActionBar?.let {
      setCustomActionBar()
    }
  }

  abstract fun setupEvents()
  abstract fun setValues()

  private fun setCustomActionBar() {
    val defActionBar = supportActionBar!!
    defActionBar.displayOptions = androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
    defActionBar.setCustomView(R.layout.action_bar)

    imgBack = defActionBar.customView.findViewById(R.id.img_back)
    txtTitle = defActionBar.customView.findViewById(R.id.txt_title)
    imgHome = defActionBar.customView.findViewById(R.id.img_home)

    val toolBar = defActionBar.customView.parent as Toolbar
    toolBar.setContentInsetsAbsolute(0, 0)

    onClickListener()
  }

  private fun onClickListener() {
    imgBack.setOnClickListener {
      finish()
    }
  }
}