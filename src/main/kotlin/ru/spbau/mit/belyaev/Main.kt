package ru.spbau.mit.belyaev

/**
 * @author belaevstanislav
 *
 * REPL cycle to running pseudo-bash interpreter. Problems with cursor
 * not moving after promt occur only in ide (as far as i know).
 */
fun main(args: Array<String>) {
    val shell = Shell()

    while (run {
        print("# ")
        val line = readLine()
        if (!line.isNullOrBlank().or(line?.trim().equals("exit"))) {
            print(shell.execute(line!!));
            true
        } else {
            false
        }
    }) {
    }
}