package com.mongoose.starter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

// Created by mongoose on 2021/02/07

abstract class BaseBindingViewHolder<B : ViewDataBinding>(
    private val binding: B,
    @LayoutRes private val bindingVariableId: Int?
) : RecyclerView.ViewHolder(
    binding.root
) {
    fun bind(item: Any?) {
        try {
            bindingVariableId?.let {
                binding.setVariable(it, item)
                binding.executePendingBindings()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}