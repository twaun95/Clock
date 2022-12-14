package com.twaun95.clock.presentation.extensions

import android.os.SystemClock
import android.view.View
import androidx.databinding.BindingAdapter
import com.twaun95.clock.R
import com.twaun95.clock.common.Logger

class OnSingleClickListener(
    private val onClickListener: (view: View) -> Unit
) : View.OnClickListener{
    companion object {
        const val INTERVAL = 200
    }

    private var lastClickedTime = 0L

    override fun onClick(view: View) {
        val onClickedTime = SystemClock.elapsedRealtime()
        // 간격보다 작으면 클릭 no
        if ((onClickedTime-lastClickedTime) < INTERVAL) { return }

        lastClickedTime = onClickedTime
        onClickListener.invoke(view)
    }
}

fun View.setOnSingleClickListener(
    onClickListener: (view: View) -> Unit
) {
    setOnClickListener(OnSingleClickListener(onClickListener))
}

//@BindingAdapter("android:onClick")
//fun onSingleClick(
//    view: View,
//    listener: View.OnClickListener
//) {
//    Logger.d("onSingleClick")
//    view.setOnClickListener(OnSingleClickListener(listener))
//}
