[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.world](../index.md) / [Params](.)

# Params

`data class Params : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/world/Params.kt#L7)

Useful data class for basic unit mutable params with bunch of operators.

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Params(hp: Int = 0, maxHp: Int = 0, hpRegen: Int = 0, armor: Int = 0, attack: Int = 0)`<br>Useful data class for basic unit mutable params with bunch of operators. |

### Properties

| Name | Summary |
|---|---|
| [armor](armor.md) | `var armor: Int` |
| [attack](attack.md) | `var attack: Int` |
| [hp](hp.md) | `var hp: Int` |
| [hpRegen](hp-regen.md) | `var hpRegen: Int` |
| [maxHp](max-hp.md) | `var maxHp: Int` |

### Functions

| Name | Summary |
|---|---|
| [minusAssign](minus-assign.md) | `operator fun minusAssign(params: Params): Unit` |
| [plus](plus.md) | `operator fun plus(params: Params): Params` |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(params: Params): Unit` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DEFAULT](-d-e-f-a-u-l-t.md) | `val DEFAULT: Params` |
