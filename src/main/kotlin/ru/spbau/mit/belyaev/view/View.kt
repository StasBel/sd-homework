package ru.spbau.mit.belyaev.view

import java.awt.CardLayout
import java.awt.Dimension
import java.awt.Point
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.JPanel

/**
 * Implementing main (and the only) [JFrame] of messenger. Do basic setup
 * and provide method to add views (=[JPanel]'s) to view stack with push
 * and pop methods. The top view is always on the user screen. This can be
 * very useful to easily implement back buttons.
 *
 * @author belaevstanislav
 *
 * @property appName name of the messenger app
 *
 * @constructor takes only app name
 */
class View(appName: String) : JFrame(appName) {
    private val mainPanel: JPanel
    private val mainLayout: CardLayout

    init {
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(400, 400)
        minimumSize = Dimension(400, 400)
        defaultCloseOperation = EXIT_ON_CLOSE
        location = Point((screenSize.width - size.width) / 2,
                (screenSize.height - size.height) / 2)

        mainPanel = JPanel()
        mainLayout = CardLayout()
        mainPanel.layout = mainLayout
        add(mainPanel)
    }

    /**
     * Push panel on top of the panel's stack, making it appearing on user screen
     *
     * @param panel a panel to show and push
     */
    fun pushPanel(panel: JPanel) {
        mainPanel.add(panel)
        mainLayout.next(mainPanel)
    }

    /**
     * Pop out of the stack top panel, making it disappear from user screen.
     */
    fun popPanel() {
        mainLayout.previous(mainPanel)
        mainPanel.remove(mainPanel.components.size - 1)
    }
}