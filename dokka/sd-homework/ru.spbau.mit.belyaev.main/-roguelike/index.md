[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.main](../index.md) / [Roguelike](.)

# Roguelike

`class Roguelike : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/main/Roguelike.kt#L17)

Main Roguelike class using for initializing basic classes and
run the game.

### Parameters

`creatingMapStrategy` - a instance of [CreatingMapStrategy](../../ru.spbau.mit.belyaev.map/-creating-map-strategy/index.md)

`game` - a instance of [Game](../../ru.spbau.mit.belyaev.game/-game/index.md)

`printer` - a instance of [Printer](../../ru.spbau.mit.belyaev.print/-printer/index.md)

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Roguelike(creatingMapStrategy: `[`CreatingMapStrategy`](../../ru.spbau.mit.belyaev.map/-creating-map-strategy/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`, printer: `[`Printer`](../../ru.spbau.mit.belyaev.print/-printer/index.md)`)`<br>Main Roguelike class using for initializing basic classes and
run the game. |

### Functions

| Name | Summary |
|---|---|
| [run](run.md) | `fun run(maxRounds: Int = -1): `[`GameOverType`](../-game-over-type/index.md)<br>Running game for a [maxRounds](run.md#ru.spbau.mit.belyaev.main.Roguelike$run(kotlin.Int)/maxRounds) ticks (or inf ticks if we passed -1 to func). |
