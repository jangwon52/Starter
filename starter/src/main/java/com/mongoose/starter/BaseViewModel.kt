package com.mongoose.starter

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 *  BaseViewModel.kt
 *
 *  Created by jangwon on 2021/02/26
 *
 */

open class BaseViewModel : ViewModel() {
    protected val disposeBag = CompositeDisposable()

    override fun onCleared() {
        disposeBag.dispose()
        super.onCleared()
    }
}