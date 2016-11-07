package ru.spbau.mit.belyaev.debug

/**
 * Created by belaevstanislav on 09.10.16.
 */

/**
 * An abstract class using for implementing a new class of notifications.
 */
open class Notification(message: String, val level: Level) : Throwable(message) {
    companion object {
        enum class Level { ERROR }
    }
}