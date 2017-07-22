package org.abimon.esoteric.magneson

import java.awt.Color

object RegularPalette {
    val PRINT = Color(0, 0, 0)
    val PRINTLN = Color(0, 0, 1)

    val ASSIGN_STRING = Color(0, 1, 0)

    val GET_STRING = Color(0, 2, 0)

    val REVERSE_STRING = Color(0, 3, 0)

    val APPEND_STRING = Color(0, 4, 0)

    val PREPEND_STRING = Color(0, 5, 0)

    val STRING_TO_INT = Color(0, 6, 0)
    val INT_TO_STRING = Color(0, 6, 1)

    val LENGTH_STRING = Color(0, 7, 0)

    val START_LOOP = Color(1, 0, 0)
    val END_LOOP = Color(1, 0, 1)

    //Meta Section
    val REMOVE_COMMANDS_NOT_PART_RED = Color(255, 255, 0)
    val REMOVE_COMMANDS_NOT_PART_GREEN = Color(255, 255, 1)
    val REMOVE_COMMANDS_NOT_PART_BLUE = Color(255, 255, 2)
    val REMOVE_COMMANDS_NOT_PART_ALPHA = Color(255, 255, 3)

    val REMOVE_COMMANDS_NOT_FULLY_RED = Color(255, 255, 4)
    val REMOVE_COMMANDS_NOT_FULLY_GREEN = Color(255, 255, 5)
    val REMOVE_COMMANDS_NOT_FULLY_BLUE = Color(255, 255, 6)
    val REMOVE_COMMANDS_NOT_FULLY_ALPHA = Color(255, 255, 7)

    val REMOVE_COMMANDS_FULLY_RED = Color(255, 255, 8)
    val REMOVE_COMMANDS_FULLY_GREEN = Color(255, 255, 9)
    val REMOVE_COMMANDS_FULLY_BLUE = Color(255, 255, 10)
    val REMOVE_COMMANDS_FULLY_ALPHA = Color(255, 255, 11)

    val REMOVE_COMMANDS_ANY_RED = Color(255, 255, 12)
    val REMOVE_COMMANDS_ANY_GREEN = Color(255, 255, 13)
    val REMOVE_COMMANDS_ANY_BLUE = Color(255, 255, 14)
    val REMOVE_COMMANDS_ANY_ALPHA = Color(255, 255, 15)

    val USE_ALPHA_FOR_COMMANDS = Color(255, 255, 16)

    val PASS = Color(255, 255, 255)
}