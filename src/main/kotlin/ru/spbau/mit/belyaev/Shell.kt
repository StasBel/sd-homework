package ru.spbau.mit.belyaev

import ru.spbau.mit.belyaev.lexer.Lexeme
import ru.spbau.mit.belyaev.lexer.LexemeStream
import ru.spbau.mit.belyaev.lexer.Lexer
import ru.spbau.mit.belyaev.parser.CommandStream
import ru.spbau.mit.belyaev.parser.Parser
import ru.spbau.mit.belyaev.wrapper.CharStream
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Created by belaevstanislav on 03.10.16.
 */

class Shell(dir: Path = Paths.get(System.getProperty("user.dir"))) {
    private val lexer = Lexer()
    private val context = Context(dir)
    private val parser = Parser()

    private fun wrapping(input: String): CharStream {
        return CharStream(input)
    }

    private fun lexing(charStream: CharStream): LexemeStream {
        return lexer.splitToLexemes(
                CharStream(
                        lexer.splitToLexemes(charStream)
                                .substituteRefs()
                                .joinStream()
                )
        ).concatenatePlaintTextsAndRefs()
    }

    private fun LexemeStream.substituteRefs(): LexemeStream {
        return object : LexemeStream(this) {
            override fun getNext(): Lexeme? {
                return this@substituteRefs.next()?.let {
                    if (it is Lexeme.REF)
                        Lexeme.PLAIN_TEXT(context.get(it.getName()) ?: "")
                    else
                        it
                }
            }
        }
    }

    private fun LexemeStream.joinStream(): String {
        var result = ""
        while (this.hasNext()) {
            result += this.next()!!.getStr()
        }
        return result
    }

    private fun LexemeStream.concatenatePlaintTextsAndRefs(): LexemeStream {
        return object : LexemeStream(this) {
            override fun getNext(): Lexeme? {
                var result = ""
                while (run {
                    val nextLexeme = this@concatenatePlaintTextsAndRefs.peek()
                    nextLexeme is Lexeme.REF || nextLexeme is Lexeme.PLAIN_TEXT
                }) {
                    result += this@concatenatePlaintTextsAndRefs.next()!!.getStr()
                }

                return if (result != "")
                    Lexeme.PLAIN_TEXT(result)
                else
                    this@concatenatePlaintTextsAndRefs.next()
            }
        }
    }

    private fun parsing(lexemes: LexemeStream): CommandStream {
        return parser.parseToCommands(lexemes)
    }

    private fun executing(commands: CommandStream): String = execute(commands, null) ?: ""

    private fun execute(commands: CommandStream, pipeOutput: String? = null): String? {
        return if (commands.hasNext())
            execute(commands, commands.next()?.execute(context, pipeOutput, { m -> commands.error(m) }))
        else
            pipeOutput
    }

    // debug
    @Suppress("unused")
    private fun print(obj: Any) {
        when (obj) {
            is String -> println(obj)
            is CharStream -> {
                while (obj.hasNext()) {
                    println(obj.next()!!)
                }
            }
            is LexemeStream -> {
                while (obj.hasNext()) {
                    val lexeme = obj.next()!!
                    println("${lexeme.javaClass}: ${lexeme.getStr()}")
                }
            }
            is CommandStream -> {
                while (obj.hasNext()) {
                    val command = obj.next()!!
                    println("${command.javaClass}")
                }
            }
        }
    }

    fun execute(input: String): String {
        // String -> CharStream
        val chars = wrapping(input)

        // CharStream -> LexemeStream
        val lexemes = lexing(chars)

        // LexemeStream -> CommandStream
        val commands = parsing(lexemes)

        // CommandStream -> String
        val result = executing(commands)

        // debug
        // print(chars)
        // print(lexemes)
        // print(commands)
        // if (result == "") println("yes")
        // println(result)
        // print(result)

        return result
    }
}