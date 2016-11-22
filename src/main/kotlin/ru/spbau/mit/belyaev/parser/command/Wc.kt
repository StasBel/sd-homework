package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State
import java.util.*

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Wc(private val args: List<String>?) : Command() {
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
            = args?.joinToString("\n", transform = { s -> count(state.context.getContent(state, s)).toStr() })
            ?: state.pipe?.let { s -> count(s).toStr() }
}