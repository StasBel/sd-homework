package ru.spbau.mit.belyaev

import java.io.PrintWriter
import java.nio.file.Path

/**
 * Created by belaevstanislav on 03.10.16.
 */

class Context(val dir: Path) {
    private val BASH_PATH = "/bin/bash"

    private val vars = mutableMapOf<String, String>()

    init {
        System.getenv().forEach { vars[it.key] = it.value }
    }

    fun runBashCommand(command: String, input: String? = null): String {
        val process = ProcessBuilder(BASH_PATH, "-c", command).start()
        if (input != null) {
            val printWriter = PrintWriter(process.outputStream)
            printWriter.print(input)
            printWriter.flush()
        }
        return process.inputStream.bufferedReader().use { it.readText() }
    }

    private fun getBashVar(name: String): String? {
        return runBashCommand("echo \$$name").dropLast(1).let { s -> if (s.isEmpty()) null else s }
    }

    fun set(name: String, value: String) {
        vars[name] = value
    }

    fun get(name: String): String? = vars.getOrElse(name, { -> getBashVar(name) })
}