package com.mongoose.starter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

// Created by mongoose on 2021/02/07

abstract class BaseBindingViewHolder<B : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes private val layoutResId: Int,
    @LayoutRes private val bindingVariableId: Int?
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {

    protected var binding: B? = DataBindingUtil.bind(itemView)

    fun onBindViewHolder(item: Any?) {
        try {
            bindingVariableId?.let {
                binding?.setVariable(it, item)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}