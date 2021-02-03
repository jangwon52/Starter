package com.mongoose.startersample

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.mongoose.starter.BaseBindingFragment
import com.mongoose.starter.replaceFragment
import com.mongoose.startersample.databinding.FragmentMainBinding

// Created by mongoose on 2021/02/03

class MainFragment : BaseBindingFragment<FragmentMainBinding>(R.layout.fragment_main) {

    companion object {
        fun show(
            fragmentManager: FragmentManager,
            @IdRes containerViewId: Int
        ): MainFragment? {
            return fragmentManager.replaceFragment(containerViewId)
        }
    }
}