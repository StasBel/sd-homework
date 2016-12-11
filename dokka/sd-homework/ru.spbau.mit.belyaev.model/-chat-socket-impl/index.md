[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [ChatSocketImpl](.)

# ChatSocketImpl

`class ChatSocketImpl : `[`ChatSocket`](../-chat-socket/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/ChatSocketImpl.kt#L19)

**Author**

belaevstanislav



Implementing the [ChatSocket](../-chat-socket/index.md) interface.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ChatSocketImpl(socket: `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`)`<br>creates a [ChatSocket](../-chat-socket/index.md) using java socket |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `fun close(): Unit` |
| [getMessage](get-message.md) | `fun getMessage(): `[`Message`](../../ru.spbau.mit.belyaev.message/-proto/-message/index.md) |
| [isOpen](is-open.md) | `fun isOpen(): Boolean` |
| [sendMessage](send-message.md) | `fun sendMessage(message: `[`Message`](../../ru.spbau.mit.belyaev.message/-proto/-message/index.md)`): Unit` |
