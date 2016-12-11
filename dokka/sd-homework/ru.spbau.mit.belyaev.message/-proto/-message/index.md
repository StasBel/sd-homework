[sd-homework](../../../index.md) / [ru.spbau.mit.belyaev.message](../../index.md) / [Proto](../index.md) / [Message](.)

# Message

`class Message : GeneratedMessage, `[`MessageOrBuilder`](../-message-or-builder/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/message/Proto.java#L55)

Protobuf type `Message`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : Builder<`[`Builder`](-builder/index.md)`>, `[`MessageOrBuilder`](../-message-or-builder/index.md)<br>Protobuf type `Message` |

### Properties

| Name | Summary |
|---|---|
| [NAME_FIELD_NUMBER](-n-a-m-e_-f-i-e-l-d_-n-u-m-b-e-r.md) | `static val NAME_FIELD_NUMBER: Int` |
| [PARSER](-p-a-r-s-e-r.md) | `static var PARSER: Parser<Message>` |
| [TEXT_FIELD_NUMBER](-t-e-x-t_-f-i-e-l-d_-n-u-m-b-e-r.md) | `static val TEXT_FIELD_NUMBER: Int` |
| [TIME_FIELD_NUMBER](-t-i-m-e_-f-i-e-l-d_-n-u-m-b-e-r.md) | `static val TIME_FIELD_NUMBER: Int` |

### Functions

| Name | Summary |
|---|---|
| [getDefaultInstance](get-default-instance.md) | `static fun getDefaultInstance(): Message` |
| [getDefaultInstanceForType](get-default-instance-for-type.md) | `fun getDefaultInstanceForType(): Message` |
| [getDescriptor](get-descriptor.md) | `static fun getDescriptor(): Descriptor` |
| [getName](get-name.md) | `fun getName(): String`<br>`required string name = 2;` |
| [getNameBytes](get-name-bytes.md) | `fun getNameBytes(): ByteString`<br>`required string name = 2;` |
| [getParserForType](get-parser-for-type.md) | `fun getParserForType(): Parser<Message>` |
| [getSerializedSize](get-serialized-size.md) | `fun getSerializedSize(): Int` |
| [getText](get-text.md) | `fun getText(): String`<br>`required string text = 3;` |
| [getTextBytes](get-text-bytes.md) | `fun getTextBytes(): ByteString`<br>`required string text = 3;` |
| [getTime](get-time.md) | `fun getTime(): Long`<br>`required int64 time = 1;` |
| [getUnknownFields](get-unknown-fields.md) | `fun getUnknownFields(): UnknownFieldSet` |
| [hasName](has-name.md) | `fun hasName(): Boolean`<br>`required string name = 2;` |
| [hasText](has-text.md) | `fun hasText(): Boolean`<br>`required string text = 3;` |
| [hasTime](has-time.md) | `fun hasTime(): Boolean`<br>`required int64 time = 1;` |
| [isInitialized](is-initialized.md) | `fun isInitialized(): Boolean` |
| [newBuilder](new-builder.md) | `static fun newBuilder(): `[`Builder`](-builder/index.md)<br>`static fun newBuilder(prototype: Message): `[`Builder`](-builder/index.md) |
| [newBuilderForType](new-builder-for-type.md) | `fun newBuilderForType(): `[`Builder`](-builder/index.md) |
| [parseDelimitedFrom](parse-delimited-from.md) | `static fun parseDelimitedFrom(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`): Message`<br>`static fun parseDelimitedFrom(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, extensionRegistry: ExtensionRegistryLite): Message` |
| [parseFrom](parse-from.md) | `static fun parseFrom(data: ByteString): Message`<br>`static fun parseFrom(data: ByteString, extensionRegistry: ExtensionRegistryLite): Message`<br>`static fun parseFrom(data: ByteArray): Message`<br>`static fun parseFrom(data: ByteArray, extensionRegistry: ExtensionRegistryLite): Message`<br>`static fun parseFrom(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`): Message`<br>`static fun parseFrom(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, extensionRegistry: ExtensionRegistryLite): Message`<br>`static fun parseFrom(input: CodedInputStream): Message`<br>`static fun parseFrom(input: CodedInputStream, extensionRegistry: ExtensionRegistryLite): Message` |
| [toBuilder](to-builder.md) | `fun toBuilder(): `[`Builder`](-builder/index.md) |
| [writeTo](write-to.md) | `fun writeTo(output: CodedOutputStream): Unit` |
