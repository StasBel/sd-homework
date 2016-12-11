[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [ChatSocket](.)

# ChatSocket

`interface ChatSocket : Any` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/ChatSocket.kt#L10)

**Author**

belaevstanislav



Providing an interface to communicate over tcp using [Proto.Message](../../ru.spbau.mit.belyaev.message/-proto/-message/index.md).

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `abstract fun close(): Unit`<br>Attempting to close a connection. |
| [getMessage](get-message.md) | `abstract fun getMessage(): `[`Message`](../../ru.spbau.mit.belyaev.message/-proto/-message/index.md)<br>Waiting for a message to drawGet and then parse it from stream. |
| [isOpen](is-open.md) | `abstract fun isOpen(): Boolean`<br>Check if connection is still open. |
| [sendMessage](send-message.md) | `abstract fun sendMessage(message: `[`Message`](../../ru.spbau.mit.belyaev.message/-proto/-message/index.md)`): Unit`<br>Send a message. |

### Inheritors

| Name | Summary |
|---|---|
| [ChatSocketImpl](../-chat-socket-impl/index.md) | `class ChatSocketImpl : ChatSocket` |
