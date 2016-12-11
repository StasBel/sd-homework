[sd-homework](../../index.md) / [ru.spbau.mit.belyaev.view](../index.md) / [VerticalFlowLayout](.)

# VerticalFlowLayout

`open class VerticalFlowLayout : `[`FlowLayout`](http://docs.oracle.com/javase/6/docs/api/java/awt/FlowLayout.html) [(source)](https://github.com/StasBel/sd-homework/blob/InstantMessenger/src/main/kotlin/ru/spbau/mit/belyaev/view/VerticalFlowLayout.java#L12)

**Author**
somebody from the Internet Implementation of new layout manager for javax swing acting like a normal FlowLayout, except elements adding goes from top to bottom. Very very useful.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `VerticalFlowLayout()`<br>Construct a new VerticalFlowLayout with a middle alignment, and the fill to edge flag set.`VerticalFlowLayout(hfill: Boolean, vfill: Boolean)`<br>`VerticalFlowLayout(align: Int)`<br>Construct a new VerticalFlowLayout with a middle alignment.`VerticalFlowLayout(align: Int, hfill: Boolean, vfill: Boolean)`<br>`VerticalFlowLayout(align: Int, hgap: Int, vgap: Int, hfill: Boolean, vfill: Boolean)`<br>Construct a new VerticalFlowLayout. |

### Properties

| Name | Summary |
|---|---|
| [BOTTOM](-b-o-t-t-o-m.md) | `static val BOTTOM: Int`<br>Specify the alignment to be bottom. |
| [MIDDLE](-m-i-d-d-l-e.md) | `static val MIDDLE: Int`<br>Specify a middle alignment. |
| [TOP](-t-o-p.md) | `static val TOP: Int`<br>Specify alignment top. |

### Functions

| Name | Summary |
|---|---|
| [getHorizontalFill](get-horizontal-fill.md) | `open fun getHorizontalFill(): Boolean`<br>Returns true if the layout horizontally fills. |
| [getVerticalFill](get-vertical-fill.md) | `open fun getVerticalFill(): Boolean`<br>Returns true if the layout vertically fills. |
| [layoutContainer](layout-container.md) | `open fun layoutContainer(target: `[`Container`](http://docs.oracle.com/javase/6/docs/api/java/awt/Container.html)`): Unit`<br>Lays out the container. |
| [minimumLayoutSize](minimum-layout-size.md) | `open fun minimumLayoutSize(target: `[`Container`](http://docs.oracle.com/javase/6/docs/api/java/awt/Container.html)`): `[`Dimension`](http://docs.oracle.com/javase/6/docs/api/java/awt/Dimension.html)<br>Returns the minimum size needed to layout the target container. |
| [preferredLayoutSize](preferred-layout-size.md) | `open fun preferredLayoutSize(target: `[`Container`](http://docs.oracle.com/javase/6/docs/api/java/awt/Container.html)`): `[`Dimension`](http://docs.oracle.com/javase/6/docs/api/java/awt/Dimension.html)<br>Returns the preferred dimensions given the components in the target container. |
| [setHorizontalFill](set-horizontal-fill.md) | `open fun setHorizontalFill(hfill: Boolean): Unit`<br>Set to true to enable horizontally fill. |
| [setVerticalFill](set-vertical-fill.md) | `open fun setVerticalFill(vfill: Boolean): Unit`<br>Set true to fill vertically. |
