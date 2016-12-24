package ru.spbau.mit.belyaev.parser.command

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import ru.spbau.mit.belyaev.State

/**
 * Reproducing grep command find string matches regular expression.
 * @author belaevstanislav
 */
class Grep(private val args: List<String>?) : Command() {
    companion object {
        const val USAGE = "usage: grep [-iw] [-A n] pattern [file ...]"
    }

    private fun getOptions(): Options {
        val optionI = Option("i", false, "case_sens")
        optionI.isRequired = false
        val optionW = Option("w", false, "match")
        optionW.isRequired = false
        val optionA = Option("A", true, "repeat_str")
        optionA.args = 1
        optionA.argName = "number of strings"
        optionA.isRequired = false
        val options = Options()
        options.addOption(optionI)
        options.addOption(optionW)
        options.addOption(optionA)
        return options
    }

    private fun getStrings(text: String, beginFrom: Int, n: Int): String {
        var newLines = 0
        var right = beginFrom
        while (right != text.length - 1 && newLines < n) {
            if (text[right + 1] == '\n') newLines++
            right++
        }
        right--

        var left = beginFrom
        while (left != 0 && text[left - 1] != '\n') left--

        return text.slice(left..right)
    }

    override fun executeS(state: State): String? {
        // get option
        val options = getOptions()

        // print help if no args
        if (args == null) {
            return USAGE
        }

        // construct cli and args
        val cli = DefaultParser().parse(options, args.toTypedArray())
        val realArgs = cli.argList

        // construct regex options
        val regexOptions = run {
            if (cli.hasOption("i")) {
                setOf(RegexOption.IGNORE_CASE)
            } else {
                emptySet()
            }
        }

        // construct pattern
        val pattern = run {
            if (realArgs.size < 1) {
                state.error("Grep does't have pattern!")
            }

            if (cli.hasOption("w")) {
                "\\b" + realArgs[0] + "\\b"
            } else {
                realArgs[0]
            }
        }

        // how many extra lines to print
        val n = if (cli.hasOption("A")) {
            cli.getOptionValue("A").toInt() + 1
        } else {
            1
        }

        // construct regex
        val regex = Regex(pattern, regexOptions)

        // get texts
        val texts = run {
            state.pipe?.let { listOf(it) }
                    ?:
                    if (realArgs.size < 2) {
                        state.error("Grep does't have input!")
                        emptyList()
                    } else {
                        realArgs.drop(1).map { f -> state.context.getContent(state, f) }
                    }
        }

        // find
        val results = texts.map { t -> regex.find(t)?.let { Pair(t, it) } }
                .filterNotNull()
                .map {
                    p ->
                    val (t, mr) = p
                    getStrings(t, mr.range.start, n)
                }

        // concatenate and return
        return results.joinToString("\n")
    }
}