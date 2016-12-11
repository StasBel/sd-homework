[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Model](.)

# Model

`class Model : Any` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/Model.kt#L15)

**Author**

belaevstanislav



A class using for create server and client.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Model()`<br>empty constructor |

### Functions

| Name | Summary |
|---|---|
| [createClient](create-client.md) | `fun createClient(ipAddress: String, port: Int): `[`ChatSocket`](../-chat-socket/index.md)<br>Creates a [ChatSocket](../-chat-socket/index.md) to communicate. |
| [createServer](create-server.md) | `fun createServer(port: Int): `[`Server`](../-server/index.md)<br>Creates a [Server](../-server/index.md) instance. |
