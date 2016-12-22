[sd-homework](../index.md) / [ru.spbau.mit.belyaev.main](.)

## Package ru.spbau.mit.belyaev.main

### Types

| Name | Summary |
|---|---|
| [GameModel](-game-model/index.md) | `class GameModel : Any`<br>Model class implementing main game logic using basic classes. |
| [GameOverType](-game-over-type/index.md) | `enum class GameOverType : Enum<`[`GameOverType`](-game-over-type/index.md)`>`<br>Type of game results. Nothing means nobody win. |
| [Roguelike](-roguelike/index.md) | `class Roguelike : Any`<br>Main Roguelike class using for initializing basic classes and
run the game. |

### Functions

| Name | Summary |
|---|---|
| [main](main.md) | `fun main(args: Array<String>): Unit`<br>Some default invocation of game. Note that NON_BLOCKING mode
is not working inside IDE's terminal, you have to use your native terminal
for better user experience. |
