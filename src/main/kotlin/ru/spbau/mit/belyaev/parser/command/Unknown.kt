package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Command using for denoting the unknown to our bash command.
 * @author belaevstanislav
 */
class Unknown(private val command: String) : Command() {
    override fun executeS(state: State): String? = state.context.runBashCommand(command, state.pipe)
}