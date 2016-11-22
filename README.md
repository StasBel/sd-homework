# grep

## Kotlin cli args parsers analysis

1. [Klap](https://github.com/sargunster/klap) Пока еще далеко от релиза, да и документации нету вообще никакой.
2. [karg](https://github.com/jshmrsn/karg) Слишком тяжеловесное и неудобное выставление флагов, аналоги гораздо короче.
3. [kotlin-cli](https://github.com/leprosus/kotlin-cli) Быстро, удобно, понятно. Но парсит только флаги, а аргументы после вообще никак не достать.
4. Не хотелось использовать java-аналоги, хотя они и доступны из Kotlin'a из-за java inter-op. Но пришлось.
5. [commons-cli](https://mvnrepository.com/artifact/commons-cli/commons-cli/1.3.1) Из плюсов можно отметить простоту использования и функционал, более чем достаточный для задания с тремя флагами. Из минусов - некоторую тяжеловесность (по крайней мере - для данного задания).