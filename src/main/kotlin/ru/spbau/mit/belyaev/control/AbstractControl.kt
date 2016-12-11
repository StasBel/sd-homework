package ru.spbau.mit.belyaev.control

import ru.spbau.mit.belyaev.view.AbstractView

/**
 * @author belaevstanislav
 *
 * Base class for all controls classes with bind to a
 * particular view class using genetics constraint.
 *
 * @property t an instance of class T
 *
 * @constructor takes only one instance of class, derived from [AbstractView]
 * (which) implementing JPanel class.
 */
abstract class AbstractControl<out T>(t: T) where T : AbstractView {
    val panel: T = t
}