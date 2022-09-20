package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.clock.presentation.extensions.toDigitFormat
import com.twaun95.clock.presentation.extensions.toDivFormat
import com.twaun95.core.base.BaseViewModel
import java.text.DecimalFormat
import java.util.*
import kotlin.concurrent.timer

class StopwatchFragmentViewModel : BaseViewModel() {

    //TODO uniform 딱 맞게 구현
    val state by lazy { MutableNonNullLiveData<StopWatchState>(StopWatchState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val minute by lazy { MutableNonNullLiveData("00") }
    val sec by lazy { MutableNonNullLiveData("00") }
    val mSec by lazy { MutableNonNullLiveData("00") }

    val lapList = mutableListOf<Lap>()



    fun playOrPause() {
        when (state.value) {
            StopWatchState.IDLE -> {
                startTimer()
            }
            StopWatchState.RUNNING -> {
                pauseTimer()
            }
            StopWatchState.PAUSE -> {
                startTimer()
            }
        }
    }


    fun reset() {
        resetTimer()
        resetLapTime()
    }

    fun startTimer() {
        state.value = StopWatchState.RUNNING
        timerTask = timer(period = 10){
            time.postValue(time.value.plus(1))
            minute.postValue((time.value/6000).toDigitFormat(2))
            sec.postValue(((time.value/100)%60).toDigitFormat(2))
            mSec.postValue((time.value%100).toDigitFormat(2))
        }
    }

    fun pauseTimer() {
        timerTask?.cancel()
        state.value = StopWatchState.PAUSE
    }

    private fun resetTimer() {
        timerTask?.cancel()
        time.value = 0
        minute.postValue(0.toDigitFormat(2))
        sec.postValue(0.toDigitFormat(2))
        mSec.postValue(0.toDigitFormat(2))
        state.value = StopWatchState.IDLE
    }

    fun addLapTime() = lapList.add(0, Lap(lapList.size+1, time.value))
    private fun resetLapTime() = lapList.clear()
}