[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.map](../index.md) / [FromFileCreatingMapStrategy](index.md) / [create](.)

# create

`fun create(): <ERROR CLASS><`[`Map`](../-map/index.md)`, `[`ProtoWorld`](../-proto-world/index.md)`>` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/map/FromFileCreatingMapStrategy.kt#L46)

Overrides [CreatingMapStrategy.create](../-creating-map-strategy/create.md)

Reads map from a file. Add blocking walls around. Add mobs and players
according to the maps in [ReaderParams](#).

**Return**
pair of [Map](../-map/index.md) and [ProtoWorld](../-proto-world/index.md)

