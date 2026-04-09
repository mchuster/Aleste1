package org.example;

public class FullStackException extends RuntimeException {

    public FullStackException() {
        super("A pilha esta cheia!");
    }
 
    public FullStackException(String message) {
        super(message);
    } 
    
}
