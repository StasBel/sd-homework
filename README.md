# Messenger

## Overall

MVC

## Model

`Model` это отдельный класс, который реализует интерфейс `createServer(port), createClinet(ip, port)`.
В результате создаются экземпляры класса `ChatSocker` 
с методами `isOpen: Boolean, sendMessage(msg), getMessage(): msg, close()`.

Передаю по `TCP`. Используется `Google Protobuf`. 
Есть кастомные `exceptions`. Полная документация.

## View

В этот модуль вынесена вся логика рисования gui.
Есть view-шки, примитивы и главный класс `View`, наследующийся от `JFrame`

## Control


## Other

Общаться ни с кем не пробовал, но вроде все должно работать.