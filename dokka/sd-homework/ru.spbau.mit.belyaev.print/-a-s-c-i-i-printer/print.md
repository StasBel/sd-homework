[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.print](../index.md) / [ASCIIPrinter](index.md) / [print](.)

# print

`fun print(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): Unit` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/print/ASCIIPrinter.kt#L60)

Overrides [Printer.print](../-printer/print.md)

Printing out state usuing colored ascii teminal output.

### Parameters

`self` - a creature to centered in print

`world` - a world to observe, consist of only entities we know about

`game` - a instance of [Game](../../ru.spbau.mit.belyaev.game/-game/index.md)