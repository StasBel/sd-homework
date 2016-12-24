package ru.spbau.mit.belyaev.debug

/**
 * An abstract class using for implementing a new class of notifications.
 * @author belaevstanislav
 */
open class Notification(message: String, val level: Level) : Throwable(message) {
    companion object {
        enum class Level { ERROR }
    }
}