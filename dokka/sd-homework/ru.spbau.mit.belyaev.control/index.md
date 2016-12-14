[sd-homework](../index.md) / [ru.spbau.mit.belyaev.control](.)

## Package ru.spbau.mit.belyaev.control

### Types

| Name | Summary |
|---|---|
| [AbstractControl](-abstract-control/index.md) | `abstract class AbstractControl<out T : `[`AbstractView`](../ru.spbau.mit.belyaev.view/-abstract-view/index.md)`> : Any`<br>Base class for all controls classes with bind to a
particular view class using genetics constraint. |
| [ChatControl](-chat-control/index.md) | `class ChatControl : `[`AbstractControl`](-abstract-control/index.md)`<`[`ChatView`](../ru.spbau.mit.belyaev.view/-chat-view/index.md)`>, `[`ChatListener`](../ru.spbau.mit.belyaev.model/-chat-listener/index.md) |
| [ClientControl](-client-control/index.md) | `class ClientControl : `[`AbstractControl`](-abstract-control/index.md)`<`[`ClientView`](../ru.spbau.mit.belyaev.view/-client-view/index.md)`>` |
| [Control](-control/index.md) | `class Control : Any`<br>A control file implementing main logic of Model-Control-View pattern.
Using for store common val's and var's and change controls. |
| [MenuControl](-menu-control/index.md) | `class MenuControl : `[`AbstractControl`](-abstract-control/index.md)`<`[`MenuView`](../ru.spbau.mit.belyaev.view/-menu-view/index.md)`>` |
| [ServerControl](-server-control/index.md) | `class ServerControl : `[`AbstractControl`](-abstract-control/index.md)`<`[`ServerView`](../ru.spbau.mit.belyaev.view/-server-view/index.md)`>` |
| [WaitForConnectionControl](-wait-for-connection-control/index.md) | `class WaitForConnectionControl : `[`AbstractControl`](-abstract-control/index.md)`<`[`WaitForConnectionView`](../ru.spbau.mit.belyaev.view/-wait-for-connection-view/index.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [DEFAULT_IP_ADDRESS](-d-e-f-a-u-l-t_-i-p_-a-d-d-r-e-s-s.md) | `val DEFAULT_IP_ADDRESS: String`<br>The default ip address. |
| [DEFAULT_NICKNAME](-d-e-f-a-u-l-t_-n-i-c-k-n-a-m-e.md) | `val DEFAULT_NICKNAME: String`<br>The default user nickname. |
| [DEFAULT_PORT](-d-e-f-a-u-l-t_-p-o-r-t.md) | `val DEFAULT_PORT: Int`<br>The default port number. |
