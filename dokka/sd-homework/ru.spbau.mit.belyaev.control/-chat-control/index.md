[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.control](../index.md) / [ChatControl](.)

# ChatControl

`class ChatControl : `[`AbstractControl`](../-abstract-control/index.md)`<`[`ChatView`](../../ru.spbau.mit.belyaev.view/-chat-view/index.md)`>, `[`ChatListener`](../../ru.spbau.mit.belyaev.model/-chat-listener/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/control/ChatControl.kt#L18)

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ChatControl(control: `[`Control`](../-control/index.md)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [panel](../-abstract-control/panel.md) | `val panel: T` |

### Functions

| Name | Summary |
|---|---|
| [onClose](on-close.md) | `fun onClose(): Unit`<br>Invoked on closing the connection. |
| [onError](on-error.md) | `fun onError(): Unit`<br>Invoked on getting an error. |
| [onMessage](on-message.md) | `fun onMessage(textMessage: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.TextMessage](#). |
| [onTyping](on-typing.md) | `fun onTyping(typing: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.Typing](#). |
| [onUserInfo](on-user-info.md) | `fun onUserInfo(userInfo: <ERROR CLASS>): Unit`<br>Invoked on getting [Proto.UserInfo](#). |
| [startChat](start-chat.md) | `fun startChat(writerToWrite: `[`Writer`](../../ru.spbau.mit.belyaev.model/-writer/index.md)`): Unit` |
