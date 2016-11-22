package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Unknown(private val command: String) : Command() {
    override fun executeS(state: State): String? = state.context.runBashCommand(command, state.pipe)
}