package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.lexer.LexemeStream

/**
 * Created by belaevstanislav on 23.10.16.
 */

/**
 * A stream of [Command]'s.
 */
abstract class CommandStream(private val lexemes: LexemeStream) : Stream<Command>() {
    /**
     * Function using for rising an error with message.
     *
     * @param errorMessage message of the error
     */
    fun error(errorMessage: String) {
        lexemes.error(errorMessage)
    }
}