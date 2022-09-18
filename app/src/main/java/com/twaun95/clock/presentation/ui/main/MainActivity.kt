package com.twaun95.clock.presentation.ui.main

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.twaun95.clock.R
import com.twaun95.clock.databinding.ActivityMainBinding
import com.twaun95.clock.service.AlarmReceiver
import com.twaun95.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(R.layout.activity_main) {
    override val viewModel: MainActivityViewModel by viewModel()

    override fun initView() {
        super.initView()
        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {
        binding.viewPager.apply {
            isUserInputEnabled = false
            adapter = MainViewPagerAdapter(this@MainActivity)
        }
    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.apply {
            itemIconTintList = null
            setOnItemSelectedListener { page ->
                when(page.itemId) {
                    R.id.page_alarm -> {
                        binding.viewPager.setCurrentItem(0, false)
                        true
                    }
                    R.id.page_stop_watch -> {
                        binding.viewPager.setCurrentItem(1, false)
                        true
                    }
                    R.id.page_timer -> {
                        binding.viewPager.setCurrentItem(2, false)
                        true
                    }
                    else -> { false }
                }
            }
        }
    }
}