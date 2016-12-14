package ru.spbau.mit.belyaev.view

import javax.swing.*

/**
 * @author belaevstanislav
 */
class ServerView : AbstractView() {
    val portTextField: JTextField
    val backButton: JButton
    val createServerButton: JButton

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val serverConfPanel = JPanel()
        serverConfPanel.layout = BoxLayout(serverConfPanel, BoxLayout.Y_AXIS)
        serverConfPanel.add(Box.createVerticalGlue())
        // port text field
        serverConfPanel.add(MyLabel("Port:"))
        portTextField = MyTextField()
        serverConfPanel.add(portTextField)
        serverConfPanel.add(Box.createVerticalGlue())
        add(serverConfPanel)
        val bottomPanel = JPanel()
        bottomPanel.layout = BoxLayout(bottomPanel, BoxLayout.X_AXIS)
        // back button
        backButton = MyButton("Back")
        bottomPanel.add(backButton)
        // create server button
        createServerButton = MyButton("Create server")
        bottomPanel.add(createServerButton)
        add(bottomPanel)
    }
}