package ru.spbau.mit.belyaev.view

import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel

/**
 * @author belaevstanislav
 */
class WaitForConnectionView : AbstractView() {
    val backButton: JButton

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val serverWaitPanel = JPanel()
        serverWaitPanel.layout = BoxLayout(serverWaitPanel, BoxLayout.Y_AXIS)
        serverWaitPanel.add(Box.createVerticalGlue())
        serverWaitPanel.add(MyLabel("Waiting for a connection..."))
        serverWaitPanel.add(Box.createVerticalGlue())
        add(serverWaitPanel)
        val bottomPanel = JPanel()
        bottomPanel.layout = BoxLayout(bottomPanel, BoxLayout.X_AXIS)
        // back button
        backButton = MyButton("Back")
        bottomPanel.add(backButton)
        add(bottomPanel)
    }
}