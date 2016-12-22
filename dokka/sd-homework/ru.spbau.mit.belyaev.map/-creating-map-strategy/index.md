[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.map](../index.md) / [CreatingMapStrategy](.)

# CreatingMapStrategy

`interface CreatingMapStrategy : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/map/CreatingMapStrategy.kt#L7)

An interface using for implementing a map creator class.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `abstract fun create(): <ERROR CLASS><`[`Map`](../-map/index.md)`, `[`ProtoWorld`](../-proto-world/index.md)`>`<br>Creates a initial [Map](../-map/index.md) and set of proto objects as an instance of [ProtoWorld](../-proto-world/index.md). |

### Inheritors

| Name | Summary |
|---|---|
| [FromFileCreatingMapStrategy](../-from-file-creating-map-strategy/index.md) | `class FromFileCreatingMapStrategy : CreatingMapStrategy`<br>Implementation of creating map strategy CreatingMapStrategy. Reads map
from a file, then added blocking walls to it. |
