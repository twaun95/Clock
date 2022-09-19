package com.twaun95.clock.presentation.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import com.twaun95.clock.R
import java.text.DecimalFormat

class StopWatchText : AppCompatTextView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.StopWatchText,
            defStyleAttr,
            defStyleAttr
        ).apply {
            try {
                this@StopWatchText.time = getInt(R.styleable.StopWatchText_time, 0)
//                this@StopWatchText.text = timeDivide(time)
            } finally {
                recycle()
            }
        }
    }

    private var time: Int


    fun setTime(inputTime: Int) {
        this.time = inputTime
        invalidate()
    }

    private fun timeDivide(time: Int) : String {

        val min: String = stringFormat((time/6000))
        val sec: String = stringFormat((time/100)%60)
        val mSec: String = stringFormat(time%100)

        return "$min:$sec.$mSec"
    }

    private fun stringFormat(timeValue: Any) : String{
        val pattern = DecimalFormat("00")
        return pattern.format(timeValue)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        measureText()
        canvas.drawText(timeDivide(this.time), 0f, (height / 2) - (paint.descent() + paint.ascent()) / 2, paint)
    }
}