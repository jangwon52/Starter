package com.mongoose.starter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

// Created by mongoose on 2021/02/07

abstract class BaseBindingAdapter<ITEM : Any, B : ViewDataBinding> :
    RecyclerView.Adapter<BaseBindingViewHolder<B>>() {

    private val items = mutableListOf<ITEM>()

    fun replaceAll(items: List<ITEM>?) {
        items?.let {
            this.items.run {
                clear()
                addAll(it)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<B>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}