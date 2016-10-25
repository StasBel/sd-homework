package ru.spbau.mit.belyaev

import ru.spbau.mit.belyaev.parser.CommandStream

/**
 * Created by belaevstanislav on 25.10.16.
 */

class State(val context: Context,
            val commands: CommandStream,
            val error: (String) -> Unit = { m -> commands.error(m) },
            var pipe: String? = null
) {
    fun modify(newPipe: String?): State = kotlin.run { pipe = newPipe; this }
}