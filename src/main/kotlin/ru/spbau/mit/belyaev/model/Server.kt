package ru.spbau.mit.belyaev.model

/**
 * @author belaevstanislav
 *
 * Providing an interface accepting connections and create chat sockets.
 */
interface Server {
    /**
     * Accept a connection and create chat socket to handle it.
     *
     * @return class implementing ChatSocket interface
     *
     * @throws AcceptConnectionException if error occur while accepting
     */
    fun accept(): ChatSocket

    /**
     * Attempting to stop a server.
     *
     * @throws ClosingServerException if error occur while closing
     */
    fun close()
}