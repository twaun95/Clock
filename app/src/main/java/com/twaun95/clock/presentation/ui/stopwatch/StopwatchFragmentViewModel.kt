package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.clock.presentation.extensions.toDigitFormat
import com.twaun95.clock.presentation.models.Lap
import com.twaun95.clock.presentation.models.StopWatchState
import com.twaun95.core.base.BaseViewModel
import java.util.*
import kotlin.concurrent.timer

class StopwatchFragmentViewModel : BaseViewModel() {

    val state by lazy { MutableNonNullLiveData<StopWatchState>(StopWatchState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val minute by lazy { MutableNonNullLiveData("00") }
    val sec by lazy { MutableNonNullLiveData("00") }
    val mSec by lazy { MutableNonNullLiveData("00") }

    val lapList = mutableListOf<Lap>()


    fun playOrPause() {
        when (state.value) {
            StopWatchState.IDLE -> { startTimer() }
            StopWatchState.RUNNING -> { pauseTimer() }
            StopWatchState.PAUSE -> { startTimer() }
        }
    }

    fun reset() {
        resetTimer()
        resetLapTime()
    }

    private fun startTimer() {
        state.value = StopWatchState.RUNNING
        timerTask = timer(period = 10) {
            time.postValue(time.value.plus(1))
            minute.postValue((time.value / 6000).toDigitFormat())
            sec.postValue(((time.value / 100) % 60).toDigitFormat())
            mSec.postValue((time.value % 100).toDigitFormat())
        }
    }

    fun pauseTimer() {
        timerTask?.cancel()
        state.value = StopWatchState.PAUSE
    }

    private fun resetTimer() {
        timerTask?.cancel()
        time.value = 0
        minute.postValue(0.toDigitFormat())
        sec.postValue(0.toDigitFormat())
        mSec.postValue(0.toDigitFormat())
        state.value = StopWatchState.IDLE
    }

    fun addLapTime() {
        val beforeTime = lapList.firstOrNull()?.fullTime ?: 0
        lapList.add(0, Lap(lapList.size + 1, time.value - beforeTime, time.value))
    }

    private fun resetLapTime() = lapList.clear()
}