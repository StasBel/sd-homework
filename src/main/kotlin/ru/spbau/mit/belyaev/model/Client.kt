package ru.spbau.mit.belyaev.model

/**
 * Client interface using for do client acts.
 *
 * @author belaevstanislav
 */
interface Client {
    /**
     * Invoke for creating a connect and getting a [Writer] class.
     *
     * @param chatListener interface [ChatListener] to handle input
     *
     * @return [Writer] implementation class
     *
     * @throws AcceptConnectionException if error occur while accepting
     */
    fun connect(chatListener: ChatListener): Writer

    /**
     * Invoke for closing the connection.
     *
     * @throws ClientCloseException if error occur while closing
     */
    fun close()
}