package org.example;

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("Fila cheia!");
    }
} 
