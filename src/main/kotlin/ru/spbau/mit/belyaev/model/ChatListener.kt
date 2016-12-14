package ru.spbau.mit.belyaev.model

import ru.spbau.mit.belyaev.message.Proto

/**
 * An interface using for handle chat events.
 *
 * @author belaevstanislav
 */
interface ChatListener {
    /**
     * Invoked on getting [Proto.UserInfo].
     *
     * @param userInfo user info that we received
     */
    fun onUserInfo(userInfo: Proto.UserInfo)

    /**
     * Invoked on getting [Proto.TextMessage].
     *
     * @param textMessage text message that we received
     */
    fun onMessage(textMessage: Proto.TextMessage)

    /**
     * Invoked on getting [Proto.Typing].
     *
     * @param typing typing that we received
     */
    fun onTyping(typing: Proto.Typing)

    /**
     * Invoked on getting an error.
     */
    fun onError()

    /**
     * Invoked on closing the connection.
     */
    fun onClose()
}