package com.neppplus.ui_practice_20211101.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.ui_practice_20211101.model.MnemonicData
import com.neppplus.ui_practice_20211101.R

class MnemonicAdapter(
    val mContext: Context,
    private val mMnemonicList: List<MnemonicData>,
    private var selectedItem: Int = -1,
    var onItemClickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<MnemonicAdapter.MnemonicViewHolder>() {

    interface OnItemClickListener {
        fun onItemClickListener(isClicked: Boolean)
    }

    inner class MnemonicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtMnemonic = view.findViewById<TextView>(R.id.txtMnemonic)

        fun bind(data: MnemonicData) {
            txtMnemonic.text = data.word
            txtMnemonic.setOnClickListener {
                if (selectedItem != -1)
                    notifyItemChanged(selectedItem)
                selectedItem = adapterPosition
                notifyItemChanged(selectedItem)

                data.isClicked = !data.isClicked
                onItemClickListener?.onItemClickListener(false)
            }

            /*cbMnemonic.setOnClickListener {
               if (lastSelectedItem != -1) {
                   mMnemonicList[lastSelectedItem].isChecked = false
               }
               lastSelectedItem = position
               data.isChecked = !data.isChecked
               notifyDataSetChanged()
               onItemClickListener?.onItemClickListener(true)
           }*/
        }

        fun defaultBackground() {
            txtMnemonic.background = mContext.getDrawable(R.drawable.mnemonic_type_01)
        }

        fun selectedBackground() {
            txtMnemonic.background = mContext.getDrawable(R.drawable.mnemonic_type_02)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MnemonicViewHolder {
        val row =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_mnemonic, parent, false)
        return MnemonicViewHolder(row)
    }

    override fun onBindViewHolder(holder: MnemonicViewHolder, position: Int) {
        if (mMnemonicList[position].isClicked && position == selectedItem) {
            holder.selectedBackground()
            onItemClickListener?.onItemClickListener(true)
        } else {
            holder.defaultBackground()
            mMnemonicList[position].isClicked = false
        }
        holder.bind(mMnemonicList[position])

        /* val mContext = holder.itemView.context
        val leftPadding = 7 * mContext.resources.displayMetrics.density.toInt()
        val rightPadding = 6 * mContext.resources.displayMetrics.density.toInt()

        if (position % 3 == 1)
            holder.itemView.setPadding(
                leftPadding,
                holder.itemView.paddingTop,
                rightPadding,
                holder.itemView.paddingBottom
            ) */

        /* val layoutHeight = holder.itemView.layoutParams
        layoutHeight.height = 100
        holder.itemView.requestLayout() */
    }

    override fun getItemCount() = mMnemonicList.size

}