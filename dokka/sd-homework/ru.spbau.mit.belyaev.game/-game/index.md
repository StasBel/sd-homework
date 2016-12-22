[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.game](../index.md) / [Game](.)

# Game

`interface Game : Any` [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/game/Game.kt#L20)

Interface using for definition of a common game consts and random function.

**Author**
belaevstanislav

### Properties

| Name | Summary |
|---|---|
| [gameInputMode](game-input-mode.md) | `abstract val gameInputMode: `[`GameInputMode`](../-game-input-mode/index.md) |
| [gameName](game-name.md) | `abstract val gameName: String`<br>The name of that roguelike game. |
| [maxVisibilityRange](max-visibility-range.md) | `abstract val maxVisibilityRange: Int`<br>Maximum visibility range for observe other creatures and items on playing grid. |
| [playerStrategy](player-strategy.md) | `abstract val playerStrategy: `[`Strategy`](../../ru.spbau.mit.belyaev.strategy/-strategy/index.md)<br>Player strategy implementation. |
| [xSize](x-size.md) | `abstract val xSize: Int`<br>Max output screen size for x axis (from up to down). |
| [ySize](y-size.md) | `abstract val ySize: Int`<br>Max output screen size for y axis (from left to right) |

### Functions

| Name | Summary |
|---|---|
| [random](random.md) | `abstract fun random(mod: Int): Int`<br>The random functions using for different purposes. |

### Inheritors

| Name | Summary |
|---|---|
| [DefaultGame](../-default-game/index.md) | `class DefaultGame : Game`<br>My default in-game consts. |
