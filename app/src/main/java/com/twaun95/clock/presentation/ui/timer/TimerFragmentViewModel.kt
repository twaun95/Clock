package com.twaun95.clock.presentation.ui.timer

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.clock.presentation.extensions.toDigitFormat
import com.twaun95.clock.handler.VibrationHandler
import com.twaun95.clock.presentation.models.TimerViewState
import com.twaun95.core.base.BaseViewModel
import java.util.*
import kotlin.concurrent.timer

class TimerFragmentViewModel(
    private val vibrationHandler: VibrationHandler
) : BaseViewModel() {

    val viewState by lazy { MutableNonNullLiveData(TimerViewState.IDLE) }

    val time by lazy { MutableNonNullLiveData(0) } // 1000-1초
    private var timerTask: Timer? = null

    val max by lazy { MutableNonNullLiveData(0) }
    val hour by lazy { MutableNonNullLiveData("00") }
    val minute by lazy { MutableNonNullLiveData("00") }
    val sec by lazy { MutableNonNullLiveData("00") }

    fun timerPauseOrPlay() {
        when (viewState.value) {
            TimerViewState.IDLE -> {}
            TimerViewState.RUNNING -> {
                pauseTimer()
            }
            TimerViewState.PAUSE -> {
                playTimer()
            }
            TimerViewState.FINISHED -> {}
        }
    }

    fun startTimer(hour: Int, minute: Int, sec: Int) {
        max.value = hour * 360000 + minute * 6000 + sec * 100
        setTimer(hour * 360000 + minute * 6000 + sec * 100)
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
        hour.value = (time.value / 360000).toDigitFormat()
        minute.value = ((time.value / 6000) % 60).toDigitFormat()
        sec.value = ((time.value % 6000) / 100).toDigitFormat()
    }

    private fun playTimer() {
        viewState.value = TimerViewState.RUNNING
        timerTask = timer(period = 10) {
            if (time.value <= 0) {
                cancel()
                viewState.postValue(TimerViewState.FINISHED)
                finishTimer()
            }
            hour.postValue((time.value / 360000).toDigitFormat())
            minute.postValue(((time.value / 6000) % 60).toDigitFormat())
            sec.postValue(((time.value % 6000) / 100).toDigitFormat())
            time.postValue(time.value.minus(1))
        }
    }

    private fun pauseTimer() {
        viewState.value = TimerViewState.PAUSE
        timerTask?.cancel()
    }

    private fun finishTimer() {
        vibrationHandler.run()
    }

    fun reset() {
        viewState.value = TimerViewState.IDLE
        vibrationHandler.cancel()
    }
}