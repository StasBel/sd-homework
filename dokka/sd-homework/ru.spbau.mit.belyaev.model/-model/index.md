[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Model](.)

# Model

`class Model : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Model.kt#L21)

A class using for create [Server](../-server/index.md) and [Client](../-client/index.md).

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Model()`<br>empty constructor |

### Functions

| Name | Summary |
|---|---|
| [createClient](create-client.md) | `fun createClient(ipAddress: String, port: Int): `[`Client`](../-client/index.md)<br>Creates a [Client](../-client/index.md) to communicate. |
| [createServer](create-server.md) | `fun createServer(port: Int): `[`Server`](../-server/index.md)<br>Creates a [Server](../-server/index.md) instance. |
