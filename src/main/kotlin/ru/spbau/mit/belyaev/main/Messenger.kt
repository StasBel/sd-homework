package ru.spbau.mit.belyaev.main

import ru.spbau.mit.belyaev.control.Control
import ru.spbau.mit.belyaev.model.Model
import ru.spbau.mit.belyaev.view.View

/**
 * @author belaevstanislav
 *
 * Just a simple class, using for store together and create all components of MVC pattern.
 *
 * @constructor takes no arguments
 */
class Messenger {
    private val view: View
    private val model: Model
    private val control: Control

    init {
        view = View(APP_NAME)
        model = Model()
        control = Control(view, model)
        view.isVisible = true
    }
}