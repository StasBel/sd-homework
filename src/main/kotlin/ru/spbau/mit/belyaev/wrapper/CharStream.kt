package ru.spbau.mit.belyaev.wrapper

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.debug.Error

/**
 * Created by belaevstanislav on 24.09.16.
 */

class CharStream(private val input: String) : Stream<Char>() {
    private var position = -1

    override fun getNext(): Char? = input.getOrNull(++position)

    fun takeWhile(shouldTake: (Int, Char, Char?) -> Boolean): String {
        var result = ""
        var curPos = 0
        var lastChar = input.getOrNull(position)
        while (hasNext() && shouldTake(curPos, peek()!!.toChar(), lastChar)) {
            lastChar = next(); result += lastChar; curPos++
        }
        return result
    }

    fun error(errorMessage: String) {
        super.notify(Error("Parsing failed!" +
                (if (position in 0..input.length - 1)
                    " Error at position number $position\n"
                else
                    " ") +
                "Message: $errorMessage"))
    }
}