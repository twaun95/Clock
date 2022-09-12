package com.twaun95.clock.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.twaun95.clock.presentation.ui.stopwatch.Lap


@BindingAdapter("bind_lapTimeList")
fun bindLapTimeList(rvLapTime: RecyclerView, lapTimeList: List<Lap>) {
    lapTimeList.run {
        ((rvLapTime.adapter) as StopWatchLapAdapter).update(lapTimeList)
    }
}

