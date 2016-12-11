[sd-homework](../../../index.md) / [ru.spbau.mit.belyaev.message](../../index.md) / [Proto](../index.md) / [MessageOrBuilder](.)

# MessageOrBuilder

`interface MessageOrBuilder : MessageOrBuilder` [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/message/Proto.java#L11)

### Functions

| Name | Summary |
|---|---|
| [getName](get-name.md) | `abstract fun getName(): String`<br>`required string name = 2;` |
| [getNameBytes](get-name-bytes.md) | `abstract fun getNameBytes(): ByteString`<br>`required string name = 2;` |
| [getText](get-text.md) | `abstract fun getText(): String`<br>`required string text = 3;` |
| [getTextBytes](get-text-bytes.md) | `abstract fun getTextBytes(): ByteString`<br>`required string text = 3;` |
| [getTime](get-time.md) | `abstract fun getTime(): Long`<br>`required int64 time = 1;` |
| [hasName](has-name.md) | `abstract fun hasName(): Boolean`<br>`required string name = 2;` |
| [hasText](has-text.md) | `abstract fun hasText(): Boolean`<br>`required string text = 3;` |
| [hasTime](has-time.md) | `abstract fun hasTime(): Boolean`<br>`required int64 time = 1;` |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../-message/-builder/index.md) | `class Builder : Builder<`[`Builder`](../-message/-builder/index.md)`>, MessageOrBuilder`<br>Protobuf type `Message` |
| [Message](../-message/index.md) | `class Message : GeneratedMessage, MessageOrBuilder`<br>Protobuf type `Message` |
