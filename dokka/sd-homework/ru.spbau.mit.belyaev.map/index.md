[sd-homework](../index.md) / [ru.spbau.mit.belyaev.map](.)

## Package ru.spbau.mit.belyaev.map

### Types

| Name | Summary |
|---|---|
| [CellType](-cell-type/index.md) | `enum class CellType : Enum<`[`CellType`](-cell-type/index.md)`>`<br>Map cell type. Have only walls and emptiness so far. |
| [CreatingMapStrategy](-creating-map-strategy/index.md) | `interface CreatingMapStrategy : Any`<br>An interface using for implementing a map creator class. |
| [FromFileCreatingMapStrategy](-from-file-creating-map-strategy/index.md) | `class FromFileCreatingMapStrategy : `[`CreatingMapStrategy`](-creating-map-strategy/index.md)<br>Implementation of creating map strategy [CreatingMapStrategy](-creating-map-strategy/index.md). Reads map
from a file, then added blocking walls to it. |
| [Map](-map/index.md) | `interface Map : Any`<br>Roguelike world map simple interface. |
| [ProtoCreature](-proto-creature/index.md) | `data class ProtoCreature : Any`<br>Storing proto creature. Proto creature is essentially a bunch
but incomplete characteristic of [Creature](#). |
| [ProtoItem](-proto-item/index.md) | `data class ProtoItem : Any`<br>Storing proto item. Proto item is essentially a bunch
but incomplete characteristic of [Item](#). |
| [ProtoWorld](-proto-world/index.md) | `data class ProtoWorld : Any`<br>Storing proto world. Proto world is essentially a bunch
but incomplete characteristic of [World](#). |
| [SimpleMap](-simple-map/index.md) | `class SimpleMap : `[`Map`](-map/index.md)<br>Just simple [Map](-map/index.md) implementation with array of arrays of [CellType](-cell-type/index.md). |
