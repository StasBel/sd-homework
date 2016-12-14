[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Model](index.md) / [createClient](.)

# createClient

`fun createClient(ipAddress: String, port: Int): `[`Client`](../-client/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Model.kt#L95)

Creates a [Client](../-client/index.md) to communicate.

### Parameters

`ipAddress` - ip-address in string representation

`port` - port of connection

### Exceptions

`ClientCreateException` - when failed to accept a connection

**Return**
[Client](../-client/index.md) instance of

