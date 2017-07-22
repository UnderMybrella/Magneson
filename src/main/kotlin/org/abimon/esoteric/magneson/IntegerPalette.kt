package org.abimon.esoteric.magneson

import java.awt.Color

object IntegerPalette {
    val HARD_NUMBERS = mapOf(
        Color(0, 0, 0) to 0
    )

    //Powers of 2 are Color(0, 1, <pow>)

    //Fibbonacci numbers are Color(0, 2, <pow>)

    //Raw numbers are Color(1, g*256, r)

    val START_CONCAT = Color(255, 255, 0)
    val STOP_CONCAT = Color(255, 255, 1)
}