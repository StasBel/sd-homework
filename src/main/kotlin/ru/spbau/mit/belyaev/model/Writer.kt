package ru.spbau.mit.belyaev.model

import ru.spbau.mit.belyaev.message.Proto

/**
 * Providing an interface to communicate over tcp using [Proto.Message].
 *
 * @author belaevstanislav
 */
interface Writer {
    /**
     * Send a [Proto.UserInfo].
     *
     * @param userInfo user info to send
     *
     * @throws CommunicateException if error occur while data sending
     */
    fun sendUserInfo(userInfo: Proto.UserInfo)

    /**
     * Send a [Proto.TextMessage].
     *
     * @param textMessage text message to send
     *
     * @throws CommunicateException if error occur while data sending
     */
    fun sendTextMessage(textMessage: Proto.TextMessage)

    /**
     * Send a [Proto.Typing].
     *
     * @param typing typing to send
     *
     * @throws CommunicateException if error occur while data sending
     */
    fun notifyTyping(typing: Proto.Typing)

    /**
     * Attempting to close a connection.
     *
     * @throws ClosingConnectionException when failed to close connection
     */
    fun close()
}