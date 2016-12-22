[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.world](../index.md) / [Pos](.)

# Pos

`data class Pos : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/world/Geom.kt#L22)

Basic position on the map grid class which essentially is a pair of [Int](#).
Has some operators overloaded.

### Parameters

`x` - x pos

`y` - y pos

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Pos(x: Int, y: Int)`<br>Basic position on the map grid class which essentially is a pair of [Int](#).
Has some operators overloaded. |

### Properties

| Name | Summary |
|---|---|
| [x](x.md) | `var x: Int` |
| [y](y.md) | `var y: Int` |

### Functions

| Name | Summary |
|---|---|
| [isSee](is-see.md) | `fun isSee(pos: Pos, maxRange: Int): Boolean`<br>Basic math operation - checking if [pos](is-see.md#ru.spbau.mit.belyaev.world.Pos$isSee(ru.spbau.mit.belyaev.world.Pos, kotlin.Int)/pos) is in [this](#) visibility rande. |
| [plus](plus.md) | `operator fun plus(pos: Pos): Pos` |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(pos: Pos): Unit`<br>`operator fun plusAssign(move: `[`Move`](../-move/index.md)`): Unit` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [NULL](-n-u-l-l.md) | `val NULL: Pos`<br>NULL pos in some cases useful for denoting unattainable items. |
