package com.twaun95.clock.presentation.ui.timer

import androidx.lifecycle.viewModelScope
import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.core.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timer

class TimerFragmentViewModel : BaseViewModel() {

    val viewState by lazy { MutableNonNullLiveData(TimerViewState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val max by lazy { MutableNonNullLiveData(0) }
    val hour by lazy { MutableNonNullLiveData("0") }
    val minute by lazy { MutableNonNullLiveData("0") }
    val sec by lazy { MutableNonNullLiveData("0") }

    fun timerPauseOrPlay() {
        when(viewState.value) {
            TimerViewState.IDLE -> {}
            TimerViewState.RUNNING -> { pauseTimer() }
            TimerViewState.PAUSE -> { playTimer() }
        }
    }

    fun startTimer(hour: Int, minute: Int, sec: Int) {
        max.value = hour*360000 + minute*6000 + sec*100
        setTimer(hour*360000 + minute*6000 + sec*100)
        playTimer()
    }

    fun cancelTimer() {
        viewState.value = TimerViewState.IDLE

        timerTask?.cancel()
        time.value = 0
        hour.value = 0.toString()
        minute.value = 0.toString()
        sec.value = 0.toString()
    }

    private fun setTimer(timer: Int) {
        time.value = timer
        hour.value = (time.value/360000).toString()
        minute.value = ((time.value/6000) % 60).toString()
        sec.value = ((time.value%6000) / 100).toString()
    }

    private fun playTimer() {
        viewState.value = TimerViewState.RUNNING

        viewModelScope.launch {
            delay(1000L)
            timerTask = timer(period = 10){
                if (time.value<=0) cancel()
                hour.postValue((time.value/360000).toString())
                minute.postValue(((time.value/6000) % 60).toString())
                sec.postValue(((time.value%6000) / 100).toString())
                time.postValue(time.value.minus(1))
            }
        }

    }

    private fun pauseTimer() {
        viewState.value = TimerViewState.PAUSE
        timerTask?.cancel()
    }
}