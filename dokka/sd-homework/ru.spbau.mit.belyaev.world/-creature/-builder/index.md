[sd-homework](../../../index.md) / [ru.spbau.mit.belyaev.world](../../index.md) / [Creature](../index.md) / [Builder](.)

# Builder

`class Builder : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/world/Creature.kt#L64)

A class implementing Builder pattern for Creature class.
Has bunch of setter for [Creature](../index.md) field, finishing with build() func to
complete create.

### Functions

| Name | Summary |
|---|---|
| [addItems](add-items.md) | `fun addItems(items: Set<`[`Item`](../../-item/index.md)`>): Builder` |
| [build](build.md) | `fun build(): `[`Creature`](../index.md) |
| [setCreatureType](set-creature-type.md) | `fun setCreatureType(creatureType: `[`CreatureType`](../../-creature-type/index.md)`): Builder` |
| [setParams](set-params.md) | `fun setParams(params: `[`Params`](../../-params/index.md)`): Builder` |
| [setPos](set-pos.md) | `fun setPos(pos: `[`Pos`](../../-pos/index.md)`): Builder` |
| [setRace](set-race.md) | `fun setRace(race: `[`Race`](../../-race/index.md)`): Builder` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(): Builder` |
