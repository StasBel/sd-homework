package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.lexer.Lexeme
import ru.spbau.mit.belyaev.lexer.LexemeStream
import ru.spbau.mit.belyaev.parser.command.*
import java.util.*

/**
 * Class implementing logic of splitting a stream of lexeme to stream of commands.
 * @author belaevstanislav
 */
class Parser {
    /**
     * Splitting a stream of lexemes to stream of commands.
     * @param lexemes a stream of lexemes to split
     * @return a stream of commands
     */
    fun parseToCommands(lexemes: LexemeStream): CommandStream {
        return object : CommandStream(lexemes) {
            private val args: ArrayList<Lexeme> = ArrayList()
            private val stack: ArrayList<Lexeme> = ArrayList()

            private fun isAssign() = args.size >= 3
                    && args[0] is Lexeme.PLAIN_TEXT
                    && args[1] is Lexeme.ASSIGNMENT
                    && args[2] is Lexeme.PLAIN_TEXT

            private fun dropFirstArgs() = args.drop(1).map(Lexeme::getStr).let { l -> if (l.isEmpty()) null else l }

            private fun joinStack() = stack.joinToString(transform = Lexeme::getStr)

            private fun dealWithUnknown(): Command = Unknown(joinStack())

            override fun getNext(): Command? {
                args.clear()
                stack.clear()

                while (lexemes.next().let { next ->
                    if (next == null || next is Lexeme.PIPE)
                        false
                    else {
                        when (next) {
                            is Lexeme.ASSIGNMENT, is Lexeme.PLAIN_TEXT -> args.add(next)
                        }
                        stack.add(next)
                        true
                    }
                }) {
                }

                return when {
                    args.size == 0 && !lexemes.hasNext() -> null
                    args.size == 0 -> run { error("Something wring with the pipes!"); null }
                    isAssign() -> Assign(args[0].getStr(), args[2].getStr())
                    args[0] is Lexeme.PLAIN_TEXT ->
                        when (args[0].getStr().toLowerCase()) {
                            Command.CAT_STR -> Cat(dropFirstArgs())
                            Command.ECHO_STR -> Echo(dropFirstArgs())
                            Command.WC_STR -> Wc(dropFirstArgs())
                            Command.PWD_STR -> Pwd()
                            Command.EXIT_STR -> Exit()
                            Command.GREP_STR -> Grep(dropFirstArgs())
                            else -> dealWithUnknown()
                        }
                    else -> dealWithUnknown()
                }
            }
        }
    }
}