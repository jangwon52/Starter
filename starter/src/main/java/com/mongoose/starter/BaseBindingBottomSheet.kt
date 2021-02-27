package com.mongoose.starter

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// Created by mongoose on 2021/02/27

/*
 * @description
 * support library -> design_bottom_sheet.xml inflate 시점 FrameLayout 자동으로 wrap_content
 * 이 클래스를 구현한 Fragment 최상위 Layout + 높이가 지정된 자식 Layout을 하나 두어야 한다.
 *
 * https://github.com/dandar3/android-support-design/blob/master/res/layout/design_bottom_sheet_dialog.xml
 *
 */

abstract class BaseBindingBottomSheet<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    BottomSheetDialogFragment() {

    protected lateinit var binding: T

    lateinit var bottomSheet: FrameLayout
    lateinit var sheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                bottomSheet =
                    findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as? FrameLayout
                        ?: throw IllegalArgumentException()
                sheetBehavior = BottomSheetBehavior.from(bottomSheet).apply {
                    state = BottomSheetBehavior.STATE_EXPANDED
                }
            }
        }
    }
}