package org.abimon.esoteric.magneson

import java.awt.Color

object IntegerPalette {
    val HARD_NUMBERS = mapOf(
        Color(0, 0, 0) to 0
    )

    val STDIN = Color(2, 0, 0)
    val LOOP_INDEX = Color(2, 0, 1)
    val PARSER_INDEX = Color(2, 0, 2)
    val NESTED_LAYER = Color(2, 0, 3)

    //Powers of 2 are Color(2, 1, <pow>)

    //Fibbonacci numbers are Color(2, 2, <pow>)

    //Raw numbers are Color(3, g*256, r)

    val SIZE_OF_STRING_LIST = Color(4, 0, 0)
    val SIZE_OF_INT_LIST = Color(4, 0, 1)

    val START_CONCAT = Color(255, 255, 0)
    val STOP_CONCAT = Color(255, 255, 1)
}