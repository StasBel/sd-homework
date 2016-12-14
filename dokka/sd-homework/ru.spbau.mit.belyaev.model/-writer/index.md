[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Writer](.)

# Writer

`interface Writer : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Writer.kt#L10)

Providing an interface to communicate over tcp using [Proto.Message](#).

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `abstract fun close(): Unit`<br>Attempting to close a connection. |
| [notifyTyping](notify-typing.md) | `abstract fun notifyTyping(typing: <ERROR CLASS>): Unit`<br>Send a [Proto.Typing](#). |
| [sendTextMessage](send-text-message.md) | `abstract fun sendTextMessage(textMessage: <ERROR CLASS>): Unit`<br>Send a [Proto.TextMessage](#). |
| [sendUserInfo](send-user-info.md) | `abstract fun sendUserInfo(userInfo: <ERROR CLASS>): Unit`<br>Send a [Proto.UserInfo](#). |
