package ru.example.api.exception;

import org.jspecify.annotations.Nullable;

/**
 * Исключение при ошибках фабрики
 */
public class SomeServiceFactoryException extends RuntimeException {

    public SomeServiceFactoryException(String message, @Nullable Object... arg) {
        super(String.format(message, arg));
    }
}
