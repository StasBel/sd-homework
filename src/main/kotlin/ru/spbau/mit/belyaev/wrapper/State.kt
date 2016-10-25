package ru.spbau.mit.belyaev.wrapper

import ru.spbau.mit.belyaev.Context

/**
 * Created by belaevstanislav on 25.10.16.
 */

class State(val context: Context, val error: (String) -> Unit, var pipe: String? = null) {
}