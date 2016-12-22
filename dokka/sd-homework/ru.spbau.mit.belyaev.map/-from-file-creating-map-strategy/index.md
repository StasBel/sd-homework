[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.map](../index.md) / [FromFileCreatingMapStrategy](.)

# FromFileCreatingMapStrategy

`class FromFileCreatingMapStrategy : `[`CreatingMapStrategy`](../-creating-map-strategy/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/map/FromFileCreatingMapStrategy.kt#L15)

Implementation of creating map strategy [CreatingMapStrategy](../-creating-map-strategy/index.md). Reads map
from a file, then added blocking walls to it.

### Parameters

`filePath` - a path to a file to open

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FromFileCreatingMapStrategy(filePath: String)`<br>Implementation of creating map strategy [CreatingMapStrategy](../-creating-map-strategy/index.md). Reads map
from a file, then added blocking walls to it. |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(): <ERROR CLASS><`[`Map`](../-map/index.md)`, `[`ProtoWorld`](../-proto-world/index.md)`>`<br>Reads map from a file. Add blocking walls around. Add mobs and players
according to the maps in [ReaderParams](#). |
