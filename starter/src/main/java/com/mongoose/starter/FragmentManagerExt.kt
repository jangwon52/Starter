package com.mongoose.starter

import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

// Created by mongoose on 2021/02/03

inline fun <reified T : Fragment> FragmentManager.replaceFragment(
    @IdRes containerViewId: Int,
    vararg extras: Pair<String, Any?>,
    tag: String = T::class.java.simpleName
): T? {
    return (findFragment() ?: T::class.java.newInstance()).also { newFragment ->
        newFragment.arguments = bundleOf(*extras)
        beginTransaction()
            .replace(containerViewId, newFragment, tag)
            .commitAllowingStateLoss()

    }
}

inline fun <reified T : Fragment> FragmentManager.findFragment(
    tag: String = T::class.java.simpleName
): T? {
    return findFragmentByTag(tag) as? T
}

inline fun <reified T : DialogFragment> FragmentManager.show(
    vararg extras: Pair<String, Any?>,
    tag: String = T::class.java.simpleName
): T? {
    val oldFragment = findFragment<T>()
    if (oldFragment != null && oldFragment.isAdded) return null

    return (oldFragment ?: T::class.java.newInstance()).also { newFragment ->
        newFragment.arguments = bundleOf(*extras)
        beginTransaction()
            .add(newFragment, tag)
            .commitAllowingStateLoss()
    }
}