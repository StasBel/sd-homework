[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.control](../index.md) / [AbstractControl](.)

# AbstractControl

`abstract class AbstractControl<out T : `[`AbstractView`](../../ru.spbau.mit.belyaev.view/-abstract-view/index.md)`> : Any` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/control/AbstractControl.kt#L16)

**Author**

belaevstanislav



Base class for all controls classes with bind to a
particular view class using genetics constraint.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractControl(t: T)`<br>takes only one instance of class, derived from [AbstractView](../../ru.spbau.mit.belyaev.view/-abstract-view/index.md)
(which) implementing JPanel class. |

### Properties

| Name | Summary |
|---|---|
| [panel](panel.md) | `val panel: T` |

### Inheritors

| Name | Summary |
|---|---|
| [ChatControl](../-chat-control/index.md) | `class ChatControl : AbstractControl<`[`ChatView`](../../ru.spbau.mit.belyaev.view/-chat-view/index.md)`>` |
| [ClientControl](../-client-control/index.md) | `class ClientControl : AbstractControl<`[`ClientView`](../../ru.spbau.mit.belyaev.view/-client-view/index.md)`>` |
| [MenuControl](../-menu-control/index.md) | `class MenuControl : AbstractControl<`[`MenuView`](../../ru.spbau.mit.belyaev.view/-menu-view/index.md)`>` |
| [ServerControl](../-server-control/index.md) | `class ServerControl : AbstractControl<`[`ServerView`](../../ru.spbau.mit.belyaev.view/-server-view/index.md)`>` |
| [WaitForConnectionControl](../-wait-for-connection-control/index.md) | `class WaitForConnectionControl : AbstractControl<`[`WaitForConnectionView`](../../ru.spbau.mit.belyaev.view/-wait-for-connection-view/index.md)`>` |
