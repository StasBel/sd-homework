package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Command using for printing out the content of the file.
 * @author belaevstanislav
 */
class Cat(private val args: List<String>?) : Command() {
    override fun executeS(state: State): String?
            = args?.joinToString("\n", transform = { s -> state.context.getContent(state, s) }) ?: state.pipe
}