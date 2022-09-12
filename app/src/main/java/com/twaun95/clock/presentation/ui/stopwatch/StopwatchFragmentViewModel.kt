package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.core.base.BaseViewModel
import java.util.*
import kotlin.concurrent.timer

class StopwatchFragmentViewModel : BaseViewModel() {

    val state by lazy { MutableNonNullLiveData<StopWatchState>(StopWatchState.IDLE) }

    private var time = 0 // 1000-1초
    private var timerTask: Timer? = null

    val min by lazy { MutableNonNullLiveData("0") }
    val sec by lazy { MutableNonNullLiveData("0") }
    val mSec by lazy { MutableNonNullLiveData("0") }

    val lapList = mutableListOf<Lap>()

    fun reset() {
        resetTimer()
        resetLapTime()
    }

    fun startTimer() {
        state.value = StopWatchState.RUNNING
        timerTask = timer(period = 10){
            time++
            min.postValue((time/6000).toString())
            sec.postValue(((time/100)%60).toString())
            mSec.postValue((time%100).toString())
        }
    }

    fun pauseTimer() {
        timerTask?.cancel()
        state.value = StopWatchState.PAUSE
    }

    private fun resetTimer() {
        timerTask?.cancel()
        time = 0
        min.value = 0.toString()
        sec.value = 0.toString()
        mSec.value = 0.toString()

        state.value = StopWatchState.IDLE
    }

    fun addLapTime() = lapList.add(0, Lap(lapList.size+1, time))
    private fun resetLapTime() = lapList.clear()
}