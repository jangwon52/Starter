package com.mongoose.startersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.mongoose.starter.BaseBindingViewHolder
import com.mongoose.starter.BaseDiffCallbackAdapter
import com.mongoose.startersample.databinding.LayoutItemBinding

/**
 *  MainDiffCallbackAdapter.kt
 *
 *  Created by jangwon on 2021/02/26
 *
 */

class MainDiffCallbackAdapter : BaseDiffCallbackAdapter<String, LayoutItemBinding>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseBindingViewHolder<LayoutItemBinding> {
        val binding = DataBindingUtil.inflate<LayoutItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_item,
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    inner class MainViewHolder(binding: LayoutItemBinding) :
        BaseBindingViewHolder<LayoutItemBinding>(
            binding = binding,
            bindingVariableId = BR.value
        )

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String,
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String,
        ): Boolean {
            return oldItem == newItem
        }
    }
}