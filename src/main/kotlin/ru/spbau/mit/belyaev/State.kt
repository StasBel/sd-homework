package ru.spbau.mit.belyaev

import ru.spbau.mit.belyaev.parser.CommandStream

/**
 * Created by belaevstanislav on 25.10.16.
 */

/**
 * State of executing using in shell.
 */
data class State(val context: Context,
                 val commands: CommandStream,
                 val error: (String) -> Unit = { m -> commands.error(m) },
                 var pipe: String? = null)