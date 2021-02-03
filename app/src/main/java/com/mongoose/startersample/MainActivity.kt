package com.mongoose.startersample

import android.os.Bundle
import com.mongoose.starter.BaseBindingActivity
import com.mongoose.startersample.databinding.ActivityMainBinding

// Created by mongoose on 2021/02/03

class MainActivity : BaseBindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainFragment.show(
            fragmentManager = supportFragmentManager,
            containerViewId = R.id.fl_container
        )
    }
}