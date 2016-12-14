[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Client](.)

# Client

`interface Client : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Client.kt#L8)

Client interface using for do client acts.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `abstract fun close(): Unit`<br>Invoke for closing the connection. |
| [connect](connect.md) | `abstract fun connect(chatListener: `[`ChatListener`](../-chat-listener/index.md)`): `[`Writer`](../-writer/index.md)<br>Invoke for creating a connect and getting a [Writer](../-writer/index.md) class. |
