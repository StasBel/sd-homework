[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.world](../index.md) / [Unit](.)

# Unit

`abstract class Unit : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/world/Unit.kt#L7)

An abstract entity denoting all entities that have position [Pos](../-pos/index.md).

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Unit(pos: `[`Pos`](../-pos/index.md)`)`<br>An abstract entity denoting all entities that have position [Pos](../-pos/index.md). |

### Properties

| Name | Summary |
|---|---|
| [pos](pos.md) | `val pos: `[`Pos`](../-pos/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Creature](../-creature/index.md) | `abstract class Creature : Unit`<br>Creature abstract class. You can create an instance of it only using Builder.
Creature is essential of living unit of the game field which have some params. |
| [Item](../-item/index.md) | `abstract class Item : Unit`<br>Abstract class whit private constuctor. To create an instace use
static factorty method pattern. |
