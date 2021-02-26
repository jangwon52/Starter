package com.mongoose.startersample

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.mongoose.starter.BaseBindingFragment
import com.mongoose.starter.replaceFragment
import com.mongoose.startersample.databinding.FragmentMainBinding

// Created by mongoose on 2021/02/03

class MainFragment : BaseBindingFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<String>()
        for (i in 0..100) {
            list.add(getString(R.string.app_name))
        }
        val adapter = MainDiffCallbackAdapter().apply {
            submitList(list)
        }

        binding.rvMain.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel
    }

    companion object {
        fun show(
            fragmentManager: FragmentManager,
            @IdRes containerViewId: Int,
        ): MainFragment? {
            return fragmentManager.replaceFragment(containerViewId)
        }
    }
}