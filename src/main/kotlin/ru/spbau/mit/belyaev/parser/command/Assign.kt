package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Command using for assigning value to var.
 * @author belaevstanislav
 */
class Assign(private val id: String, private val what: String) : Command() {
    override fun executeS(state: State): String? = run { state.context.set(id, what); null }
}