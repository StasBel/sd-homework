package ru.spbau.mit.belyaev.lexer

/**
 * Created by belaevstanislav on 02.10.16.
 */

/**
 * Abstract class using for all lexemes using in shell.
 */
sealed class Lexeme(private val str: String = "") {
    companion object {
        const val SINGLE_QUOTE_CHAR = '\''
        const val DOUBLE_QUOTE_CHAR = '"'
        const val PIPE_CHAR = '|'
        const val ASSIGNMENT_CHAR = '='
        const val DEFAULT_WHITESPACE_CHAR = ' '
        const val REF_CHAR = '$'
    }

    open fun getStr(): String = str

    /**
     * Single quote ''' lexeme.
     */
    class SINGLE_QUOTE : Lexeme("$SINGLE_QUOTE_CHAR")

    /**
     * Double quote '"' lexeme.
     */
    class DOUBLE_QUOTE : Lexeme("$DOUBLE_QUOTE_CHAR")

    /**
     * Pipe '|' lexeme.
     */
    class PIPE : Lexeme("$PIPE_CHAR")

    /**
     * Assignment '=' lexeme.
     */
    class ASSIGNMENT : Lexeme("$ASSIGNMENT_CHAR")

    /**
     * Whitespace ' ' lexeme.
     */
    class WHITESPACE(private val char: Char = DEFAULT_WHITESPACE_CHAR) : Lexeme() {
        override fun getStr(): String = "$char"
    }

    /**
     * Reference lexeme looks like: "$IDENT".
     */
    class REF(private val name: String) : Lexeme() {
        override fun getStr(): String = "\$$name"
        fun getName(): String = name
    }

    /**
     * Plain text looks like: "text".
     */
    class PLAIN_TEXT(private val text: String) : Lexeme() {
        override fun getStr(): String = text
    }
}