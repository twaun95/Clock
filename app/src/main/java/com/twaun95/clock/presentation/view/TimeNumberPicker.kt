package com.twaun95.clock.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.NumberPicker
import com.twaun95.clock.R

class TimeNumberPicker : NumberPicker {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TimeNumberPicker,
            defStyleAttr,
            defStyleAttr
        ).apply {
            try {
                this@TimeNumberPicker.setFormatter { "$it ${R.styleable.TimeNumberPicker_textFormat}" }
            } finally {
                recycle()
            }
        }

    }
}