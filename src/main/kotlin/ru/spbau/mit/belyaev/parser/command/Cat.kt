package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Cat(private val args: List<String>?) : Command() {
    override fun executeS(state: State): String?
            = args?.joinToString("\n", transform = { s -> state.context.getContent(state, s) }) ?: state.pipe
}