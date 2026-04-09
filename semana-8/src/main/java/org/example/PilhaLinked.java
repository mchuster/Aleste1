package org.example;

import java.util.EmptyStackException;

public class PilhaLinked {

    private class Node {
        public Integer element;
        public Node next;
        Node(Integer e) {
            element = e;
            next = null;
        }
    }

    // Atributos
    private Node topo;
    private int count;

    // Metodos

    public PilhaLinked() {
        topo = null;
        count = 0;
    }

    // Insere o elemento no topo da pilha
    public void push(Integer element) {
        Node n = new Node(element);

        if(count > 0) {
            n.next = topo;
        }
        topo = n;
        count++;
    }

    // Remove e retorna o elemento do topo da pilha (erro se a pilha estiver vazia)
    public Integer pop () {
        if (count == 0) { // se a pilha estiver vazia
            throw new EmptyStackException();
        }
        Integer e = topo.element; // guarda o elemento do topo
        topo = topo.next; // aponta para o proximo
        count--; // atualiza o count
        return e; // retorna o elemento removido do topo
    }

    // Retorna, mas nao remove, o elemento do topo da pilha (erro se a pilha estiver vazia)
    public Integer top() {
        if (count == 0) { // se a pilha estiver vazia
            throw new EmptyStackException();
        }
        return topo.element;
    }

    // Retorna o numero de elementos da pilha
    public int size() {
        return count;
    }

    // Retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return (count == 0);
    }

    // Esvazia a pilha
    public void clear() {
        topo = null;
        count = 0;
    }
}