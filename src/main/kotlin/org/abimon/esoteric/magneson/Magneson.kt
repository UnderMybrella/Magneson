package org.abimon.esoteric.magneson

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object Magneson {
    var index = 0
    val commands = ArrayList<Color>()

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("java.awt.headless", "true")
        val img = ImageIO.read(File(args[0]))

        for (y in 0 until img.height)
            for (x in 0 until img.width)
                commands.add(Color(img.getRGB(x, y)))

        while (index < commands.size) {
            when (commands[index++]) {
                RegularPalette.PRINT -> print(getString())
                RegularPalette.PRINTLN -> println(getString())
            }
        }

        println("Done")
    }

    fun getString(): String {
        val helloWorld = VariablePalette.HARD_STRINGS.entries.firstOrNull { (color) -> color == commands[index] }
        if(helloWorld != null) {
            index++
            return helloWorld.value
        }

        if(commands[index].red == 2 && commands[index].green == 0)
            return "${commands[index++].blue.toChar()}"

        if(commands[index] == VariablePalette.START_CONCAT) {
            index++
            var str = ""
            while(commands[index] != VariablePalette.STOP_CONCAT && index < commands.size)
                str += getString()
            index++
            return str
        }

        return "Wha?"
    }

    fun makeExampleImage(): BufferedImage = BufferedImage(4, 4, BufferedImage.TYPE_INT_RGB)

    fun loadResource(name: String): ByteArray {
        val backup = File("src${File.separator}main${File.separator}resources${File.separator}$name")
        return Magneson::class.java.classLoader.getResourceAsStream(name)?.readBytes() ?: (if(backup.exists()) backup.readBytes() else throw IllegalStateException("$name could not be found"))
    }
}