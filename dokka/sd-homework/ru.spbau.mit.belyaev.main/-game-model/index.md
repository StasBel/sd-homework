[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.main](../index.md) / [GameModel](.)

# GameModel

`class GameModel : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/main/GameModel.kt#L22)

Model class implementing main game logic using basic classes.

### Parameters

`map` - a instance of [Map](../../ru.spbau.mit.belyaev.map/-map/index.md)

`world` - a instance of [World](../../ru.spbau.mit.belyaev.world/-world/index.md)

`game` - a instance of [Game](../../ru.spbau.mit.belyaev.game/-game/index.md)

`strategies` - using for assigning a particular strategy to a creature

`printer` - a instance of [Printer](../../ru.spbau.mit.belyaev.print/-printer/index.md)

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GameModel(map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`, strategies: Map<`[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, `[`Strategy`](../../ru.spbau.mit.belyaev.strategy/-strategy/index.md)`>, printer: `[`Printer`](../../ru.spbau.mit.belyaev.print/-printer/index.md)`)`<br>just store some vals |

### Functions

| Name | Summary |
|---|---|
| [tick](tick.md) | `fun tick(): `[`GameOverType`](../-game-over-type/index.md)<br>Processing a one tick creatures acting. |
