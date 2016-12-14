package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.model.Model
import ru.spbau.mit.belyaev.view.View
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * A control file implementing main logic of Model-Control-View pattern.
 * Using for store common val's and var's and change controls.
 *
 * @author belaevstanislav
 *
 * @property view view to work with gui
 * @property model model to work with tcp connection
 *
 * @constructor takes view and model to store
 */
class Control(val view: View, val model: Model) {
    var name: String = DEFAULT_NICKNAME
    val threadPool: ExecutorService = Executors.newCachedThreadPool()
    val myUserInfo: Proto.UserInfo
        get() = Proto.UserInfo.newBuilder().setName(name).build()

    init {
        // for testing
        // push(ChatControl(this))

        // initial control
        push(MenuControl(this))
    }

    fun push(control: AbstractControl<*>) {
        view.pushPanel(control.panel)
    }

    fun pop() {
        view.popPanel()
    }
}
