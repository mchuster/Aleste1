package org.example;

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("A fila esta cheia!");
    }
} 
