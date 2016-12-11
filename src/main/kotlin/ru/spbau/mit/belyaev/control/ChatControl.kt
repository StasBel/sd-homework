package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.model.ChatSocket
import ru.spbau.mit.belyaev.model.ClosingConnectionException
import ru.spbau.mit.belyaev.model.CommunicateException
import ru.spbau.mit.belyaev.view.ChatView
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.SwingUtilities

/**
 * @author belaevstanislav
 */
class ChatControl(control: Control, chatSocket: ChatSocket)
    : AbstractControl<ChatView>(ChatView()) {
    companion object {
        private val logger = Logger.getLogger(ChatControl::class.simpleName)
    }

    init {
        // send button
        panel.sendButton.addActionListener {
            e ->
            try {
                val message = Proto.Message.newBuilder()
                        .setTime(System.currentTimeMillis() / 1000L)
                        .setName(control.name)
                        .setText(panel.getText())
                        .build()
                chatSocket.sendMessage(message)
                panel.drawSend(message)
            } catch (e: CommunicateException) {
                logger.log(Level.SEVERE, "Exception: ", e)
                control.pop()
            }
        }

        // back button
        panel.backButton.addActionListener {
            e ->
            try {
                chatSocket.close()
            } catch (e: ClosingConnectionException) {
                logger.log(Level.WARNING, "Exception: ", e)
            } finally {
                control.pop()
            }
        }

        // waiting to get task
        control.threadPool.submit {
            while (chatSocket.isOpen()) {
                try {
                    val message = chatSocket.getMessage()
                    SwingUtilities.invokeLater { panel.drawGet(message) }
                } catch (e: CommunicateException) {
                    logger.log(Level.SEVERE, "Exception: ", e)
                    SwingUtilities.invokeLater { control.pop(); }
                    break
                }
            }
        }
    }
}