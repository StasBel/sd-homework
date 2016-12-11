[sd-homework](../../../../index.md) / [ru.spbau.mit.belyaev.message](../../../index.md) / [Proto](../../index.md) / [Message](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<Builder>, `[`MessageOrBuilder`](../../-message-or-builder/index.md) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/message/Proto.java#L401)

Protobuf type `Message`

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Message`](../index.md) |
| [buildPartial](build-partial.md) | `fun buildPartial(): `[`Message`](../index.md) |
| [clear](clear.md) | `fun clear(): Builder` |
| [clearName](clear-name.md) | `fun clearName(): Builder`<br>`required string name = 2;` |
| [clearText](clear-text.md) | `fun clearText(): Builder`<br>`required string text = 3;` |
| [clearTime](clear-time.md) | `fun clearTime(): Builder`<br>`required int64 time = 1;` |
| [clone](clone.md) | `fun clone(): Builder` |
| [getDefaultInstanceForType](get-default-instance-for-type.md) | `fun getDefaultInstanceForType(): `[`Message`](../index.md) |
| [getDescriptor](get-descriptor.md) | `static fun getDescriptor(): Descriptor` |
| [getDescriptorForType](get-descriptor-for-type.md) | `fun getDescriptorForType(): Descriptor` |
| [getName](get-name.md) | `fun getName(): String`<br>`required string name = 2;` |
| [getNameBytes](get-name-bytes.md) | `fun getNameBytes(): ByteString`<br>`required string name = 2;` |
| [getText](get-text.md) | `fun getText(): String`<br>`required string text = 3;` |
| [getTextBytes](get-text-bytes.md) | `fun getTextBytes(): ByteString`<br>`required string text = 3;` |
| [getTime](get-time.md) | `fun getTime(): Long`<br>`required int64 time = 1;` |
| [hasName](has-name.md) | `fun hasName(): Boolean`<br>`required string name = 2;` |
| [hasText](has-text.md) | `fun hasText(): Boolean`<br>`required string text = 3;` |
| [hasTime](has-time.md) | `fun hasTime(): Boolean`<br>`required int64 time = 1;` |
| [isInitialized](is-initialized.md) | `fun isInitialized(): Boolean` |
| [mergeFrom](merge-from.md) | `fun mergeFrom(other: Message): Builder`<br>`fun mergeFrom(other: `[`Message`](../index.md)`): Builder`<br>`fun mergeFrom(input: CodedInputStream, extensionRegistry: ExtensionRegistryLite): Builder` |
| [setName](set-name.md) | `fun setName(value: String): Builder`<br>`required string name = 2;` |
| [setNameBytes](set-name-bytes.md) | `fun setNameBytes(value: ByteString): Builder`<br>`required string name = 2;` |
| [setText](set-text.md) | `fun setText(value: String): Builder`<br>`required string text = 3;` |
| [setTextBytes](set-text-bytes.md) | `fun setTextBytes(value: ByteString): Builder`<br>`required string text = 3;` |
| [setTime](set-time.md) | `fun setTime(value: Long): Builder`<br>`required int64 time = 1;` |
