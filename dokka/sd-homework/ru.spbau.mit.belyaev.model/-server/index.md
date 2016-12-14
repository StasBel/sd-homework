[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Server](.)

# Server

`interface Server : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Server.kt#L9)

Providing the interface for accepting connections, creating [Writer](../-writer/index.md)'s,
also start and close.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [accept](accept.md) | `abstract fun accept(): `[`Writer`](../-writer/index.md)<br>Accept a connection and create chat socket to handle it. |
| [close](close.md) | `abstract fun close(): Unit`<br>Attempting to stop a server. |
| [start](start.md) | `abstract fun start(chatListener: `[`ChatListener`](../-chat-listener/index.md)`): Unit`<br>Start the server. |
