package org.abimon.esoteric.magneson

import java.awt.Color

object VariablePalette {
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

            Color(1, 0, 0) to String(Magneson.loadResource("BEE_MOVIE_SCRIPT.txt"), Charsets.UTF_8)
    )

    val START_CONCAT = Color(255, 255, 254)
    val STOP_CONCAT = Color(255, 255, 255)
}