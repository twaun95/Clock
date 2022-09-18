package com.twaun95.clock.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.twaun95.clock.databinding.ItemLapBinding
import com.twaun95.clock.presentation.ui.stopwatch.Lap
import com.twaun95.clock.presentation.ui.stopwatch.LapDiffUtilCallBack

class StopWatchLapAdapter : RecyclerView.Adapter<StopWatchLapAdapter.LapViewHolder>(){

    private val itemList = mutableListOf<Lap>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LapViewHolder {
        return LapViewHolder(ItemLapBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LapViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun update(newList: List<Lap>) {
        val diffUtilCallBack = LapDiffUtilCallBack(itemList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallBack)

        itemList.clear()
        itemList.addAll(newList)

        diffResult.dispatchUpdatesTo(this)

    }

    inner class LapViewHolder(
        private val binding: ItemLapBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            lapData: Lap
        ) {
            binding.tvOrder.text = lapData.order.toString()
            binding.tvLaptime.text = "${lapData.minute}m ${lapData.sec}s ${lapData.mSec}ms"
        }
    }
}

