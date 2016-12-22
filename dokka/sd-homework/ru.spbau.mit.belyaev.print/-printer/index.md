[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.print](../index.md) / [Printer](.)

# Printer

`interface Printer : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/print/Printer.kt#L12)

Basic Roguelike class using for printing out current running game state.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [print](print.md) | `abstract fun print(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): Unit`<br>Printing out current game state from a [self](print.md#ru.spbau.mit.belyaev.print.Printer$print(ru.spbau.mit.belyaev.world.Creature, ru.spbau.mit.belyaev.world.World, ru.spbau.mit.belyaev.map.Map, ru.spbau.mit.belyaev.game.Game)/self) perspective of view. |

### Inheritors

| Name | Summary |
|---|---|
| [ASCIIPrinter](../-a-s-c-i-i-printer/index.md) | `class ASCIIPrinter : Printer`<br>A simple implementation of terminal ascii printer, implementing Printer interface. |
