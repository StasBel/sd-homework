[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.model](../index.md) / [Writer](index.md) / [notifyTyping](.)

# notifyTyping

`abstract fun notifyTyping(typing: <ERROR CLASS>): Unit` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/model/Writer.kt#L36)

Send a [Proto.Typing](#).

### Parameters

`typing` - typing to send

### Exceptions

`CommunicateException` - if error occur while data sending