package ru.spbau.mit.belyaev.debug

/**
 * Created by belaevstanislav on 09.10.16.
 */

/**
 * The only notification class so far, using for throwing an exception
 * while lexing, parsing and executing shell command.
 */
class Error(errorMessage: String) : Notification(errorMessage, Level.ERROR)