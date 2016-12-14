package ru.spbau.mit.belyaev.model

/**
 * Providing the interface for accepting connections, creating [Writer]'s,
 * also start and close.
 *
 * @author belaevstanislav
 */
interface Server {
    /**
     * Start the server.
     *
     * @param chatListener instance of [ChatListener] to handle data input
     *
     * @throws ServerStartException if error occur while starting
     */
    fun start(chatListener: ChatListener)

    /**
     * Accept a connection and create chat socket to handle it.
     *
     * @return class implementing [Writer] interface
     *
     * @throws AcceptConnectionException if error occur while accepting connection
     */
    fun accept(): Writer

    /**
     * Attempting to stop a server.
     *
     * @throws ServerCloseException if error occur while closing
     */
    fun close()
}