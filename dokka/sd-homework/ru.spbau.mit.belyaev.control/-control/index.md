[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.control](../index.md) / [Control](.)

# Control

`class Control : Any` [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/control/Control.kt#L20)

A control file implementing main logic of Model-Control-View pattern.
Using for store common val's and var's and change controls.

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Control(view: `[`View`](../../ru.spbau.mit.belyaev.view/-view/index.md)`, model: `[`Model`](../../ru.spbau.mit.belyaev.model/-model/index.md)`)`<br>takes view and model to store |

### Properties

| Name | Summary |
|---|---|
| [model](model.md) | `val model: `[`Model`](../../ru.spbau.mit.belyaev.model/-model/index.md)<br>model to work with tcp connection |
| [myUserInfo](my-user-info.md) | `val myUserInfo: <ERROR CLASS>` |
| [name](name.md) | `var name: String` |
| [threadPool](thread-pool.md) | `val threadPool: `[`ExecutorService`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ExecutorService.html) |
| [view](view.md) | `val view: `[`View`](../../ru.spbau.mit.belyaev.view/-view/index.md)<br>view to work with gui |

### Functions

| Name | Summary |
|---|---|
| [pop](pop.md) | `fun pop(): Unit` |
| [push](push.md) | `fun push(control: `[`AbstractControl`](../-abstract-control/index.md)`<*>): Unit` |
