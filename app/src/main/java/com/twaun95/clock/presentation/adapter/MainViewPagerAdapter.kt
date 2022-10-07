package com.twaun95.clock.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.twaun95.clock.presentation.ui.alarm.AlarmFragment
import com.twaun95.clock.presentation.ui.stopwatch.StopwatchFragment
import com.twaun95.clock.presentation.ui.timer.TimerFragment

class MainViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TimerFragment.getInstance()
            1 -> StopwatchFragment.getInstance()
            else -> AlarmFragment.getInstance()
        }
    }
}