[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.view](../index.md) / [View](.)

# View

`class View : `[`JFrame`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JFrame.html) [(source)](https://github.com/StasBel/sd-homework/blob/gRPC/src/main/kotlin/ru/spbau/mit/belyaev/view/View.kt#L22)

Implementing main (and the only) [JFrame](http://docs.oracle.com/javase/6/docs/api/javax/swing/JFrame.html) of messenger. Do basic setup
and provide method to add views (=[JPanel](http://docs.oracle.com/javase/6/docs/api/javax/swing/JPanel.html)'s) to view stack with push
and pop methods. The top view is always on the user screen. This can be
very useful to easily implement back buttons.

**Author**
belaevstanislav

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `View(appName: String)`<br>takes only app name |

### Functions

| Name | Summary |
|---|---|
| [popPanel](pop-panel.md) | `fun popPanel(): Unit`<br>Pop out of the stack top panel, making it disappear from user screen. |
| [pushPanel](push-panel.md) | `fun pushPanel(panel: `[`JPanel`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JPanel.html)`): Unit`<br>Push panel on top of the panel's stack, making it appearing on user screen |
