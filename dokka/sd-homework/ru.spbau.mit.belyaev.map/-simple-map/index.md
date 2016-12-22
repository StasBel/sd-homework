[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.map](../index.md) / [SimpleMap](.)

# SimpleMap

`class SimpleMap : `[`Map`](../-map/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/map/SimpleMap.kt#L9)

Just simple [Map](../-map/index.md) implementation with array of arrays of [CellType](../-cell-type/index.md).

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SimpleMap(cells: Array<Array<`[`CellType`](../-cell-type/index.md)`>>)`<br>Just simple [Map](../-map/index.md) implementation with array of arrays of [CellType](../-cell-type/index.md). |

### Functions

| Name | Summary |
|---|---|
| [getCellType](get-cell-type.md) | `fun getCellType(pos: `[`Pos`](../../ru.spbau.mit.belyaev.world/-pos/index.md)`): `[`CellType`](../-cell-type/index.md)<br>Get type of the cell in the pos. |
| [getXSize](get-x-size.md) | `fun getXSize(): Int`<br>Get maximum size of x axis. |
| [getYSIze](get-y-s-ize.md) | `fun getYSIze(): Int`<br>Get maximum size of y axis. |
