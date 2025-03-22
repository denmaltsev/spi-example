package ru.example.service;

import ru.example.api.SomeService;

public class SomeSpiLoadedService implements SomeService {

    public String get() {
        return "Hello from SPI service!";
    }
}
