package ru.spbau.mit.belyaev.model

import io.grpc.ManagedChannelBuilder
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import ru.spbau.mit.belyaev.message.ChatGrpc
import ru.spbau.mit.belyaev.message.Proto
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.Executors
import java.util.logging.Level
import java.util.logging.Logger

/**
 * A class using for create [Server] and [Client].
 *
 * @author belaevstanislav
 *
 * @constructor empty constructor
 */
class Model {
    companion object {
        private val serverLogger = Logger.getLogger(Server::class.simpleName)
        private val clientLogger = Logger.getLogger(Client::class.simpleName)
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
                private val futureService
                        = ExecutorCompletionService<StreamObserver<Proto.Message>>(Executors.newSingleThreadExecutor())
                lateinit private var server: io.grpc.Server

                override fun start(chatListener: ChatListener) {
                    try {
                        server = ServerBuilder.forPort(port)
                                .addService(object : ChatGrpc.ChatImplBase() {
                                    override fun chat(responseObserver: StreamObserver<Proto.Message>?)
                                            : StreamObserver<Proto.Message> {
                                        futureService.submit(Callable { responseObserver })
                                        return Reader(chatListener)
                                    }
                                })
                                .build()
                        serverLogger.log(Level.INFO, "Starting the server")
                        server.start()
                    } catch (e: Exception) {
                        throw ServerStartException()
                    }
                }

                override fun accept(): Writer {
                    try {
                        val stream = futureService.take().get()
                        serverLogger.log(Level.INFO, "Accepting the connection")
                        return WriterImpl(stream)
                    } catch (e: Exception) {
                        throw AcceptConnectionException()
                    }
                }

                override fun close() {
                    try {
                        serverLogger.log(Level.INFO, "Shutting down the Server")
                        server.shutdown()
                    } catch (e: Exception) {
                        throw ServerCloseException()
                    }
                }
            }
        } catch (e: Exception) {
            throw ServerCreateException()
        }
    }

    /**
     * Creates a [Client] to communicate.
     *
     * @param ipAddress ip-address in string representation
     * @param port port of connection
     *
     * @return [Client] instance of
     *
     * @throws ClientCreateException when failed to accept a connection
     */
    fun createClient(ipAddress: String, port: Int): Client {
        try {
            return object : Client {
                private val channel = ManagedChannelBuilder.forAddress(ipAddress, port)
                        .usePlaintext(true)
                        .build()

                override fun connect(chatListener: ChatListener): Writer {
                    try {
                        val stub = ChatGrpc.newStub(channel)
                        val stream = stub.chat(Reader(chatListener))
                        clientLogger.log(Level.INFO, "Created a connection")
                        return WriterImpl(stream)
                    } catch (e: Exception) {
                        throw AcceptConnectionException()
                    }
                }

                override fun close() {
                    try {
                        clientLogger.log(Level.INFO, "Shutting down the Client")
                        channel.shutdown()
                    } catch (e: Exception) {
                        throw ClientCloseException()
                    }
                }
            }
        } catch (e: Exception) {
            throw ClientCreateException()
        }
    }

    private class Reader(private val chatListener: ChatListener) : StreamObserver<Proto.Message> {
        companion object {
            private val logger = Logger.getLogger(Reader::class.simpleName)
        }

        override fun onNext(value: Proto.Message) {
            logger.log(Level.INFO, "Get message of type ${value.typeCase}")
            when (value.typeCase) {
                Proto.Message.TypeCase.USERINFO -> chatListener.onUserInfo(value.userInfo)
                Proto.Message.TypeCase.TEXTMESSAGE -> chatListener.onMessage(value.textMessage)
                Proto.Message.TypeCase.TYPING -> chatListener.onTyping(value.typing)
                Proto.Message.TypeCase.TYPE_NOT_SET -> logger.log(Level.WARNING, "Wrong message type!")
                else -> logger.log(Level.WARNING, "Lack of a message type in body!")
            }
        }

        override fun onError(t: Throwable) {
            logger.log(Level.INFO, "Handle error ", t)
            chatListener.onError()
        }

        override fun onCompleted() {
            logger.log(Level.INFO, "Completing ")
            chatListener.onClose()
        }
    }
}