package com.twaun95.clock.presentation.ui.stopwatch

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LapLayoutManager(context: Context) : LinearLayoutManager(context, VERTICAL, false){

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
        lp.height = height / 5
        return true
    }

}