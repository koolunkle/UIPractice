package com.neppplus.ui_practice_20211101.ui.activity.send

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivitySendBinding
import com.neppplus.ui_practice_20211101.ui.activity.BaseActivity
import com.neppplus.ui_practice_20211101.ui.activity.mnemonic.MnemonicActivity

class SendActivity : BaseActivity() {

    private lateinit var binding: ActivitySendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.imgContinue.setOnClickListener {
            val myIntent = Intent(mContext, MnemonicActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        txtTitle.text = resources.getText(R.string.send_guru)
    }
}