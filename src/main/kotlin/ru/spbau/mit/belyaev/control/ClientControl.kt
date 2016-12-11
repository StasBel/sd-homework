package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.model.AcceptConnectionException
import ru.spbau.mit.belyaev.view.ClientView
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author belaevstanislav
 */
class ClientControl(control: Control) : AbstractControl<ClientView>(ClientView()) {
    companion object {
        private val logger = Logger.getLogger(ClientControl::class.simpleName)
    }

    init {
        // set default ip-address
        panel.ipAddressTextField.text = DEFAULT_IP_ADDRESS

        // set default port
        panel.portTextField.text = DEFAULT_PORT.toString()

        // back button
        panel.backButton.addActionListener { e -> control.pop() }

        // connect button
        panel.connectButton.addActionListener {
            e ->
            try {
                val ipAddress = panel.ipAddressTextField.text
                val port = panel.portTextField.text.toInt()
                val chatSocket = control.model.createClient(ipAddress, port)
                control.push(ChatControl(control, chatSocket))
            } catch (e: NumberFormatException) {
                logger.log(Level.WARNING, "Failed to parse port int num")
            } catch (e: AcceptConnectionException) {
                logger.log(Level.SEVERE, "Exception: ", e)
            }
        }
    }
}