[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.strategy](../index.md) / [PlayerStrategy](.)

# PlayerStrategy

`class PlayerStrategy : `[`Strategy`](../-strategy/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/strategy/PlayerStrategy.kt#L16)

An implementation of player strategy which reading keyboard input
and convert it to instances of [Action](../-action/index.md) class.

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerStrategy()`<br>An implementation of player strategy which reading keyboard input
and convert it to instances of [Action](../-action/index.md) class. |

### Functions

| Name | Summary |
|---|---|
| [act](act.md) | `fun act(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): `[`Action`](../-action/index.md)<br>Reading keyboard input while we cant parse an Action from it. |
