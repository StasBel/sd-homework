package ru.spbau.mit.belyaev.view

import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.message.VerticalFlowLayout
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import java.text.SimpleDateFormat
import java.util.*
import java.util.Timer
import javax.swing.*

/**
 * @author belaevstanislav
 */
class ChatView : AbstractView() {
    private val messagesPanel: JPanel
    private val messagesScrollPane: JScrollPane
    private val typingLabel: JLabel

    private var typingTimer: Timer = Timer()

    val writeTextArea: JTextArea
    val sendButton: JButton
    val backButton: JButton

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val chatPanel = JPanel()
        chatPanel.layout = BoxLayout(chatPanel, BoxLayout.Y_AXIS)
        // messages panel
        messagesPanel = JPanel()
        messagesScrollPane = JScrollPane(messagesPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)
        messagesPanel.layout = VerticalFlowLayout(VerticalFlowLayout.TOP, 0, 0, true, false)
        chatPanel.add(messagesScrollPane)
        // typing label
        typingLabel = JLabel()
        chatPanel.add(typingLabel)
        val writeTextPanel = JPanel()
        writeTextPanel.layout = BorderLayout()
        writeTextPanel.minimumSize = Dimension(100, 60)
        writeTextPanel.preferredSize = Dimension(100, 60)
        writeTextPanel.maximumSize = Dimension(Short.MAX_VALUE.toInt(), 60)
        // write text area
        writeTextArea = JTextArea()
        writeTextArea.border = JTEXTFIELD_BORDER
        writeTextArea.lineWrap = true
        val writeScrollPane = JScrollPane(writeTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)
        writeTextPanel.add(writeScrollPane, BorderLayout.CENTER)
        // drawSend button
        sendButton = JButton("Send")
        sendButton.preferredSize = Dimension(60, 60)
        sendButton.maximumSize = Dimension(60, 60)
        writeTextPanel.add(sendButton, BorderLayout.EAST)
        chatPanel.add(writeTextPanel)
        add(chatPanel)
        val bottomPanel = JPanel()
        bottomPanel.layout = BoxLayout(bottomPanel, BoxLayout.X_AXIS)
        // back button
        backButton = MyButton("Back")
        bottomPanel.add(backButton)
        add(bottomPanel)
    }

    private abstract class Message(userInfo: Proto.UserInfo, message: Proto.TextMessage, align: String, color: Color) : JPanel() {
        companion object {
            private val simpleDateFormat = SimpleDateFormat("HH:mm:ss z")
        }

        private fun unixTimeToString(time: Long): String =
                simpleDateFormat.format(Date(time * 1000L))

        init {
            layout = BorderLayout()
            alignmentX = Component.RIGHT_ALIGNMENT
            val messagePanel = JPanel()
            messagePanel.layout = BoxLayout(messagePanel, BoxLayout.Y_AXIS)
            // timeAndName text area
            val timeAndName = JTextArea("${userInfo.name} ${unixTimeToString(message.time)}")
            timeAndName.font = timeAndName.font.deriveFont(timeAndName.font.size2D / 1.5f)
            timeAndName.isEditable = false
            timeAndName.background = color
            messagePanel.add(timeAndName)
            messagePanel.add(JSeparator())
            // text text area
            val text = JTextArea(message.text, 0, 20)
            text.font = text.font.deriveFont(text.font.size2D / 1.2f)
            text.isEditable = false
            text.lineWrap = true
            text.background = color
            messagePanel.add(text)
            messagePanel.border = JTEXTFIELD_BORDER
            messagePanel.background = color
            add(messagePanel, align)
        }
    }

    private class MyMessage(userInfo: Proto.UserInfo, textMessage: Proto.TextMessage)
        : Message(userInfo, textMessage, BorderLayout.WEST, TRANSPARENT_GREEN)

    private class NotMyMessage(userInfo: Proto.UserInfo, textMessage: Proto.TextMessage)
        : Message(userInfo, textMessage, BorderLayout.EAST, TRANSPARENT_RED)

    private fun updateScrollPane() {
        messagesPanel.validate()
        messagesPanel.revalidate()
        messagesPanel.repaint()
        val verticalMessagesScrollPane = messagesScrollPane.verticalScrollBar
        verticalMessagesScrollPane.value = verticalMessagesScrollPane.maximum
        messagesPanel.validate()
        messagesPanel.revalidate()
        messagesPanel.repaint()
    }

    fun drawSend(userInfo: Proto.UserInfo, textMessage: Proto.TextMessage) {
        writeTextArea.text = ""
        messagesPanel.add(MyMessage(userInfo, textMessage))
        updateScrollPane()
    }

    fun drawGet(userInfo: Proto.UserInfo, textMessage: Proto.TextMessage) {
        messagesPanel.add(NotMyMessage(userInfo, textMessage))
        updateScrollPane()
    }

    fun getText(): String = writeTextArea.text

    fun showTyping(userInfo: Proto.UserInfo) {
        typingLabel.text = "${userInfo.name} is writing to you..."
        typingTimer.cancel()
        typingTimer.purge()
        typingTimer = Timer()
        typingTimer.schedule(object : TimerTask() {
            override fun run() {
                SwingUtilities.invokeLater { typingLabel.text = "" }
            }
        }, 3000)
    }
}