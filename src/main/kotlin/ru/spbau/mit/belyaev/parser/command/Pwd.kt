package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Command using for printing out current directory abs path.
 * @author belaevstanislav
 */
class Pwd() : Command() {
    override fun executeS(state: State): String? = state.context.dir.toAbsolutePath().toString() + "\n"
}