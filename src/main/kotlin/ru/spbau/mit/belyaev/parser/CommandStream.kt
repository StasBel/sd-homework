package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.lexer.LexemeStream
import ru.spbau.mit.belyaev.parser.command.Command

/**
 * A stream of [Command]'s.
 * @author belaevstanislav
 */
abstract class CommandStream(private val lexemes: LexemeStream) : Stream<Command>() {
    /**
     * Function using for rising an error with message.
     * @param errorMessage message of the error
     */
    fun error(errorMessage: String) {
        lexemes.error(errorMessage)
    }
}