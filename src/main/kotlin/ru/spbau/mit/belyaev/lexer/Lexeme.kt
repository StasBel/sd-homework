package ru.spbau.mit.belyaev.lexer

/**
 * Created by belaevstanislav on 02.10.16.
 */

sealed class Lexeme(private val str: String = "") {
    open fun getStr(): String = str

    companion object {
        const val SINGLE_QUOTE_CHAR = '\''
        const val DOUBLE_QUOTE_CHAR = '"'
        const val PIPE_CHAR = '|'
        const val ASSIGNMENT_CHAR = '='
        const val DEFAULT_WHITESPACE_CHAR = ' '
        const val REF_CHAR = '$'
    }

    class SINGLE_QUOTE : Lexeme("$SINGLE_QUOTE_CHAR")

    class DOUBLE_QUOTE : Lexeme("$DOUBLE_QUOTE_CHAR")

    class PIPE : Lexeme("$PIPE_CHAR")

    class ASSIGNMENT : Lexeme("$ASSIGNMENT_CHAR")

    class WHITESPACE(private val char: Char = DEFAULT_WHITESPACE_CHAR) : Lexeme() {
        override fun getStr(): String = "$char"
    }

    class REF(private val name: String) : Lexeme() {
        override fun getStr(): String = "\$$name"
        fun getName(): String = name
    }

    class PLAIN_TEXT(private val text: String) : Lexeme() {
        override fun getStr(): String = text
    }
}