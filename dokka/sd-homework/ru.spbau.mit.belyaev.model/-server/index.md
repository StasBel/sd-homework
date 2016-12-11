[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Server](.)

# Server

`interface Server : Any` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/Server.kt#L8)

**Author**

belaevstanislav



Providing an interface accepting connections and create chat sockets.

### Functions

| Name | Summary |
|---|---|
| [accept](accept.md) | `abstract fun accept(): `[`ChatSocket`](../-chat-socket/index.md)<br>Accept a connection and create chat socket to handle it. |
| [close](close.md) | `abstract fun close(): Unit`<br>Attempting to stop a server. |
