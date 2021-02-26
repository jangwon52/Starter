package com.mongoose.starter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 *  BaseDiffCallbackAdapter.kt
 *
 *  Created by jangwon on 2021/02/26
 *
 */

abstract class BaseDiffCallbackAdapter<ITEM : Any, B : ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<ITEM>) :
    ListAdapter<ITEM, BaseBindingViewHolder<B>>(diffCallback) {

    override fun onBindViewHolder(holder: BaseBindingViewHolder<B>, position: Int) =
        holder.bind(getItem(position))
}