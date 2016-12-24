package ru.spbau.mit.belyaev.lexer

import ru.spbau.mit.belyaev.wrapper.CharStream

/**
 * Class implementing logic of splitting a stream of char to stream of lexemes.
 * @author belaevstanislav
 */
class Lexer {
    private val SPECIAL_CHARS = arrayOf(Lexeme.SINGLE_QUOTE_CHAR, Lexeme.DOUBLE_QUOTE_CHAR, Lexeme.PIPE_CHAR,
            Lexeme.ASSIGNMENT_CHAR, Lexeme.REF_CHAR)
    private val QUOTES = arrayOf(Lexeme.SINGLE_QUOTE_CHAR, Lexeme.DOUBLE_QUOTE_CHAR)
    private val FIRST_IN_ARG_CHARS = arrayOf('@', '*', '#', '-', '$', '_', '?', '!')
    private val isArg: (Int, Char, Char?) -> Boolean = { pos, curChar, prevChar ->
        when {
            pos == 0 && isFirstInArg(curChar) -> true
            pos == 1 && (prevChar?.isLetter() == true) && curChar.isLetterOrDigit() -> true
            pos > 1 && curChar.isLetterOrDigit() -> true
            else -> false
        }
    }
    private val isNotSingleQuote: (Int, Char, Char?) -> Boolean = { pos, curChar, prevChar ->
        curChar != Lexeme.SINGLE_QUOTE_CHAR
    }
    private val isNotWSOrSpecial: (Int, Char, Char?) -> Boolean = { pos, curChar, prevChar ->
        !curChar.isWhitespace() && !isSpecial(curChar)
    }
    private val isNotDoubleQuote: (Int, Char, Char?) -> Boolean = { pos, curChar, prevChar ->
        curChar !in arrayOf(Lexeme.DOUBLE_QUOTE_CHAR, Lexeme.REF_CHAR)
    }

    private fun isSpecial(char: Char) = char in SPECIAL_CHARS
    private fun isFirstInArg(char: Char) = char.isLetterOrDigit() || char in FIRST_IN_ARG_CHARS

    /**
     * Splitting a stream of char to stream of lexemes.
     * @param charStream a stream of char to split
     * @return a stream of lexemes
     */
    fun splitToLexemes(charStream: CharStream): LexemeStream {
        return object : LexemeStream(charStream) {
            private var openQuote: Char? = null

            private fun isOutOfQuote() = openQuote == null

            private fun getQuote(quote: Char): Lexeme {
                if (isOutOfQuote()) openQuote = quote else openQuote = null
                return if (quote == Lexeme.SINGLE_QUOTE_CHAR) Lexeme.SINGLE_QUOTE() else Lexeme.DOUBLE_QUOTE()
            }

            private fun getArg(): Lexeme {
                val str = charStream.takeWhile(isArg)
                return if (str != "") Lexeme.REF(str) else Lexeme.PLAIN_TEXT("${Lexeme.REF_CHAR}")
            }

            private fun getPlainText(char: Char, predicate: (Int, Char, Char?) -> Boolean): Lexeme.PLAIN_TEXT {
                return Lexeme.PLAIN_TEXT(char + charStream.takeWhile(predicate))
            }

            override fun getNext(): Lexeme? {
                val nextChar = charStream.next()
                return if (nextChar != null) {
                    when {
                        isOutOfQuote() -> {
                            when (nextChar) {
                                Lexeme.PIPE_CHAR -> Lexeme.PIPE()
                                Lexeme.ASSIGNMENT_CHAR -> Lexeme.ASSIGNMENT()
                                Lexeme.REF_CHAR -> getArg()
                                else -> when {
                                    nextChar.isWhitespace() -> Lexeme.WHITESPACE(nextChar)
                                    nextChar in QUOTES -> getQuote(nextChar)
                                    nextChar.isDefined() -> getPlainText(nextChar, isNotWSOrSpecial)
                                    else -> {
                                        charStream.error("Invalid char!"); null
                                    }
                                }
                            }
                        }
                        else -> {
                            when (openQuote) {
                                nextChar -> getQuote(nextChar)
                                else -> when (openQuote) {
                                    Lexeme.SINGLE_QUOTE_CHAR -> getPlainText(nextChar, isNotSingleQuote)
                                    else -> when (nextChar) {
                                        Lexeme.REF_CHAR -> getArg()
                                        else -> getPlainText(nextChar, isNotDoubleQuote)
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (!isOutOfQuote()) charStream.error("Brackets do not match!"); null
                }
            }
        }
    }
}