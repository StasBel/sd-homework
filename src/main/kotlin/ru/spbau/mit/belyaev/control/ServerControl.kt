package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.model.ServerCreateException
import ru.spbau.mit.belyaev.view.ServerView
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author belaevstanislav
 */
class ServerControl(control: Control) : AbstractControl<ServerView>(ServerView()) {
    companion object {
        private val logger = Logger.getLogger(ServerControl::class.simpleName)
    }

    init {
        // set default port
        panel.portTextField.text = DEFAULT_PORT.toString()

        // back button
        panel.backButton.addActionListener { e -> control.pop() }

        // create server button
        panel.createServerButton.addActionListener {
            try {
                val port = panel.portTextField.text.toInt()
                val server = control.model.createServer(port)
                control.push(WaitForConnectionControl(control, server))
            } catch (e: NumberFormatException) {
                logger.log(Level.WARNING, "Failed to parse port int num: ", e)
            } catch (e: ServerCreateException) {
                logger.log(Level.SEVERE, "Exception: ", e)
            }
        }
    }
}