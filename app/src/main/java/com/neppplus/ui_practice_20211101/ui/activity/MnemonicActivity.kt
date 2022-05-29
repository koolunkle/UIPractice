package com.neppplus.ui_practice_20211101.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.neppplus.ui_practice_20211101.model.MnemonicData
import com.neppplus.ui_practice_20211101.R
import com.neppplus.ui_practice_20211101.databinding.ActivityMnemonicBinding
import com.neppplus.ui_practice_20211101.ui.adapter.MnemonicAdapter

class MnemonicActivity : BaseActivity() {

    lateinit var binding: ActivityMnemonicBinding

    private lateinit var mMnemonicAdapter: MnemonicAdapter

    private val mMnemonicList = ArrayList<MnemonicData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mnemonic)
        binding.btnContinue.isEnabled = false
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
        mMnemonicAdapter.onItemClickListener = object : MnemonicAdapter.OnItemClickListener {
            override fun onItemClickListener(isClicked: Boolean) {
                binding.btnContinue.isEnabled = isClicked
            }
        }

        binding.btnContinue.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        val res = resources.getStringArray(R.array.mnemonic_array)
        for (i in res.indices) {
            mMnemonicList.add(MnemonicData(res[i]))
        }
        mMnemonicAdapter = MnemonicAdapter(mContext, mMnemonicList)
        binding.rvMnemonic.adapter = mMnemonicAdapter
        binding.rvMnemonic.layoutManager = GridLayoutManager(this, 3)
        (binding.rvMnemonic.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        txtTitle.text = resources.getText(R.string.mnemonic)

        /* binding.rvMnemonic.addItemDecoration(VerticalItemDecorator(10))
        binding.rvMnemonic.addItemDecoration(HorizontalItemDecorator(10)) */
    }
}