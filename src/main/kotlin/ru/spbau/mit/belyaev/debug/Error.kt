package ru.spbau.mit.belyaev.debug

/**
 * The only notification class so far, using for throwing an exception
 * while lexing, parsing and executing shell command.
 * @author belaevstanislav
 */
class Error(errorMessage: String) : Notification(errorMessage, Level.ERROR)