package com.twaun95.clock.presentation.ui.stopwatch

import androidx.recyclerview.widget.DiffUtil

class LapDiffUtilCallBack(
    private val oldList: List<Lap>,
    private val newList: List<Lap>,
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].order == newList[newItemPosition].order
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].order == newList[newItemPosition].order
    }
}