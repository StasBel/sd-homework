package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.State
import java.nio.file.Files
import java.nio.file.InvalidPathException
import java.util.*

/**
 * Created by belaevstanislav on 22.10.16.
 */

sealed class Command(protected val args: List<String>? = null) {
    abstract fun execute(state: State): State

    class Exit() : Command() {
        override fun execute(state: State): State = state.modify(null)
    }

    class Cat(args: List<String>?) : Command(args) {
        override fun execute(state: State): State
                = state.modify(args?.joinToString { s ->
            Files.readAllLines(
                    try {
                        state.context.dir.resolve(s)
                    } catch (e: InvalidPathException) {
                        state.error("Wrong file!"); null
                    }
            ).joinToString() + System.lineSeparator()
        }
                ?: state.pipe)
    }

    class Echo(args: List<String>?) : Command(args) {
        override fun execute(state: State): State
                = state.modify(args?.joinToString(" ", postfix = System.lineSeparator()))
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

        override fun execute(state: State): State
                = state.modify(args?.joinToString { s ->
            try {
                count(Files.readAllLines(state.context.dir.resolve(s)).joinToString(System.lineSeparator())).toStr()
            } catch (e: Exception) {
                state.error("Wrong file!"); ""
            }
        }
                ?: if (state.pipe != null) count(state.pipe!!).toStr() else null)
    }

    class Pwd() : Command() {
        override fun execute(state: State): State
                = state.modify(state.context.dir.toString())
    }

    class Assign(private val id: String, private val what: String) : Command() {
        override fun execute(state: State): State
                = state.modify(run { state.context.set(id, what); null })
    }

    class Unknown(private val command: String) : Command() {
        override fun execute(state: State): State
                = state.modify(state.context.runBashCommand(command, state.pipe))
    }
}