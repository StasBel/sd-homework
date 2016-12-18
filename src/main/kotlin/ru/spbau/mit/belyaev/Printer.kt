package ru.spbau.mit.belyaev

/**
 * @author belaevstanislav
 */
class Printer {
    val f = CellType.WALL.char
}

enum class CellType(val char: Char) {
    WALL('#'),
    EMPTY('.'),
    DOOR('D');
}
