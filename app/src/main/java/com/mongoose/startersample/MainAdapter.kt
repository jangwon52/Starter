package com.mongoose.startersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mongoose.starter.BaseBindingAdapter
import com.mongoose.starter.BaseBindingViewHolder
import com.mongoose.startersample.databinding.LayoutItemBinding

// Created by mongoose on 2021/02/09

class MainAdapter : BaseBindingAdapter<String, LayoutItemBinding>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
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
}