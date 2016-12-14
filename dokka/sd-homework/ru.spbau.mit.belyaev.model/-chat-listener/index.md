[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [ChatListener](.)

# ChatListener

`interface ChatListener : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/ChatListener.kt#L10)

An interface using for handle chat events.

**Author**
belaevstanislav

### Functions

| Name | Summary |
|---|---|
| [onClose](on-close.md) | `abstract fun onClose(): Unit`<br>Invoked on closing the connection. |
| [onError](on-error.md) | `abstract fun onError(): Unit`<br>Invoked on getting an error. |
| [onMessage](on-message.md) | `abstract fun onMessage(textMessage: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.TextMessage](#). |
| [onTyping](on-typing.md) | `abstract fun onTyping(typing: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.Typing](#). |
| [onUserInfo](on-user-info.md) | `abstract fun onUserInfo(userInfo: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.UserInfo](#). |

### Inheritors

| Name | Summary |
|---|---|
| [ChatControl](../../ru.spbau.mit.belyaev.control/-chat-control/index.md) | `class ChatControl : `[`AbstractControl`](../../ru.spbau.mit.belyaev.control/-abstract-control/index.md)`<`[`ChatView`](../../ru.spbau.mit.belyaev.view/-chat-view/index.md)`>, ChatListener` |
