[sd-homework](../index.md) / [ru.spbau.mit.belyaev.world](.)

## Package ru.spbau.mit.belyaev.world

### Types

| Name | Summary |
|---|---|
| [Creature](-creature/index.md) | `abstract class Creature : `[`Unit`](-unit/index.md)<br>Creature abstract class. You can create an instance of it only using Builder.
Creature is essential of living unit of the game field which have some params. |
| [CreatureStatus](-creature-status/index.md) | `enum class CreatureStatus : Enum<`[`CreatureStatus`](-creature-status/index.md)`>`<br>Status of [Creature](-creature/index.md). |
| [CreatureType](-creature-type/index.md) | `enum class CreatureType : Enum<`[`CreatureType`](-creature-type/index.md)`>`<br>A type of [Creature](-creature/index.md). |
| [Item](-item/index.md) | `abstract class Item : `[`Unit`](-unit/index.md)<br>Abstract class whit private constuctor. To create an instace use
static factorty method pattern. |
| [ItemStatus](-item-status/index.md) | `enum class ItemStatus : Enum<`[`ItemStatus`](-item-status/index.md)`>`<br>Status of the [Item](-item/index.md). |
| [ItemType](-item-type/index.md) | `enum class ItemType : Enum<`[`ItemType`](-item-type/index.md)`>`<br>Type of the [Item](-item/index.md). |
| [Items](-items/index.md) | `class Items : Any`<br>Useful class using for interactions with [Creature](-creature/index.md) items. |
| [Move](-move/index.md) | `enum class Move : Enum<`[`Move`](-move/index.md)`>`<br>Move type using in game. |
| [Params](-params/index.md) | `data class Params : Any`<br>Useful data class for basic unit mutable params with bunch of operators. |
| [Pos](-pos/index.md) | `data class Pos : Any`<br>Basic position on the map grid class which essentially is a pair of [Int](#).
Has some operators overloaded. |
| [Race](-race/index.md) | `enum class Race : Enum<`[`Race`](-race/index.md)`>`<br>Race of [Creature](-creature/index.md). |
| [Unit](-unit/index.md) | `abstract class Unit : Any`<br>An abstract entity denoting all entities that have position [Pos](-pos/index.md). |
| [World](-world/index.md) | `data class World : Any`<br>A simple class to store world entities like creatures and items. |
