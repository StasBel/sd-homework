[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.map](../index.md) / [Map](.)

# Map

`interface Map : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/map/Map.kt#L9)

Roguelike world map simple interface.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [getCellType](get-cell-type.md) | `abstract fun getCellType(pos: `[`Pos`](../../ru.spbau.mit.belyaev.world/-pos/index.md)`): `[`CellType`](../-cell-type/index.md)<br>Get type of the cell in the pos. |
| [getXSize](get-x-size.md) | `abstract fun getXSize(): Int`<br>Get maximum size of x axis. |
| [getYSIze](get-y-s-ize.md) | `abstract fun getYSIze(): Int`<br>Get maximum size of y axis. |

### Inheritors

| Name | Summary |
|---|---|
| [SimpleMap](../-simple-map/index.md) | `class SimpleMap : Map`<br>Just simple Map implementation with array of arrays of [CellType](../-cell-type/index.md). |
