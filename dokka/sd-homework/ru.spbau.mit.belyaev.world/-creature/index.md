[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.world](../index.md) / [Creature](.)

# Creature

`abstract class Creature : `[`Unit`](../-unit/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/world/Creature.kt#L53)

Creature abstract class. You can create an instance of it only using Builder.
Creature is essential of living unit of the game field which have some params.

### Parameters

`pos` - [Pos](../-pos/index.md) of creature

`creatureType` - [CreatureType](../-creature-type/index.md) of creature

`race` - [Race](../-race/index.md) of creature

`params` - [Params](../-params/index.md) of creature

`items` - [Items](../-items/index.md) of creature

`status` - [CreatureStatus](../-creature-status/index.md) of creature

**Author**
belaevstanislav

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : Any`<br>A class implementing Builder pattern for Creature class.
Has bunch of setter for Creature field, finishing with build() func to
complete create. |

### Properties

| Name | Summary |
|---|---|
| [creatureType](creature-type.md) | `val creatureType: `[`CreatureType`](../-creature-type/index.md) |
| [items](items.md) | `val items: `[`Items`](../-items/index.md) |
| [params](params.md) | `val params: `[`Params`](../-params/index.md) |
| [race](race.md) | `val race: `[`Race`](../-race/index.md) |
| [status](status.md) | `var status: `[`CreatureStatus`](../-creature-status/index.md) |

### Inherited Properties

| Name | Summary |
|---|---|
| [pos](../-unit/pos.md) | `val pos: `[`Pos`](../-pos/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addItem](add-item.md) | `fun addItem(item: `[`Item`](../-item/index.md)`): Unit`<br>Adds item to this changing it status to STORED. |
| [periodically](periodically.md) | `fun periodically(): Unit`<br>Proceeding a periodically events. |
| [toggleItem](toggle-item.md) | `fun toggleItem(item: `[`Item`](../-item/index.md)`): Unit`<br>Adds item to this changing it status from USED to STORED and vice versa. |
