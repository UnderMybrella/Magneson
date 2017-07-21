package org.abimon.esoteric.magneson

import java.awt.Color
import java.net.URL

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

            Color(1, 0, 0) to String(URL("https://gist.githubusercontent.com/UnderMybrella/754fd84be79c8046bfbeb12457606a1b/raw/e83823e0e61c9c331ed579f89a2f5528e7b95bcd/Bee%2520Movie").openConnection().getInputStream().readBytes())
    )

    val START_CONCAT = Color(255, 255, 254)
    val STOP_CONCAT = Color(255, 255, 255)
}