package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.Context
import java.nio.file.Files
import java.nio.file.InvalidPathException
import java.util.*

/**
 * Created by belaevstanislav on 22.10.16.
 */

sealed class Command(protected val args: List<String>? = null) {
    //TODO переделать в execute(State): State
    abstract fun execute(context: Context, pipeOut: String? = null, error: (String) -> Unit): String?

    class Exit() : Command() {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String? = null
    }

    class Cat(args: List<String>?) : Command(args) {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = args?.joinToString { s ->
            Files.readAllLines(
                    try {
                        context.dir.resolve(s)
                    } catch (e: InvalidPathException) {
                        error("Wrong file!"); null
                    }
            ).joinToString() + System.lineSeparator()
        }
                ?: pipeOut
    }

    class Echo(args: List<String>?) : Command(args) {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = args?.joinToString(" ", postfix = System.lineSeparator())
    }

    class Wc(args: List<String>?) : Command(args) {
        private data class Counter(val lines: Int = 0, val words: Int = 0, val chars: Int = 0)

        private val BETWEEN = '\t'

        private fun Counter.toStr(): String {
            return "${this.lines}$BETWEEN${this.words}$BETWEEN${this.chars}\n"
        }

        private fun count(input: String): Counter {
            return Counter(
                    input.trimEnd().split(System.lineSeparator()).size,
                    StringTokenizer(input).countTokens(),
                    input.length
            )
        }

        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = args?.joinToString { s ->
            try {
                count(Files.readAllLines(context.dir.resolve(s)).joinToString(System.lineSeparator())).toStr()
            } catch (e: Exception) {
                error("Wrong file!"); ""
            }
        }
                ?: if (pipeOut != null) count(pipeOut).toStr() else null
    }

    class Pwd() : Command() {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = context.dir.toString()
    }

    class Assign(private val id: String, private val what: String) : Command() {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = run { context.set(id, what); null }
    }

    class Unknown(private val command: String) : Command() {
        override fun execute(context: Context, pipeOut: String?, error: (String) -> Unit): String?
                = context.runBashCommand(command, pipeOut)
    }
}