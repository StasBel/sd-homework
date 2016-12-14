package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.model.ChatListener
import ru.spbau.mit.belyaev.model.ClosingConnectionException
import ru.spbau.mit.belyaev.model.CommunicateException
import ru.spbau.mit.belyaev.model.Writer
import ru.spbau.mit.belyaev.view.ChatView
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.SwingUtilities
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

/**
 * @author belaevstanislav
 */
class ChatControl(private val control: Control)
    : AbstractControl<ChatView>(ChatView()), ChatListener {
    companion object {
        private val logger = Logger.getLogger(ChatControl::class.simpleName)
    }

    lateinit private var writer: Writer
    lateinit private var userInfo: Proto.UserInfo

    init {
        // typing
        panel.writeTextArea.document.addDocumentListener(object : DocumentListener {
            override fun changedUpdate(e: DocumentEvent?) {
            }

            override fun insertUpdate(e: DocumentEvent) {
                if (panel.writeTextArea.text != "") {
                    writer.notifyTyping(Proto.Typing.newBuilder().build())
                }
            }

            override fun removeUpdate(e: DocumentEvent?) {
                if (panel.writeTextArea.text != "") {
                    writer.notifyTyping(Proto.Typing.newBuilder().build())
                }
            }
        })

        // send button
        panel.sendButton.addActionListener {
            try {
                val textMessage = Proto.TextMessage.newBuilder()
                        .setTime(System.currentTimeMillis() / 1000L)
                        .setText(panel.getText())
                        .build()
                writer.sendTextMessage(textMessage)
                panel.drawSend(control.myUserInfo, textMessage)
            } catch (e: CommunicateException) {
                logger.log(Level.SEVERE, "Exception: ", e)
                control.pop()
            }
        }

        // back button
        panel.backButton.addActionListener {
            try {
                writer.close()
            } catch (e: ClosingConnectionException) {
                logger.log(Level.WARNING, "Exception: ", e)
            } finally {
                control.pop()
            }
        }
    }

    fun startChat(writerToWrite: Writer) {
        // late init
        writer = writerToWrite

        // sending user info
        try {
            writer.sendUserInfo(control.myUserInfo)
        } catch (e: CommunicateException) {
            logger.log(Level.WARNING, "Exception: ", e)
        }
    }

    override fun onUserInfo(userInfo: Proto.UserInfo) {
        this.userInfo = userInfo
    }

    override fun onMessage(textMessage: Proto.TextMessage) {
        try {
            SwingUtilities.invokeLater { panel.drawGet(userInfo, textMessage) }
        } catch (e: CommunicateException) {
            logger.log(Level.SEVERE, "Exception: ", e)
            SwingUtilities.invokeLater { control.pop(); }
        }
    }

    override fun onTyping(typing: Proto.Typing) {
        panel.showTyping(userInfo)
    }

    override fun onError() {
        control.pop()
    }

    override fun onClose() {
        control.pop()
    }
}