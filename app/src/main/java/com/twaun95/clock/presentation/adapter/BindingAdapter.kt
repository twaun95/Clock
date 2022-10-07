package com.twaun95.clock.presentation.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.twaun95.clock.presentation.models.Lap


@BindingAdapter("bind_lapTimeList")
fun bindLapTimeList(rvLapTime: RecyclerView, lapTimeList: List<Lap>) {
    lapTimeList.run {
        ((rvLapTime.adapter) as StopWatchLapAdapter).update(lapTimeList)
    }
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

