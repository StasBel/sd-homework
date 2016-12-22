package ru.spbau.mit.belyaev.main

/**
 * Type of game results. Nothing means nobody win.
 * @author belaevstanislav
 */
enum class GameOverType {
    WIN,
    LOSE,
    FORCE_QUIT,
    NOTHING
}