[sd-homework](../index.md) / [ru.spbau.mit.belyaev.strategy](.)

## Package ru.spbau.mit.belyaev.strategy

### Types

| Name | Summary |
|---|---|
| [Action](-action/index.md) | `sealed class Action : Any`<br>A sealed class of creature actions. |
| [MobStrategy](-mob-strategy/index.md) | `class MobStrategy : `[`Strategy`](-strategy/index.md)<br>Simple mob strategy moving straight to seeing enemy. |
| [NothingStrategy](-nothing-strategy/index.md) | `class NothingStrategy : `[`Strategy`](-strategy/index.md)<br>Doing nothing strategy. |
| [PlayerStrategy](-player-strategy/index.md) | `class PlayerStrategy : `[`Strategy`](-strategy/index.md)<br>An implementation of player strategy which reading keyboard input
and convert it to instances of [Action](-action/index.md) class. |
| [RandomMoveStrategy](-random-move-strategy/index.md) | `class RandomMoveStrategy : `[`Strategy`](-strategy/index.md)<br>A random move strategy. |
| [Strategy](-strategy/index.md) | `interface Strategy : Any`<br>Class using for implementing a acting strategy of creatures in game action. |
