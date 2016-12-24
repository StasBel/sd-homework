package ru.spbau.mit.belyaev

import ru.spbau.mit.belyaev.parser.CommandStream

/**
 * State of executing using in shell.
 * @author belaevstanislav
 */
data class State(val context: Context,
                 val commands: CommandStream,
                 val error: (String) -> Unit = { m -> commands.error(m) },
                 var pipe: String? = null)