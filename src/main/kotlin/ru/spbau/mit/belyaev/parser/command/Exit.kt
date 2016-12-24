package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Exiting command doing nothing and stopping the execution.
 * @author belaevstanislav
 */
class Exit : Command() {
    override fun executeS(state: State): String? = null
}