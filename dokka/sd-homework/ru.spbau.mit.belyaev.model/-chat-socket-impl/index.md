[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [ChatSocketImpl](.)

# ChatSocketImpl

`class ChatSocketImpl : `[`ChatSocket`](../-chat-socket/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/WriterImpl.kt#L19)

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
| [getMessage](get-textMessage.md) | `fun getMessage(): `[`Message`](../../ru.spbau.mit.belyaev.textMessage/-proto/-textMessage/index.md) |
| [isOpen](is-open.md) | `fun isOpen(): Boolean` |
| [sendMessage](send-textMessage.md) | `fun sendMessage(textMessage: `[`Message`](../../ru.spbau.mit.belyaev.textMessage/-proto/-textMessage/index.md)`): Unit` |
