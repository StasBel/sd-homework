package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Exit : Command() {
    override fun executeS(state: State): String? = null
}