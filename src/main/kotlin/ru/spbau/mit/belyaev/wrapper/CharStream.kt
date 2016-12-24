package ru.spbau.mit.belyaev.wrapper

import ru.spbau.mit.belyaev.Stream
import ru.spbau.mit.belyaev.debug.Error

/**
 * A stream of char using for wrapping input string.
 * @author belaevstanislav
 */
class CharStream(private val input: String) : Stream<Char>() {
    private var position = -1

    override fun getNext(): Char? = input.getOrNull(++position)

    /**
     * Just useful func using for parsing.
     * Taking chars while predicate is true starting from [position].
     * @param shouldTake predicate taking current position, current char and previous char
     * @return result string
     */
    fun takeWhile(shouldTake: (Int, Char, Char?) -> Boolean): String {
        var result = ""
        var curPos = 0
        var lastChar = input.getOrNull(position)
        while (hasNext() && shouldTake(curPos, peek()!!.toChar(), lastChar)) {
            lastChar = next(); result += lastChar; curPos++
        }
        return result
    }

    /**
     * Function using for rising an error with message.
     * @param errorMessage message of the error
     */
    fun error(errorMessage: String) {
        super.notify(Error("Parsing failed!" +
                (if (position in 0..input.length - 1)
                    " Error at position number $position\n"
                else
                    " ") +
                "Message: $errorMessage"))
    }
}