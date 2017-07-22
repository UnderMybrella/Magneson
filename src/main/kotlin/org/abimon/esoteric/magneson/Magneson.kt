package org.abimon.esoteric.magneson

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.imageio.ImageIO

class Magneson(val commands: MutableList<Color>,
               val strings: MutableMap<String, String> = HashMap<String, String>(),
               val ints: MutableMap<String, Int> = HashMap<String, Int>()) {
    var index = 0

    fun parse() {
        var loopCondition: () -> Boolean = { false }
        var startOfLoop = 0
        loop@while (index < commands.size) {
            when (commands[index++]) {
                RegularPalette.PRINT -> print(getString())
                RegularPalette.PRINTLN -> println(getString())

                RegularPalette.ASSIGN_STRING -> strings[getString()] = getString()

                RegularPalette.GET_STRING -> {
                    val variable = getString()
                    println(strings[variable] ?: throw IllegalStateException("No string variable by name of $variable"))
                }

                RegularPalette.REVERSE_STRING -> {
                    val variable = getString()
                    strings[variable] = (strings[variable] ?: throw IllegalStateException("No string variable by name of $variable")).reversed()
                }

                RegularPalette.APPEND_STRING -> {
                    val variable = getString()
                    strings[variable] = (strings[variable] ?: throw IllegalStateException("No string variable by name of $variable")) + getString()
                }

                RegularPalette.PREPEND_STRING -> {
                    val variable = getString()
                    strings[variable] = getString() + (strings[variable] ?: throw IllegalStateException("No string variable by name of $variable"))
                }

                RegularPalette.START_LOOP -> {
                    ints["LOOP_INDEX"] = 0
                    ints["LOOP_LIMIT"] = getInteger() - 1
                    loopCondition = { ints.containsKey("LOOP_INDEX") && ints.containsKey("LOOP_LIMIT") && ints["LOOP_INDEX"]!! < ints["LOOP_LIMIT"]!! }
                    startOfLoop = index
                }
                RegularPalette.END_LOOP -> {
                    if(!loopCondition()) {
                        loopCondition = { false }

                        ints["LOOP_INDEX"] = 0
                        ints["LOOP_LIMIT"] = 0

                        continue@loop
                    }

                    ints["LOOP_INDEX"] = (ints["LOOP_INDEX"] ?: 0) + 1
                    index = startOfLoop
                }

                RegularPalette.PASS -> continue@loop
            }
        }
    }

    fun getString(): String {
        val hard = StringPalette.HARD_STRINGS.entries.firstOrNull { (color) -> color == commands[index] }
        if(hard != null) {
            index++
            return hard.value
        }

        if(commands[index].red == 2 && commands[index].green == 0)
            return "${commands[index++].blue.toChar()}"

        when(commands[index]) {
            RegularPalette.GET_STRING -> {
                index++
                val name = getString()

                return strings[name] ?: throw IllegalStateException("No string variable by name of $name")
            }
            RegularPalette.REVERSE_STRING -> {
                index++
                return getString().reversed()
            }
            RegularPalette.INT_TO_STRING -> {
                index++
                return "${getInteger()}"
            }
            StringPalette.START_CONCAT -> {
                index++
                var str = ""
                while(commands[index] != StringPalette.STOP_CONCAT && index < commands.size)
                    str += getString()
                index++
                return str
            }
        }

        return ""
    }

    fun getInteger(): Int {
        val hard = IntegerPalette.HARD_NUMBERS.entries.firstOrNull { (color) -> color == commands[index] }
        if(hard != null) {
            index++
            return hard.value
        }

        //Powers of 2
        if(commands[index].red == 0 && commands[index].green == 1) {
            val times = commands[index++].blue
            return Math.pow(2.0, (if(times == 255) ints["LOOP_INDEX"] ?: times else times).toDouble()).toInt()
        }

        //Fibbonacci
        if(commands[index].red == 0 && commands[index].green == 2) {
            var fib = 1
            var prevFib = 0
            val times = commands[index++].blue
            (0 until if(times == 255) ints["LOOP_INDEX"] ?: times else times).forEach {
                val tmp = fib
                fib += prevFib
                prevFib = tmp
            }

            return fib
        }

        if(commands[index].red == 1)
            return (commands[index].green * 256) + commands[index++].blue

        when(commands[index]) {
            RegularPalette.GET_STRING -> {
                index++
                val name = getString()

                return (strings[name] ?: throw IllegalStateException("No string variable by name of $name")).toIntOrNull() ?: throw IllegalStateException("String variable $name with value ${strings[name]} cannot be converted to an int")
            }
            RegularPalette.REVERSE_STRING -> {
                index++
                val str = getString().reversed()
                return str.toIntOrNull() ?: throw IllegalStateException("$str cannot be converted to an int")
            }
            RegularPalette.LENGTH_STRING -> {
                index ++
                return getString().length
            }
            IntegerPalette.START_CONCAT -> {
                index++
                var str = ""
                while(commands[index] != IntegerPalette.STOP_CONCAT && index < commands.size)
                    str += getInteger()
                index++
                return str.toInt()
            }
        }

        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.setProperty("java.awt.headless", "true")
            val img = Magneson.loadResourceAsStream(args.firstOrNull() ?: "example.png").use { ImageIO.read(it) }
            val commands = ArrayList<Color>()

            for (y in 0 until img.height)
                for (x in 0 until img.width)
                    commands.add(Color(img.getRGB(x, y)))

            val parser = Magneson(commands)
            parser.parse()

            println("Done")
            println()
            println(parser.strings)
            val scale = 128
            val bigger = BufferedImage(img.width * scale, img.height * scale, BufferedImage.TYPE_INT_ARGB)
            bigger.graphics.run {
                for(x in 0 until img.width)
                    for(y in 0 until img.height) {
                        color = Color(img.getRGB(x, y))
                        fillRect(x * scale, y * scale, scale, scale)
                    }
                dispose()
            }

            ImageIO.write(bigger, "PNG", File("ran_big.png"))
        }

        fun loadResource(name: String): ByteArray {
            val backup = File("src${File.separator}main${File.separator}resources${File.separator}$name")
            return Magneson::class.java.classLoader.getResourceAsStream(name)?.readBytes() ?: (if(backup.exists()) backup.readBytes() else if(File(name).exists()) File(name).readBytes() else throw IllegalStateException("$name could not be found"))
        }

        fun loadResourceAsStream(name: String): InputStream {
            val backup = File("src${File.separator}main${File.separator}resources${File.separator}$name")
            return Magneson::class.java.classLoader.getResourceAsStream(name) ?: (if(backup.exists()) FileInputStream(backup) else if(File(name).exists()) FileInputStream(File(name)) else throw IllegalStateException("$name could not be found"))
        }
    }
}