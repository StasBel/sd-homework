package ru.spbau.mit.belyaev

import ru.spbau.mit.belyaev.debug.Notification

/**
 * Created by belaevstanislav on 06.10.16.
 */

/**
 * Provide an inteface for stream of objects.
 */
abstract class Stream<T> {
    private var current: T? = null

    protected abstract fun getNext(): T?

    /**
     * Get next element from the stream or null if reach end.
     *
     * @return element or null
     */
    fun next(): T? = run { val operating = current; current = null; operating } ?: getNext()

    /**
     * Peek next element without removing it from stream or null if reach end.
     *
     * @return element or null
     */
    fun peek(): T? = current ?: run { current = next(); current }

    /**
     * Checking if stream has next element.
     *
     * @return true if stream has next element, false otherwise
     */
    fun hasNext(): Boolean = peek()?.run { true } ?: false

    /**
     * Notify a user about something and throw notification depending on the level.
     *
     * @param notification notification
     */
    fun notify(notification: Notification) {
        //we have only error so far
        throw notification
    }
}