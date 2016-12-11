package ru.spbau.mit.belyaev.view

import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.border.Border

/**
 * @author belaevstanislav
 */

val DEFAULT_TEXT_DIM = Dimension(200, 20)
val DEFAULT_BUTTON_PREF_DIM = Dimension(0, 40)
val DEFAULT_BUTTON_MAX_DIM = Dimension(100, 40)

val JTEXTFIELD_BORDER: Border = JTextField().border

val TRANSPARENT_GREEN = Color(204, 255, 204)
val TRANSPARENT_RED = Color(255, 204, 204)

class MyLabel(text: String) : JLabel(text, JLabel.CENTER) {
    init {
        alignmentX = Component.CENTER_ALIGNMENT
        maximumSize = DEFAULT_TEXT_DIM
        minimumSize = DEFAULT_TEXT_DIM
    }
}

class MyTextField(text: String = "") : JTextField(text) {
    init {
        alignmentX = Component.CENTER_ALIGNMENT
        maximumSize = DEFAULT_TEXT_DIM
        minimumSize = DEFAULT_TEXT_DIM
    }
}

class MyButton(text: String = "") : JButton(text) {
    init {
        alignmentX = Component.CENTER_ALIGNMENT
        preferredSize = DEFAULT_BUTTON_PREF_DIM
        maximumSize = DEFAULT_BUTTON_MAX_DIM
    }
}