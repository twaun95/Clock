package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.core.base.BaseViewModel
import java.text.DecimalFormat
import java.util.*
import kotlin.concurrent.timer

class StopwatchFragmentViewModel : BaseViewModel() {

    val state by lazy { MutableNonNullLiveData<StopWatchState>(StopWatchState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val lapList = mutableListOf<Lap>()

    fun reset() {
        resetTimer()
        resetLapTime()
    }

    fun startTimer() {
        state.value = StopWatchState.RUNNING
        timerTask = timer(period = 10){
            time.postValue(time.value.plus(1))
        }
    }

    fun pauseTimer() {
        timerTask?.cancel()
        state.value = StopWatchState.PAUSE
    }

    private fun resetTimer() {
        timerTask?.cancel()
        time.value = 0
        state.value = StopWatchState.IDLE
    }

    fun addLapTime() = lapList.add(0, Lap(lapList.size+1, time.value))
    private fun resetLapTime() = lapList.clear()
}