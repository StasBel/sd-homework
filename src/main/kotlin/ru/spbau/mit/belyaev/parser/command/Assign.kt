package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.11.16.
 */

class Assign(private val id: String, private val what: String) : Command() {
    override fun executeS(state: State): String? = run { state.context.set(id, what); null }
}