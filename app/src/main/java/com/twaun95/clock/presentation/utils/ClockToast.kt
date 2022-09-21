package com.twaun95.clock.presentation.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.twaun95.clock.R
import com.twaun95.clock.databinding.ViewToastBinding
import com.twaun95.clock.presentation.extensions.toPx

object ClockToast {

    fun show(context: Context, message: String, toastDuration : Int = Toast.LENGTH_SHORT) {
        val binding: ViewToastBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_toast, null, false)

        binding.toastText.text = message

        Toast(context).apply {
            setGravity(Gravity.TOP or Gravity.CENTER, 0, 60.toPx())
            duration = toastDuration
            view = binding.root
        }.show()
    }
}