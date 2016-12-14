[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [ChatSocket](.)

# ChatSocket

`interface ChatSocket : Any` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/Writer.kt#L10)

**Author**

belaevstanislav



Providing an interface to communicate over tcp using [Proto.Message](../../ru.spbau.mit.belyaev.textMessage/-proto/-textMessage/index.md).

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `abstract fun close(): Unit`<br>Attempting to close a connection. |
| [getMessage](get-textMessage.md) | `abstract fun getMessage(): `[`Message`](../../ru.spbau.mit.belyaev.textMessage/-proto/-textMessage/index.md)<br>Waiting for a textMessage to drawGet and then parse it from streamObserver. |
| [isOpen](is-open.md) | `abstract fun isOpen(): Boolean`<br>Check if connection is still open. |
| [sendMessage](send-textMessage.md) | `abstract fun sendMessage(textMessage: `[`Message`](../../ru.spbau.mit.belyaev.textMessage/-proto/-textMessage/index.md)`): Unit`<br>Send a textMessage. |

### Inheritors

| Name | Summary |
|---|---|
| [ChatSocketImpl](../-chat-socket-impl/index.md) | `class ChatSocketImpl : ChatSocket` |
