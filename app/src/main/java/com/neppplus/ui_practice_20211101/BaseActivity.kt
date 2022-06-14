package com.neppplus.ui_practice_20211101

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, U : BaseViewModel>(@LayoutRes private val layoutRes: Int) : AppCompatActivity(layoutRes) {

  lateinit var binding: T
  abstract val getViewModel: U

  /**
   * ActionBar Contents
   */
  lateinit var mContext: Context
  lateinit var imgBack: ImageView
  lateinit var txtTitle: TextView
  lateinit var imgHome: ImageView

  abstract fun initView()
  open fun observe() = Unit

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, layoutRes)
    binding.apply {
      lifecycleOwner = this@BaseActivity
      setVariable(BR.viewModel, getViewModel)
      executePendingBindings()
    }
    supportActionBar?.let {
      setCustomActionBar()
    }
    initView()
    observe()
  }

  inline fun binding(block: T.() -> Unit) {
    binding.apply(block)
  }

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