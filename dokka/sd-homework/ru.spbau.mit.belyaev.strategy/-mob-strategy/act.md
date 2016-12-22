[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.strategy](../index.md) / [MobStrategy](index.md) / [act](.)

# act

`fun act(self: `[`Creature`](../../ru.spbau.mit.belyaev.world/-creature/index.md)`, world: `[`World`](../../ru.spbau.mit.belyaev.world/-world/index.md)`, map: `[`Map`](../../ru.spbau.mit.belyaev.map/-map/index.md)`, game: `[`Game`](../../ru.spbau.mit.belyaev.game/-game/index.md)`): `[`Action`](../-action/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/Roguelike/src/main/kotlin/ru/spbau/mit/belyaev/strategy/MobStrategy.kt#L24)

Overrides [Strategy.act](../-strategy/act.md)

Doing a simple act of moving straight to first enemy.

### Parameters

`self` - an instance of [Creature](../../ru.spbau.mit.belyaev.world/-creature/index.md) to act

`world` - an instance of [World](../../ru.spbau.mit.belyaev.world/-world/index.md) to observe

`map` - an instance of [Map](../../ru.spbau.mit.belyaev.map/-map/index.md) using to work with mark

`game` - an instance of [Game](../../ru.spbau.mit.belyaev.game/-game/index.md) using to get some consts

**Return**
an instance of [Action](../-action/index.md) as a result of doing strategy

