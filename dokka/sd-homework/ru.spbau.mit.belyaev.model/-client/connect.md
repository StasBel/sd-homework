[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Client](index.md) / [connect](.)

# connect

`abstract fun connect(chatListener: `[`ChatListener`](../-chat-listener/index.md)`): `[`Writer`](../-writer/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Client.kt#L18)

Invoke for creating a connect and getting a [Writer](../-writer/index.md) class.

### Parameters

`chatListener` - interface [ChatListener](../-chat-listener/index.md) to handle input

### Exceptions

`AcceptConnectionException` - if error occur while accepting

**Return**
[Writer](../-writer/index.md) implementation class

