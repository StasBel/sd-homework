![Diagram](./resources/diagram.png)

Есть базовый абстрактный клаcс Stream, от которого наследуются CharStream, LexemeStream и CommandStream, которые используются для обертки для входной строки, разбиения на лексемы и парсинга соответственно.
Переход между стримами делается в Lexer и Parser, которые используются в Shell вместе c Context.

```kotlin
fun execute(input: String): String {
    // String -> CharStream
    val chars = wrapping(input)
    
    // CharStream -> LexemeStream
    val lexemes = lexing(chars)

    // LexemeStream -> CommandStream
    val commands = parsing(lexemes)

    // CommandStream -> String
    val result = executing(commands)

    return result
}
```
