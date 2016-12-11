package ru.spbau.mit.belyaev.view

import javax.swing.*

/**
 * @author belaevstanislav
 */
class ClientView : AbstractView() {
    val ipAddressTextField: JTextField
    val portTextField: JTextField
    val backButton: JButton
    val connectButton: JButton

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val serverConfPanel = JPanel()
        serverConfPanel.layout = BoxLayout(serverConfPanel, BoxLayout.Y_AXIS)
        serverConfPanel.add(Box.createVerticalGlue())
        serverConfPanel.add(MyLabel("IP-Address:"))
        // ip-address text field
        ipAddressTextField = MyTextField("localhost")
        serverConfPanel.add(ipAddressTextField)
        serverConfPanel.add(MyLabel("Port:"))
        // port text field
        portTextField = MyTextField("2222")
        serverConfPanel.add(portTextField)
        serverConfPanel.add(Box.createVerticalGlue())
        add(serverConfPanel)
        val bottomPanel = JPanel()
        bottomPanel.layout = BoxLayout(bottomPanel, BoxLayout.X_AXIS)
        // back button
        backButton = MyButton("Back")
        bottomPanel.add(backButton)
        // connect button
        connectButton = MyButton("Connect")
        bottomPanel.add(connectButton)
        add(bottomPanel)
    }
}