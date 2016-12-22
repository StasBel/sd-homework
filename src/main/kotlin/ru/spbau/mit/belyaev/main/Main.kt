package ru.spbau.mit.belyaev.main

import ru.spbau.mit.belyaev.game.DefaultGame
import ru.spbau.mit.belyaev.game.GameInputMode
import ru.spbau.mit.belyaev.map.FromFileCreatingMapStrategy
import ru.spbau.mit.belyaev.print.ASCIIPrinter


/**
 * Some default invocation of game. Note that NON_BLOCKING mode
 * is not working inside IDE's terminal, you have to use your native terminal
 * for better user experience.
 * @author belaevstanislav
 * @param args a args passed to the invocation
 */
fun main(args: Array<String>) {
    val game = Roguelike(
            creatingMapStrategy = FromFileCreatingMapStrategy("./src/main/resources/maps/emptyMap"),
            game = DefaultGame(
                    gameInputMode = GameInputMode.BLOCKING // NON_BLOCKING
            ),
            printer = ASCIIPrinter()
    )

    game.run()
}