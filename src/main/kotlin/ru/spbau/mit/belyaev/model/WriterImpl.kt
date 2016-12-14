package ru.spbau.mit.belyaev.model

import io.grpc.stub.StreamObserver
import ru.spbau.mit.belyaev.message.Proto
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Implementing the [Writer] interface.
 *
 * @author belaevstanislav
 *
 * @property streamObserver grpc class using to write data
 *
 * @constructor creates a [Writer] using [StreamObserver]
 */
internal class WriterImpl(private val streamObserver: StreamObserver<Proto.Message>) : Writer {
    companion object {
        private val logger = Logger.getLogger(WriterImpl::class.simpleName)
    }

    override fun sendUserInfo(userInfo: Proto.UserInfo) {
        try {
            logger.log(Level.INFO, "Sending ", userInfo)
            streamObserver.onNext(Proto.Message.newBuilder().setUserInfo(userInfo).build())
        } catch (e: Exception) {
            throw CommunicateException()
        }
    }

    override fun sendTextMessage(textMessage: Proto.TextMessage) {
        try {
            logger.log(Level.INFO, "Sending ", textMessage)
            streamObserver.onNext(Proto.Message.newBuilder().setTextMessage(textMessage).build())
        } catch (e: Exception) {
            throw CommunicateException()
        }
    }

    override fun notifyTyping(typing: Proto.Typing) {
        try {
            logger.log(Level.INFO, "Sending ", typing)
            streamObserver.onNext(Proto.Message.newBuilder().setTyping(typing).build())
        } catch (e: Exception) {
            throw CommunicateException()
        }
    }

    override fun close() {
        try {
            logger.log(Level.INFO, "Closing the connection")
            streamObserver.onCompleted()
        } catch (e: Exception) {
            throw ClosingConnectionException()
        }
    }
}