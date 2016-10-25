package ru.spbau.mit.belyaev

/**
 * Created by belaevstanislav on 02.10.16.
 */

fun main(args: Array<String>) {
    val shell = Shell()
    print(shell.execute("a=abc | echo \$a"))
    print(shell.execute("echo \$a s"))
}