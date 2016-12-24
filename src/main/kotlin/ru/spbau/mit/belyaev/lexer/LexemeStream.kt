package ru.spbau.mit.belyaev.lexer

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.wrapper.CharStream

/**
 * A stream of [Lexeme]'s.
 * @author belaevstanislav
 */
abstract class LexemeStream(private val chars: CharStream) : Stream<Lexeme>() {
    constructor(lexemeStream: LexemeStream) : this(lexemeStream.chars)

    /**
     * Function using for rising an error with message.
     *
     * @param errorMessage message of the error
     */
    fun error(errorMessage: String) {
        chars.error(errorMessage)
    }
}