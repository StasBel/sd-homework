[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.print](../index.md) / [Printer](index.md) / [print](.)

# print

`abstract fun print(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): Unit` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/print/Printer.kt#L19)

Printing out current game state from a [self](print.md#ru.spbau.mit.belyaev.print.Printer$print(ru.spbau.mit.belyaev.world.Creature, ru.spbau.mit.belyaev.world.World, ru.spbau.mit.belyaev.map.Map, ru.spbau.mit.belyaev.game.Game)/self) perspective of view.

### Parameters

`self` - a creature to centered in print

`world` - a world to observe, consist of only entities we know about

`game` - a instance of [Game](../../ru.spbau.mit.belyaev.game/-game/index.md)