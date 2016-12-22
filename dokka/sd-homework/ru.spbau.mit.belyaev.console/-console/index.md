[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.console](../index.md) / [Console](.)

# Console

`open class Console : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/console/Console.java#L10)

Class storing some useful static functions very helpful on working with terminal.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Console()`<br>Class storing some useful static functions very helpful on working with terminal. |

### Functions

| Name | Summary |
|---|---|
| [clearConsole](clear-console.md) | `open static fun clearConsole(): Unit`<br>Clears the console output. Should works on both UNIX* and WIN. |
| [getCh](get-ch.md) | `open static fun getCh(): Char`<br>Wait for the next keyboard pressing char in non-blocking mode. |
| [main](main.md) | `open static fun main(args: Array<String>): Unit` |
