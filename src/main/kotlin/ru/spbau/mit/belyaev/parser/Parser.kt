package ru.spbau.mit.belyaev.parser

import ru.spbau.mit.belyaev.lexer.Lexeme
import ru.spbau.mit.belyaev.lexer.LexemeStream
import java.util.*

/**
 * Created by belaevstanislav on 22.10.16.
 */

class Parser {
    fun parseToCommands(lexemes: LexemeStream): CommandStream {
        return object : CommandStream(lexemes) {
            private val args: ArrayList<Lexeme> = ArrayList()
            private val stack: ArrayList<Lexeme> = ArrayList()

            private fun isAssign() = args.size >= 3
                    && args[0] is Lexeme.PLAIN_TEXT
                    && args[1] is Lexeme.ASSIGNMENT
                    && args[2] is Lexeme.PLAIN_TEXT

            private fun dropFirstArgs() = args.drop(1).map(Lexeme::getStr).let { l -> if (l.size == 0) null else l }

            private fun joinStack() = stack.joinToString(transform = Lexeme::getStr)

            private fun dealWithUnknown(): Command = Command.Unknown(joinStack())

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
                    isAssign() -> Command.Assign(args[0].getStr(), args[2].getStr())
                    args[0] is Lexeme.PLAIN_TEXT ->
                        when (args[0].getStr().toLowerCase()) {
                            Command.CAT_STR -> Command.Cat(dropFirstArgs())
                            Command.ECHO_STR -> Command.Echo(dropFirstArgs())
                            Command.WC_STR -> Command.Wc(dropFirstArgs())
                            Command.PWD_STR -> Command.Pwd()
                            Command.EXIT_STR -> Command.Exit()
                            else -> dealWithUnknown()
                        }
                    else -> dealWithUnknown()
                }
            }
        }
    }
}