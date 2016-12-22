[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.strategy](../index.md) / [Strategy](.)

# Strategy

`interface Strategy : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/strategy/Strategy.kt#L12)

Class using for implementing a acting strategy of creatures in game action.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [act](act.md) | `abstract fun act(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): `[`Action`](../-action/index.md)<br>Doing an action. |

### Inheritors

| Name | Summary |
|---|---|
| [MobStrategy](../-mob-strategy/index.md) | `class MobStrategy : Strategy`<br>Simple mob strategy moving straight to seeing enemy. |
| [NothingStrategy](../-nothing-strategy/index.md) | `class NothingStrategy : Strategy`<br>Doing nothing strategy. |
| [PlayerStrategy](../-player-strategy/index.md) | `class PlayerStrategy : Strategy`<br>An implementation of player strategy which reading keyboard input
and convert it to instances of [Action](../-action/index.md) class. |
| [RandomMoveStrategy](../-random-move-strategy/index.md) | `class RandomMoveStrategy : Strategy`<br>A random move strategy. |
