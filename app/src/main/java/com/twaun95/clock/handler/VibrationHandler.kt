package com.twaun95.clock.handler

import android.content.Context
import android.os.*

class VibrationHandler(val context: Context) {
    private val vibrator by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        } else {
           context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
    }

    fun run() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            val effect = VibrationEffect.createOneShot(500L, VibrationEffect.DEFAULT_AMPLITUDE)
//            val combined = CombinedVibration.createParallel(effect)

            val timings = longArrayOf(600, 300, 200, 300, 200, 300, 200, 300)
            val amplitudes = intArrayOf(0, 100, 0, 100, 0, 100, 0, 100)
            val vibrationEffect = VibrationEffect.createWaveform(timings, amplitudes,0)
            val combinedVibration = CombinedVibration.createParallel(vibrationEffect)

            (vibrator as VibratorManager).vibrate(combinedVibration)
        } else {
//            val effect = VibrationEffect.createOneShot(500L, VibrationEffect.DEFAULT_AMPLITUDE)
            val timings = longArrayOf(600, 300, 200, 300, 200, 300, 200, 300)
            val amplitudes = intArrayOf(0, 100, 0, 100, 0, 100, 0, 100)
            val effect = VibrationEffect.createWaveform(timings, amplitudes, 0)
            (vibrator as Vibrator).vibrate(effect)
        }
    }

    fun cancel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            (vibrator as VibratorManager).cancel()
        } else {
            (vibrator as Vibrator).cancel()
        }
    }

    companion object {
        const val REPEAT_INFINITE = -1
    }
}