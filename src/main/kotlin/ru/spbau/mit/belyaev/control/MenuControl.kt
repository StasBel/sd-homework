package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.view.MenuView
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

/**
 * @author belaevstanislav
 */
class MenuControl(control: Control) : AbstractControl<MenuView>(MenuView()) {
    init {
        // set default nickname and update listener
        control.name = DEFAULT_NICKNAME
        panel.usernameTextField.text = DEFAULT_NICKNAME
        panel.usernameTextField.document.addDocumentListener(
                object : DocumentListener {
                    override fun changedUpdate(e: DocumentEvent?) {
                    }

                    override fun insertUpdate(e: DocumentEvent?) {
                        control.name = panel.usernameTextField.text
                    }

                    override fun removeUpdate(e: DocumentEvent?) {
                        control.name = panel.usernameTextField.text
                    }
                }
        )

        // server button
        panel.serverButton.addActionListener {
            control.push(ServerControl(control))
        }

        // client button
        panel.connectButton.addActionListener {
            control.push(ClientControl(control))
        }
    }
}