package com.twaun95.clock.presentation.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent

internal fun Context.startActivity(destination: Activity) {
    val intent = Intent(this, destination::class.java)
    startActivity(intent)
}
