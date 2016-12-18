package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.State
import java.io.RandomAccessFile
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

/**
 * Created by belaevstanislav on 22.10.16.
 */

/**
 * Abstract class using for all commands using in shell.
 */
sealed class Command(protected val args: List<String>? = null) {
    companion object {
        const val CAT_STR = "cat"
        const val ECHO_STR = "echo"
        const val WC_STR = "wc"
        const val PWD_STR = "pwd"
        const val EXIT_STR = "exit"
    }

    private fun lastLineHasN(path: Path): Boolean {
        val raf = RandomAccessFile(path.toFile(), "r")
        val pos = raf.length() - 2
        if (pos < 0) return false
        raf.seek(pos)
        return raf.read() == '\n'.toInt()
    }

    protected fun getContent(state: State, file: String): String {
        return try {
            val path = state.context.dir.resolve(file)
            Files.readAllLines(path).joinToString("\n", postfix = if (lastLineHasN(path)) "\n" else "")
        } catch (e: Exception) {
            state.error("Not such file!"); ""
        }
    }

    /**
     * Executing command.
     *
     * @param state current executing state
     *
     * @return changed executing state
     */
    fun execute(state: State): State = run { state.pipe = executeS(state); state }

    protected abstract fun executeS(state: State): String?

    /**
     * Exiting command doing nothing and stopping the execution.
     */
    class Exit() : Command() {
        override fun executeS(state: State): String? = null
    }

    /**
     * Command using for printing out the content of the file.
     */
    class Cat(args: List<String>?) : Command(args) {
        override fun executeS(state: State): String?
                = args?.joinToString("\n", transform = { s -> getContent(state, s) }) ?: state.pipe
    }

    /**
     * Command using for printing out strings.
     */
    class Echo(args: List<String>?) : Command(args) {
        override fun executeS(state: State): String? = args?.joinToString(" ", postfix = "\n") ?: "\n"
    }

    /**
     * Command using getting number of chars, words and lines of strings in execution buffer.
     */
    class Wc(args: List<String>?) : Command(args) {
        private data class Counter(val lines: Int = 0, val words: Int = 0, val chars: Int = 0)

        private val BETWEEN = "\t"

        private fun Counter.toStr(): String {
            return "$BETWEEN${this.lines}$BETWEEN${this.words}$BETWEEN${this.chars}\n"
        }

        private fun count(input: String): Counter {
            return Counter(
                    input.count { c -> c.toString() == "\n" },
                    StringTokenizer(input).countTokens(),
                    input.length
            )
        }

        override fun executeS(state: State): String?
                = args?.joinToString("\n", transform = { s -> count(getContent(state, s)).toStr() })
                ?: state.pipe?.let { s -> count(s).toStr() }
    }

    /**
     * Command using for printing out current directory abs path.
     */
    class Pwd() : Command() {
        override fun executeS(state: State): String? = state.context.dir.toAbsolutePath().toString() + "\n"
    }

    /**
     * Command using for assigning value to var.
     */
    class Assign(private val id: String, private val what: String) : Command() {
        override fun executeS(state: State): String? = run { state.context.set(id, what); null }
    }

    /**
     * Command using for denoting the unknown to our bash command.
     */
    class Unknown(private val command: String) : Command() {
        override fun executeS(state: State): String? = state.context.runBashCommand(command, state.pipe)
    }
}