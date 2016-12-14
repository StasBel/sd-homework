[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Server](index.md) / [accept](.)

# accept

`abstract fun accept(): `[`Writer`](../-writer/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Server.kt#L26)

Accept a connection and create chat socket to handle it.

### Exceptions

`AcceptConnectionException` - if error occur while accepting connection

**Return**
class implementing [Writer](../-writer/index.md) interface

