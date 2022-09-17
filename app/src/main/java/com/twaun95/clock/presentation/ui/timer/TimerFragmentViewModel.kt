package com.twaun95.clock.presentation.ui.timer

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.core.base.BaseViewModel
import java.util.*
import kotlin.concurrent.timer

class TimerFragmentViewModel : BaseViewModel() {

    val viewState by lazy { MutableNonNullLiveData(TimerViewState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val min by lazy { MutableNonNullLiveData("0") }
    val sec by lazy { MutableNonNullLiveData("0") }
    val mSec by lazy { MutableNonNullLiveData("0") }

    private fun setTimer(timer: Int) {
        time.value = timer
        min.value = (time.value/6000).toString()
        sec.value = ((time.value/100)%60).toString()
        mSec.value = (time.value%100).toString()
    }

    fun timerPauseOrPlay() {
        when(viewState.value) {
            TimerViewState.IDLE -> {}
            TimerViewState.RUNNING -> {
                pauseTimer()
            }
            TimerViewState.PAUSE -> {
                playTimer()
            }
        }
    }

    fun startTimer(hour: Int, minute: Int, sec: Int) {
        setTimer(minute*100 + sec)
        playTimer()
    }

    fun cancelTimer() {
        viewState.value = TimerViewState.IDLE

        timerTask?.cancel()
        time.value = 0
        min.value = 0.toString()
        sec.value = 0.toString()
        mSec.value = 0.toString()
    }

    private fun playTimer() {
        viewState.value = TimerViewState.RUNNING

        timerTask = timer(period = 10){
            if (time.value<=0) cancel()
            time.postValue(time.value.minus(1))
            min.postValue((time.value/6000).toString())
            sec.postValue(((time.value/100)%60).toString())
            mSec.postValue((time.value%100).toString())
        }
    }

    private fun pauseTimer() {
        viewState.value = TimerViewState.PAUSE
        timerTask?.cancel()
    }


}