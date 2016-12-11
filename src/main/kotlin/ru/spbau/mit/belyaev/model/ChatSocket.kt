package ru.spbau.mit.belyaev.model

import ru.spbau.mit.belyaev.message.Proto

/**
 * @author belaevstanislav
 *
 * Providing an interface to communicate over tcp using [Proto.Message].
 */
interface ChatSocket {
    /**
     * Check if connection is still open.
     *
     * @return flag if we still connected
     */
    fun isOpen(): Boolean

    /**
     * Waiting for a message to drawGet and then parse it from stream.
     *
     * @return message to drawGet
     *
     * @throws CommunicateException if error occur while data getting
     */
    fun getMessage(): Proto.Message

    /**
     * Send a message.
     *
     * @param message message to drawSend
     *
     * @throws CommunicateException if error occur while data sending
     */
    fun sendMessage(message: Proto.Message)

    /**
     * Attempting to close a connection.
     *
     * @throws ClosingConnectionException when failed to close connection
     */
    fun close()
}