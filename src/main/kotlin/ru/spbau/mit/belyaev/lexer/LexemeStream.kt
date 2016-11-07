package ru.spbau.mit.belyaev.lexer

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.wrapper.CharStream

/**
 * Created by belaevstanislav on 23.10.16.
 */

abstract class LexemeStream(private val chars: CharStream) : Stream<Lexeme>() {
    constructor(lexemeStream: LexemeStream) : this(lexemeStream.chars)

    fun error(errorMessage: String) {
        chars.error(errorMessage)
    }
}