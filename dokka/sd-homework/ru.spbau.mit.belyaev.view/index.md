[sd-homework](../index.md) / [ru.spbau.mit.belyaev.view](.)

## Package ru.spbau.mit.belyaev.view

### Types

| Name | Summary |
|---|---|
| [AbstractView](-abstract-view/index.md) | `abstract class AbstractView : `[`JPanel`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JPanel.html)<br>Just a synonym for JPanel with empty constructor. |
| [ChatView](-chat-view/index.md) | `class ChatView : `[`AbstractView`](-abstract-view/index.md) |
| [ClientView](-client-view/index.md) | `class ClientView : `[`AbstractView`](-abstract-view/index.md) |
| [MenuView](-menu-view/index.md) | `class MenuView : `[`AbstractView`](-abstract-view/index.md) |
| [MyButton](-my-button/index.md) | `class MyButton : `[`JButton`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JButton.html) |
| [MyLabel](-my-label/index.md) | `class MyLabel : `[`JLabel`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JLabel.html) |
| [MyTextField](-my-text-field/index.md) | `class MyTextField : `[`JTextField`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JTextField.html) |
| [ServerView](-server-view/index.md) | `class ServerView : `[`AbstractView`](-abstract-view/index.md) |
| [View](-view/index.md) | `class View : `[`JFrame`](http://docs.oracle.com/javase/6/docs/api/javax/swing/JFrame.html)<br>Implementing main (and the only) [JFrame](http://docs.oracle.com/javase/6/docs/api/javax/swing/JFrame.html) of messenger. Do basic setup
and provide method to add views (=[JPanel](http://docs.oracle.com/javase/6/docs/api/javax/swing/JPanel.html)'s) to view stack with push
and pop methods. The top view is always on the user screen. This can be
very useful to easily implement back buttons. |
| [WaitForConnectionView](-wait-for-connection-view/index.md) | `class WaitForConnectionView : `[`AbstractView`](-abstract-view/index.md) |

### Properties

| Name | Summary |
|---|---|
| [DEFAULT_BUTTON_MAX_DIM](-d-e-f-a-u-l-t_-b-u-t-t-o-n_-m-a-x_-d-i-m.md) | `val DEFAULT_BUTTON_MAX_DIM: `[`Dimension`](http://docs.oracle.com/javase/6/docs/api/java/awt/Dimension.html) |
| [DEFAULT_BUTTON_PREF_DIM](-d-e-f-a-u-l-t_-b-u-t-t-o-n_-p-r-e-f_-d-i-m.md) | `val DEFAULT_BUTTON_PREF_DIM: `[`Dimension`](http://docs.oracle.com/javase/6/docs/api/java/awt/Dimension.html) |
| [DEFAULT_TEXT_DIM](-d-e-f-a-u-l-t_-t-e-x-t_-d-i-m.md) | `val DEFAULT_TEXT_DIM: `[`Dimension`](http://docs.oracle.com/javase/6/docs/api/java/awt/Dimension.html) |
| [JTEXTFIELD_BORDER](-j-t-e-x-t-f-i-e-l-d_-b-o-r-d-e-r.md) | `val JTEXTFIELD_BORDER: `[`Border`](http://docs.oracle.com/javase/6/docs/api/javax/swing/border/Border.html) |
| [TRANSPARENT_GREEN](-t-r-a-n-s-p-a-r-e-n-t_-g-r-e-e-n.md) | `val TRANSPARENT_GREEN: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html) |
| [TRANSPARENT_RED](-t-r-a-n-s-p-a-r-e-n-t_-r-e-d.md) | `val TRANSPARENT_RED: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html) |
