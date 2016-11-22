package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Echo(private val args: List<String>?) : Command() {
    override fun executeS(state: State): String? = args?.joinToString(" ", postfix = "\n") ?: "\n"
}