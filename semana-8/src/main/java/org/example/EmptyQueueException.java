package org.example;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Fila vazia!");
    }
}
