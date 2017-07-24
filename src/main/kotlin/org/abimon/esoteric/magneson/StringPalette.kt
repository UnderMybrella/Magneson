package org.abimon.esoteric.magneson

import java.awt.Color

object StringPalette {
    val HARD_STRINGS = mapOf(
            Color(0, 0, 0) to "Hello World",
            Color(0, 0, 1) to "Hello World!",
            Color(0, 0, 2) to "Hello, World!",
            Color(0, 0, 3) to "hello, World!",
            Color(0, 0, 4) to "hello, world!",
            Color(0, 0, 5) to "hello, world",
            Color(0, 0, 6) to "hello world",
            Color(0, 0, 7) to "hello world!",
            Color(0, 0, 8) to "HELLO WORLD",
            Color(0, 0, 9) to "HELLO, WORLD",
            Color(0, 0, 10) to "HELLO, WORLD!",
            Color(0, 0, 11) to "HELLO WORLD!",

            Color(0, 0, 12) to "Input: ",
            Color(0, 0, 13) to "You have entered ",

            Color(0, 1, 0) to "VAR_1",
            Color(0, 1, 1) to "VAR_2",
            Color(0, 1, 2) to "VAR_3",
            Color(0, 1, 3) to "VAR_4",
            Color(0, 1, 4) to "VAR_5",
            Color(0, 1, 5) to "VAR_6",
            Color(0, 1, 6) to "VAR_7",
            Color(0, 1, 7) to "VAR_8",

            Color(0, 1, 8) to "LOOP_INDEX",
            Color(0, 1, 9) to "LOOP_LIMIT",

            Color(1, 0, 0) to String(Magneson.loadResource("BEE_MOVIE_SCRIPT.txt"), Charsets.UTF_8)
    )

    val STDIN = Color(3, 0, 0)

    val START_CONCAT = Color(255, 255, 0)
    val STOP_CONCAT = Color(255, 255, 1)
}