package ru.spbau.mit.belyaev.view

import ru.spbau.mit.belyaev.message.Proto
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.*

/**
 * @author belaevstanislav
 */
class ChatView : AbstractView() {
    private val messagesPanel: JPanel
    private val messagesScrollPane: JScrollPane
    private val writeTextArea: JTextArea

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

    private abstract class Message(message: Proto.Message, align: String, color: Color) : JPanel() {
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
            val timeAndName = JTextArea("${message.name} ${unixTimeToString(message.time)}")
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

    private class MyMessage(message: Proto.Message) : Message(message, BorderLayout.WEST, TRANSPARENT_GREEN)

    private class NotMyMessage(message: Proto.Message) : Message(message, BorderLayout.EAST, TRANSPARENT_RED)

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

    fun drawSend(message: Proto.Message) {
        writeTextArea.text = ""
        messagesPanel.add(MyMessage(message))
        updateScrollPane()
    }

    fun drawGet(message: Proto.Message) {
        messagesPanel.add(NotMyMessage(message))
        updateScrollPane()
    }

    fun getText(): String = writeTextArea.text
}