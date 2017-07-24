package org.abimon.esoteric.magneson

import java.awt.Color

object RegularPalette {
    val PRINT = Color(0, 0, 0)
    val PRINTLN = Color(0, 0, 1)

    val ASSIGN_STRING = Color(0, 1, 0)
    val ASSIGN_INT = Color(0, 1, 1)

    val GET_STRING = Color(0, 2, 0)
    val GET_INT = Color(0, 2, 1)

    val REVERSE_STRING = Color(0, 3, 0)
    val REVERSE_INT = Color(0, 3, 1)

    val APPEND_STRING = Color(0, 4, 0)
    val APPEND_INT = Color(0, 4, 1)

    val PREPEND_STRING = Color(0, 5, 0)
    val PREPEND_INT = Color(0, 5, 1)

    val STRING_TO_INT = Color(0, 6, 0)
    val INT_TO_STRING = Color(0, 6, 1)

    val LENGTH_STRING = Color(0, 7, 0)

    val ADD_INT = Color(0, 8, 0)

    val SUB_INT = Color(0, 9, 0)

    val MULTIPLY_INT = Color(0, 10, 0)

    val DIVIDE_INT = Color(0, 11, 0)

    val REMAINDER_INT = Color(0, 12, 0)

    val ADD_STRING_TO_LIST = Color(0, 13, 0)
    val ADD_INT_TO_LIST = Color(0, 13, 1)

    val REMOVE_STRING_FROM_LIST = Color(0, 14, 0)
    val REMOVE_INT_FROM_LIST = Color(0, 14, 1)

    val GET_STRING_FROM_LIST = Color(0, 15, 0)
    val GET_INT_FROM_LIST = Color(0, 15, 1)

    val SET_STRING_IN_LIST = Color(0, 16, 0)
    val SET_INT_IN_LIST = Color(0, 16, 1)

    val REMOVE_STRING_AT_INDEX_IN_LIST = Color(0, 17, 0)
    val REMOVE_INT_AT_INDEX_IN_LIST = Color(0, 17, 1)

    val GET_FIRST_STRING_FROM_LIST = Color(0, 18, 0)
    val GET_FIRST_INT_FROM_LIST = Color(0, 18, 1)

    val REMOVE_FIRST_STRING_FROM_LIST = Color(0, 19, 0)
    val REMOVE_FIRST_INT_FROM_LIST = Color(0, 19, 1)

    val START_LOOP = Color(1, 0, 0)
    val END_LOOP = Color(1, 0, 1)
    val BREAK_LOOP = Color(1, 0, 2)
    val CONTINUE_LOOP = Color(1, 0, 3)

    val IF_STRING_EQUALS = Color(1, 1, 0)
    val IF_INT_EQUALS = Color(1, 1, 1)
    val ELSE = Color(1, 1, 254)
    val ENDIF = Color(1, 1, 255)

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

    val EXIT = Color(255, 255, 254)
    val PASS = Color(255, 255, 255)
}