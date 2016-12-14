[sd-homework](../index.md) / [ru.spbau.mit.belyaev.model](.)

## Package ru.spbau.mit.belyaev.model

### Types

| Name | Summary |
|---|---|
| [ChatListener](-chat-listener/index.md) | `interface ChatListener : Any`<br>An interface using for handle chat events. |
| [Client](-client/index.md) | `interface Client : Any`<br>Client interface using for do client acts. |
| [Model](-model/index.md) | `class Model : Any`<br>A class using for create [Server](-server/index.md) and [Client](-client/index.md). |
| [Server](-server/index.md) | `interface Server : Any`<br>Providing the interface for accepting connections, creating [Writer](-writer/index.md)'s,
also start and close. |
| [Writer](-writer/index.md) | `interface Writer : Any`<br>Providing an interface to communicate over tcp using [Proto.Message](#). |

### Exceptions

| Name | Summary |
|---|---|
| [AcceptConnectionException](-accept-connection-exception/index.md) | `class AcceptConnectionException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [Writer](-writer/index.md). |
| [ClientCloseException](-client-close-exception/index.md) | `class ClientCloseException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to close a [Client](-client/index.md). |
| [ClientCreateException](-client-create-exception/index.md) | `class ClientCreateException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [Client](-client/index.md). |
| [ClosingConnectionException](-closing-connection-exception/index.md) | `class ClosingConnectionException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to close a connection in [Writer](-writer/index.md). |
| [CommunicateException](-communicate-exception/index.md) | `class CommunicateException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when bad i/o occur while processing a communication in [Writer](-writer/index.md). |
| [ServerCloseException](-server-close-exception/index.md) | `class ServerCloseException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to close a [Server](-server/index.md). |
| [ServerCreateException](-server-create-exception/index.md) | `class ServerCreateException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [Server](-server/index.md). |
| [ServerStartException](-server-start-exception/index.md) | `class ServerStartException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [Server](-server/index.md). |
