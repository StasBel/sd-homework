package ru.spbau.mit.belyaev.parser.command

import ru.spbau.mit.belyaev.State

/**
 * Created by belaevstanislav on 22.10.16.
 */

abstract class Command {
    companion object {
        const val CAT_STR = "cat"
        const val ECHO_STR = "echo"
        const val WC_STR = "wc"
        const val PWD_STR = "pwd"
        const val EXIT_STR = "exit"
        const val GREP_STR = "grep"
    }

    abstract fun executeS(state: State): String?

    /**
     * @param state current execution state
     * @return modify execution state and return it again
     */
    fun execute(state: State): State = run { state.pipe = executeS(state); state }
}