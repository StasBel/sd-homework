package ru.spbau.mit.belyaev

/**
 * REPL cycle to running pseudo-bash interpreter. Problems with cursor
 * not moving after promt occur only in ide (as far as i know).
 *
 * @author belaevstanislav
 */
fun main(args: Array<String>) {
    val shell = Shell()

    while (run {
        print("# ")
        val line = readLine()
        if (!line.isNullOrBlank().or(line?.trim().equals("exit"))) {
            try {
                print(shell.execute(line!!))
            } catch (e: Throwable) {
                println(e.message)
            }
            true
        } else {
            false
        }
    }) {
    }
}