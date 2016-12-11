[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Model](index.md) / [createClient](.)

# createClient

`fun createClient(ipAddress: String, port: Int): `[`ChatSocket`](../-chat-socket/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/model/Model.kt#L68)

Creates a [ChatSocket](../-chat-socket/index.md) to communicate.

### Parameters

`ipAddress` - ip-address in string representation

`port` - port of connection

### Exceptions

`AcceptConnectionException` - when failed to accept a connection

**Return**
[ChatSocket](../-chat-socket/index.md) to communicate

