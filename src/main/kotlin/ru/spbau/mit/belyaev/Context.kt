package ru.spbau.mit.belyaev

import java.io.PrintWriter
import java.io.RandomAccessFile
import java.nio.file.Files
import java.nio.file.Path

/**
 * Context using to run bash commands, store variables and current dir.
 * @author belaevstanislav
 */
class Context(val dir: Path) {
    companion object {
        const val BASH_PATH = "/bin/bash"
    }

    private val vars = mutableMapOf<String, String>()

    init {
        System.getenv().forEach { vars[it.key] = it.value }
    }

    private fun lastLineHasN(path: Path): Boolean {
        val raf = RandomAccessFile(path.toFile(), "r")
        val pos = raf.length() - 2
        if (pos < 0) return false
        raf.seek(pos)
        return raf.read() == '\n'.toInt()
    }

    /**
     * Get content of particular file.
     *
     * @param state current execution state using to throw an error
     * @param file file name
     * @return content of file
     */
    fun getContent(state: State, file: String): String {
        return try {
            val path = state.context.dir.resolve(file)
            Files.readAllLines(path).joinToString("\n", postfix = if (lastLineHasN(path)) "\n" else "")
        } catch (e: Exception) {
            state.error("Not such file!"); ""
        }
    }

    /**
     * Run a bash command.
     *
     * @param command command in string representation
     * @param input input in string representaion or null
     * @return bash command output
     */
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

    /**
     * Assign value to the variable.
     *
     * @param name variable name
     * @param value value to assign
     */
    fun set(name: String, value: String) {
        vars[name] = value
    }

    /**
     * Get value of variable or, if null, obtains it from bash environment.
     *
     * @param name variable name
     * @return value or null
     */
    fun get(name: String): String? = vars.getOrElse(name, { -> getBashVar(name) })
}