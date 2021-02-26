package com.mongoose.startersample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mongoose.starter.BaseViewModel

/**
 *  MainViewModel.kt
 *
 *  Created by jangwon on 2021/02/26
 *
 */

class MainViewModel : BaseViewModel() {
    private val _showLoading: MutableLiveData<Boolean> = MutableLiveData(true) // 로딩 표시
    val showLoading: LiveData<Boolean> = _showLoading
}