package ru.spbau.mit.belyaev

import com.diogonunes.jcdp.color.ColoredPrinter
import com.diogonunes.jcdp.color.api.Ansi

/**
 * @author belaevstanislav
 */
fun main(args: Array<String>) {
    print("Hello, world!")

    val cp = ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.GREEN)
            .background(Ansi.BColor.MAGENTA)
            .build()

    cp.print("HI HITLER")
    cp.clear()

    println()

    val params = Params(.0, .0, .0, .0, .0)

    print(params + Params(hpRegen = -.3))
}