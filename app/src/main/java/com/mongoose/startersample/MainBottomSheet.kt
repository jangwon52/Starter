package com.mongoose.startersample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.mongoose.starter.BaseBindingBottomSheet
import com.mongoose.starter.show
import com.mongoose.startersample.databinding.BottomSheetMainBinding

// Created by mongoose on 2021/02/27

class MainBottomSheet :
    BaseBindingBottomSheet<BottomSheetMainBinding>(R.layout.bottom_sheet_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDialog.setOnClickListener {
            MainDialog.show(childFragmentManager)
        }
    }

    companion object {
        fun show(
            fragmentManager: FragmentManager
        ): MainBottomSheet? {
            return fragmentManager.show()
        }
    }
}