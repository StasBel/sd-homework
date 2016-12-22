package ru.spbau.mit.belyaev.strategy

import ru.spbau.mit.belyaev.world.Item

/**
 * A sealed class of creature actions.
 * @author belaevstanislav
 */
sealed class Action {
    /**
     * Force quitting initialize by user.
     */
    class ForceQuit : Action()

    /**
     * Doing nothing action.
     */
    class Nothing : Action()

    /**
     * An action of moving.
     */
    class Move(val move: ru.spbau.mit.belyaev.world.Move) : Action()

    /**
     * An action of toggling an item.
     */
    class ToggleItem(val item: Item) : Action()
}