package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.State
import java.io.RandomAccessFile
import java.nio.file.Files
import java.nio.file.InvalidPathException
import java.nio.file.Path
import java.util.*

/**
 * Created by belaevstanislav on 22.10.16.
 */

sealed class Command(protected val args: List<String>? = null) {
    companion object {
        const val CAT_STR = "cat"
        const val ECHO_STR = "echo"
        const val WC_STR = "wc"
        const val PWD_STR = "pwd"
        const val EXIT_STR = "exit"
    }

    protected val N = "\n"

    fun execute(state: State): State = run { state.pipe = executeS(state); state }

    protected abstract fun executeS(state: State): String?

    class Exit() : Command() {
        override fun executeS(state: State): String? = null
    }

    class Cat(args: List<String>?) : Command(args) {
        override fun executeS(state: State): String?
                = args?.joinToString { s ->
            Files.readAllLines(
                    try {
                        state.context.dir.resolve(s)
                    } catch (e: InvalidPathException) {
                        state.error("Wrong file!"); null
                    }
            ).joinToString(N, postfix = N).let { s -> if (s == N) "" else s }
        }
                ?: state.pipe
    }

    class Echo(args: List<String>?) : Command(args) {
        override fun executeS(state: State): String?
                = args?.joinToString(" ", postfix = N) ?: N
    }

    class Wc(args: List<String>?) : Command(args) {
        private data class Counter(val lines: Int = 0, val words: Int = 0, val chars: Int = 0)

        private val BETWEEN = "\t"

        private fun Counter.toStr(): String {
            return "${this.lines}$BETWEEN${this.words}$BETWEEN${this.chars}$N"
        }

        private fun count(input: String): Counter {
            return Counter(
                    input.count { c -> c.toString() == N },
                    StringTokenizer(input).countTokens(),
                    input.length
            )
        }

        private fun lastLineHasN(path: Path): Boolean {
            val raf = RandomAccessFile(path.toFile(), "r")
            val pos = raf.length() - 2
            if (pos < 0) return false
            raf.seek(pos)
            return raf.read() == N[0].toInt()
        }

        override fun executeS(state: State): String?
                = args?.joinToString { s ->
            try {
                state.context.dir.resolve(s).let { p ->
                    count(Files.readAllLines(p)
                            .joinToString(N, postfix = if (lastLineHasN(p)) N else "")
                            .let { s -> if (s == N) "" else s }
                    ).toStr()
                }
            } catch (e: Exception) {
                state.error("Wrong file!"); ""
            }
        }
                ?: if (state.pipe != null) count(state.pipe!!).toStr() else null
    }

    class Pwd() : Command() {
        override fun executeS(state: State): String?
                = state.context.dir.toAbsolutePath().toString() + N
    }

    class Assign(private val id: String, private val what: String) : Command() {
        override fun executeS(state: State): String?
                = run { state.context.set(id, what); null }
    }

    class Unknown(private val command: String) : Command() {
        override fun executeS(state: State): String?
                = state.context.runBashCommand(command, state.pipe) + N
    }
}