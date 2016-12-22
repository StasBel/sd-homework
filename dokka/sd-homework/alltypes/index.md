

### All Types

| Name | Summary |
|---|---|
| [ru.spbau.mit.belyaev.print.ASCIIPrinter](../ru.spbau.mit.belyaev.print/-a-s-c-i-i-printer/index.md) | A simple implementation of terminal ascii printer, implementing [Printer](../ru.spbau.mit.belyaev.print/-printer/index.md) interface. |
| [ru.spbau.mit.belyaev.strategy.Action](../ru.spbau.mit.belyaev.strategy/-action/index.md) | A sealed class of creature actions. |
| [ru.spbau.mit.belyaev.map.CellType](../ru.spbau.mit.belyaev.map/-cell-type/index.md) | Map cell type. Have only walls and emptiness so far. |
| [ru.spbau.mit.belyaev.map.CreatingMapStrategy](../ru.spbau.mit.belyaev.map/-creating-map-strategy/index.md) | An interface using for implementing a map creator class. |
| [ru.spbau.mit.belyaev.world.Creature](../ru.spbau.mit.belyaev.world/-creature/index.md) | Creature abstract class. You can create an instance of it only using Builder.
Creature is essential of living unit of the game field which have some params. |
| [ru.spbau.mit.belyaev.world.CreatureStatus](../ru.spbau.mit.belyaev.world/-creature-status/index.md) | Status of [Creature](../ru.spbau.mit.belyaev.world/-creature/index.md). |
| [ru.spbau.mit.belyaev.world.CreatureType](../ru.spbau.mit.belyaev.world/-creature-type/index.md) | A type of [Creature](../ru.spbau.mit.belyaev.world/-creature/index.md). |
| [ru.spbau.mit.belyaev.game.DefaultGame](../ru.spbau.mit.belyaev.game/-default-game/index.md) | My default in-game consts. |
| [ru.spbau.mit.belyaev.map.FromFileCreatingMapStrategy](../ru.spbau.mit.belyaev.map/-from-file-creating-map-strategy/index.md) | Implementation of creating map strategy [CreatingMapStrategy](../ru.spbau.mit.belyaev.map/-creating-map-strategy/index.md). Reads map
from a file, then added blocking walls to it. |
| [ru.spbau.mit.belyaev.game.Game](../ru.spbau.mit.belyaev.game/-game/index.md) | Interface using for definition of a common game consts and random function. |
| [ru.spbau.mit.belyaev.game.GameInputMode](../ru.spbau.mit.belyaev.game/-game-input-mode/index.md) | Game console input mode. Blocking mode force you to press enter after
every input string (thus, letter too). Non-blocking mode acting without
enter, waiting for you next char to press, but it does't work inside IDE's. |
| [ru.spbau.mit.belyaev.main.GameModel](../ru.spbau.mit.belyaev.main/-game-model/index.md) | Model class implementing main game logic using basic classes. |
| [ru.spbau.mit.belyaev.main.GameOverType](../ru.spbau.mit.belyaev.main/-game-over-type/index.md) | Type of game results. Nothing means nobody win. |
| [ru.spbau.mit.belyaev.world.Item](../ru.spbau.mit.belyaev.world/-item/index.md) | Abstract class whit private constuctor. To create an instace use
static factorty method pattern. |
| [ru.spbau.mit.belyaev.world.ItemStatus](../ru.spbau.mit.belyaev.world/-item-status/index.md) | Status of the [Item](../ru.spbau.mit.belyaev.world/-item/index.md). |
| [ru.spbau.mit.belyaev.world.ItemType](../ru.spbau.mit.belyaev.world/-item-type/index.md) | Type of the [Item](../ru.spbau.mit.belyaev.world/-item/index.md). |
| [ru.spbau.mit.belyaev.world.Items](../ru.spbau.mit.belyaev.world/-items/index.md) | Useful class using for interactions with [Creature](../ru.spbau.mit.belyaev.world/-creature/index.md) items. |
| [ru.spbau.mit.belyaev.map.Map](../ru.spbau.mit.belyaev.map/-map/index.md) | Roguelike world map simple interface. |
| [ru.spbau.mit.belyaev.strategy.MobStrategy](../ru.spbau.mit.belyaev.strategy/-mob-strategy/index.md) | Simple mob strategy moving straight to seeing enemy. |
| [ru.spbau.mit.belyaev.world.Move](../ru.spbau.mit.belyaev.world/-move/index.md) | Move type using in game. |
| [ru.spbau.mit.belyaev.strategy.NothingStrategy](../ru.spbau.mit.belyaev.strategy/-nothing-strategy/index.md) | Doing nothing strategy. |
| [ru.spbau.mit.belyaev.world.Params](../ru.spbau.mit.belyaev.world/-params/index.md) | Useful data class for basic unit mutable params with bunch of operators. |
| [ru.spbau.mit.belyaev.strategy.PlayerStrategy](../ru.spbau.mit.belyaev.strategy/-player-strategy/index.md) | An implementation of player strategy which reading keyboard input
and convert it to instances of [Action](../ru.spbau.mit.belyaev.strategy/-action/index.md) class. |
| [ru.spbau.mit.belyaev.world.Pos](../ru.spbau.mit.belyaev.world/-pos/index.md) | Basic position on the map grid class which essentially is a pair of [Int](#).
Has some operators overloaded. |
| [ru.spbau.mit.belyaev.print.Printer](../ru.spbau.mit.belyaev.print/-printer/index.md) | Basic Roguelike class using for printing out current running game state. |
| [ru.spbau.mit.belyaev.map.ProtoCreature](../ru.spbau.mit.belyaev.map/-proto-creature/index.md) | Storing proto creature. Proto creature is essentially a bunch
but incomplete characteristic of [Creature](#). |
| [ru.spbau.mit.belyaev.map.ProtoItem](../ru.spbau.mit.belyaev.map/-proto-item/index.md) | Storing proto item. Proto item is essentially a bunch
but incomplete characteristic of [Item](#). |
| [ru.spbau.mit.belyaev.map.ProtoWorld](../ru.spbau.mit.belyaev.map/-proto-world/index.md) | Storing proto world. Proto world is essentially a bunch
but incomplete characteristic of [World](#). |
| [ru.spbau.mit.belyaev.world.Race](../ru.spbau.mit.belyaev.world/-race/index.md) | Race of [Creature](../ru.spbau.mit.belyaev.world/-creature/index.md). |
| [ru.spbau.mit.belyaev.strategy.RandomMoveStrategy](../ru.spbau.mit.belyaev.strategy/-random-move-strategy/index.md) | A random move strategy. |
| [ru.spbau.mit.belyaev.main.Roguelike](../ru.spbau.mit.belyaev.main/-roguelike/index.md) | Main Roguelike class using for initializing basic classes and
run the game. |
| [ru.spbau.mit.belyaev.map.SimpleMap](../ru.spbau.mit.belyaev.map/-simple-map/index.md) | Just simple [Map](../ru.spbau.mit.belyaev.map/-map/index.md) implementation with array of arrays of [CellType](../ru.spbau.mit.belyaev.map/-cell-type/index.md). |
| [ru.spbau.mit.belyaev.strategy.Strategy](../ru.spbau.mit.belyaev.strategy/-strategy/index.md) | Class using for implementing a acting strategy of creatures in game action. |
| [ru.spbau.mit.belyaev.world.Unit](../ru.spbau.mit.belyaev.world/-unit/index.md) | An abstract entity denoting all entities that have position [Pos](../ru.spbau.mit.belyaev.world/-pos/index.md). |
| [ru.spbau.mit.belyaev.world.World](../ru.spbau.mit.belyaev.world/-world/index.md) | A simple class to store world entities like creatures and items. |
