package com.twaun95.clock.presentation.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.NumberPicker

class TimeNumberPicker : NumberPicker {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

    }
}