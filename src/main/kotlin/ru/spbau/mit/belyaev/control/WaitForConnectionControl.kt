package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.model.AcceptConnectionException
import ru.spbau.mit.belyaev.model.Server
import ru.spbau.mit.belyaev.model.ServerCloseException
import ru.spbau.mit.belyaev.model.ServerStartException
import ru.spbau.mit.belyaev.view.WaitForConnectionView
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.SwingUtilities

/**
 * @author belaevstanislav
 */
class WaitForConnectionControl(control: Control, server: Server)
    : AbstractControl<WaitForConnectionView>(WaitForConnectionView()) {
    companion object {
        private val logger = Logger.getLogger(WaitForConnectionControl::class.simpleName)
    }

    init {
        // back button
        panel.backButton.addActionListener {
            try {
                server.close();
            } catch (e: ServerCloseException) {
                logger.log(Level.WARNING, "Exception: ", e)
            } finally {
                control.pop()
            }
        }

        // wait task
        control.threadPool.submit {
            try {
                val chatControl = ChatControl(control)
                server.start(chatControl)
                chatControl.startChat(server.accept())
                SwingUtilities.invokeLater { control.push(chatControl) }
            } catch (e: ServerStartException) {
                logger.log(Level.WARNING, "Exception: ", e)
                SwingUtilities.invokeLater { control.pop() }
            } catch (e: AcceptConnectionException) {
                logger.log(Level.WARNING, "Exception: ", e)
                SwingUtilities.invokeLater { control.pop() }
            }
        }
    }
}