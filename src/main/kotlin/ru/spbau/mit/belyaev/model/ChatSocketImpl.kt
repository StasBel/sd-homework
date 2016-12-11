package ru.spbau.mit.belyaev.model

import ru.spbau.mit.belyaev.message.Proto
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author belaevstanislav
 *
 * Implementing the [ChatSocket] interface.
 *
 * @property socket java socket used to drawSend and drawGet data
 *
 * @constructor creates a [ChatSocket] using java socket
 */
class ChatSocketImpl(private val socket: Socket) : ChatSocket {
    companion object {
        private val logger = Logger.getLogger(ChatSocketImpl::class.simpleName)
    }

    /**
     * @see ChatSocket.isOpen
     */
    override fun isOpen(): Boolean {
        return !socket.isClosed
    }

    /**
     * @see ChatSocket.getMessage
     */
    override fun getMessage(): Proto.Message {
        try {
            val dataInputStream = DataInputStream(socket.inputStream)
            val data = ByteArray(dataInputStream.readInt())
            dataInputStream.readFully(data)
            return Proto.Message.parseFrom(data)
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Exception: ", e)
            throw CommunicateException()
        }
    }

    /**
     * @see ChatSocket.sendMessage
     */
    override fun sendMessage(message: Proto.Message) {
        try {
            val dataOutputStream = DataOutputStream(socket.outputStream)
            dataOutputStream.writeInt(message.serializedSize)
            dataOutputStream.write(message.toByteArray())
            dataOutputStream.flush()
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Exception: ", e)
            throw CommunicateException()
        }
    }

    /**
     * @see ChatSocket.close
     */
    override fun close() {
        try {
            socket.close()
        } catch (e: Exception) {
            logger.log(Level.WARNING, "Exception: ", e)
            throw ClosingConnectionException()
        }
    }
}