package ru.spbau.mit.belyaev.model

import java.net.ServerSocket
import java.net.Socket
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author belaevstanislav
 *
 * A class using for create server and client.
 *
 * @constructor empty constructor
 */
class Model {
    companion object {
        private val logger = Logger.getLogger(Model::class.simpleName)
    }

    /**
     * Creates a [Server] instance.
     *
     * @param port of server
     *
     * @return [Server] instance
     *
     * @throws ServerCreateException when failed to create a server
     */
    fun createServer(port: Int): Server {
        try {
            return object : Server {
                private val serverSocket = ServerSocket(port)

                override fun accept(): ChatSocketImpl {
                    try {
                        return ChatSocketImpl(serverSocket.accept())
                    } catch (e: Exception) {
                        logger.log(Level.WARNING, "Exception: ", e)
                        throw AcceptConnectionException()
                    }
                }

                override fun close() {
                    try {
                        serverSocket.close()
                    } catch (e: Exception) {
                        logger.log(Level.WARNING, "Exception: ", e)
                        throw ClosingServerException()
                    }
                }
            }
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Exception: ", e)
            throw ServerCreateException()
        }
    }

    /**
     * Creates a [ChatSocket] to communicate.
     *
     * @param ipAddress ip-address in string representation
     * @param port port of connection
     *
     * @return [ChatSocket] to communicate
     *
     * @throws AcceptConnectionException when failed to accept a connection
     */
    fun createClient(ipAddress: String, port: Int): ChatSocket {
        try {
            return ChatSocketImpl(Socket(ipAddress, port))
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Exception: ", e)
            throw AcceptConnectionException()
        }
    }
}