package ru.spbau.mit.belyaev.debug

/**
 * Created by belaevstanislav on 09.10.16.
 */

open class Notification(message: String, val level: Level) : Throwable(message) {
    companion object {
        enum class Level { ERROR }
    }
}