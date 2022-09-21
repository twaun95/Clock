package com.twaun95.clock.presentation.extensions

import java.text.DecimalFormat

fun Int.toDigitFormat() : String{
    val formatted = DecimalFormat("00")
    return formatted.format(this)
}
