package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.lexer.LexemeStream

/**
 * Created by belaevstanislav on 23.10.16.
 */

abstract class CommandStream(private val lexemes: LexemeStream) : Stream<Command>() {
    fun error(errorMessage: String) {
        lexemes.error(errorMessage)
    }
}