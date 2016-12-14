package ru.spbau.mit.belyaev.view

import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JTextField

/**
 * @author belaevstanislav
 */
class MenuView : AbstractView() {
    val usernameTextField: JTextField
    val serverButton: JButton
    val connectButton: JButton

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        add(Box.createVerticalGlue())
        // username text field
        add(MyLabel("Username:"))
        usernameTextField = MyTextField()
        add(usernameTextField)
        // server button
        serverButton = MyButton("Server")
        add(serverButton)
        // connect button
        connectButton = MyButton("Client")
        add(connectButton)
        add(Box.createVerticalGlue())
    }
}