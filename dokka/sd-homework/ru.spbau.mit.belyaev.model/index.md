[sd-homework](../index.md) / [ru.spbau.mit.belyaev.model](.)

## Package ru.spbau.mit.belyaev.model

### Types

| Name | Summary |
|---|---|
| [ChatSocket](-chat-socket/index.md) | `interface ChatSocket : Any` |
| [ChatSocketImpl](-chat-socket-impl/index.md) | `class ChatSocketImpl : `[`ChatSocket`](-chat-socket/index.md) |
| [Model](-model/index.md) | `class Model : Any` |
| [Server](-server/index.md) | `interface Server : Any` |

### Exceptions

| Name | Summary |
|---|---|
| [AcceptConnectionException](-accept-connection-exception/index.md) | `class AcceptConnectionException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [ChatSocket](-chat-socket/index.md). |
| [ClosingConnectionException](-closing-connection-exception/index.md) | `class ClosingConnectionException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to close a connection in [ChatSocket](-chat-socket/index.md). |
| [ClosingServerException](-closing-server-exception/index.md) | `class ClosingServerException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to close a [Server](-server/index.md). |
| [CommunicateException](-communicate-exception/index.md) | `class CommunicateException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when bad i/o occur while processing a communication in [ChatSocket](-chat-socket/index.md). |
| [ServerCreateException](-server-create-exception/index.md) | `class ServerCreateException : `[`Exception`](http://docs.oracle.com/javase/6/docs/api/java/lang/Exception.html)<br>Exception to throw when failed to create a [Server](-server/index.md). |
