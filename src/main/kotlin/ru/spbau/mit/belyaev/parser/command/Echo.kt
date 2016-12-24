package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Command using for printing out strings.
 * @author belaevstanislav
 */
class Echo(private val args: List<String>?) : Command() {
    override fun executeS(state: State): String? = args?.joinToString(" ", postfix = "\n") ?: "\n"
}