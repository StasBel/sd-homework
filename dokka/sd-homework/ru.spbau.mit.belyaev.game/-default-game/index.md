[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.game](../index.md) / [DefaultGame](.)

# DefaultGame

`class DefaultGame : `[`Game`](../-game/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/game/DefaultGame.kt#L12)

My default in-game consts.

**See Also**

[Game](../-game/index.md)

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DefaultGame(gameName: String = "Roguelike v0.1", gameInputMode: `[`GameInputMode`](../-game-input-mode/index.md)` = GameInputMode.BLOCKING, xSize: Int = 20, ySize: Int = 35, maxVisibilityRange: Int = 10, playerStrategy: `[`Strategy`](../../ru.spbau.mit.belyaev.strategy/-strategy/index.md)` = PlayerStrategy())`<br>My default in-game consts. |

### Properties

| Name | Summary |
|---|---|
| [gameInputMode](game-input-mode.md) | `val gameInputMode: `[`GameInputMode`](../-game-input-mode/index.md) |
| [gameName](game-name.md) | `val gameName: String`<br>The name of that roguelike game. |
| [maxVisibilityRange](max-visibility-range.md) | `val maxVisibilityRange: Int`<br>Maximum visibility range for observe other creatures and items on playing grid. |
| [playerStrategy](player-strategy.md) | `val playerStrategy: `[`Strategy`](../../ru.spbau.mit.belyaev.strategy/-strategy/index.md)<br>Player strategy implementation. |
| [xSize](x-size.md) | `val xSize: Int`<br>Max output screen size for x axis (from up to down). |
| [ySize](y-size.md) | `val ySize: Int`<br>Max output screen size for y axis (from left to right) |

### Functions

| Name | Summary |
|---|---|
| [random](random.md) | `fun random(mod: Int): Int`<br>The random functions using for different purposes. |
