package ru.spbau.mit.belyaev.print

import ru.spbau.mit.belyaev.game.Game
import ru.spbau.mit.belyaev.map.Map
import ru.spbau.mit.belyaev.world.Creature
import ru.spbau.mit.belyaev.world.World

/**
 * Basic Roguelike class using for printing out current running game state.
 * @author belaevstanislav
 */
interface Printer {
    /**
     * Printing out current game state from a [self] perspective of view.
     * @param self a creature to centered in print
     * @param world a world to observe, consist of only entities we know about
     * @param game a instance of [Game]
     */
    fun print(self: Creature, world: World, map: Map, game: Game)
}
