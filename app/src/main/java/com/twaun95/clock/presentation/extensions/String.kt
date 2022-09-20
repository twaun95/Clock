package com.twaun95.clock.presentation.extensions

import java.text.DecimalFormat

fun Int.toDigitFormat(digitCount: Int) : String{
//    var pattern = ""
//    repeat(digitCount) { pattern += "0" }

    val formatted = DecimalFormat("00")
    return formatted.format(this)
}

fun Int.toDivFormat(digitCount: Int) : String{
//    var pattern = ""
//    repeat(digitCount) { pattern += "0" }

    val formatted = DecimalFormat("00")
    return "${formatted.format(this)} : "
}