package com.mongoose.startersample

import androidx.fragment.app.FragmentManager
import com.mongoose.starter.BaseBindingDialog
import com.mongoose.starter.show
import com.mongoose.startersample.databinding.DialogMainBinding

// Created by mongoose on 2021/02/27

class MainDialog :
    BaseBindingDialog<DialogMainBinding>(R.layout.dialog_main) {

    companion object {
        fun show(
            fragmentManager: FragmentManager
        ): MainDialog? {
            return fragmentManager.show()
        }
    }
}