package org.example;

public class FilaLinked {
    
    private class Node {
        public Integer element;
        public Node next;
        public Node(Integer e) {
            element = e;
        }
    }
    
    // Atributos
    private Node head;
    private Node tail;
    int count;
    
    /**
     * Metodo que insere um elemento no final da fila.
     * @param element
     */
    public void enqueue(Integer element) {
        // Cria o nodo 
        Node n = new Node(element);
        if(count == 0) { // se a fila estiver vazia
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
        count++;        
    }

    /**
     * Metodo que remove o elemento do inicio da fila, e retorna
     * o elemento removido. Dá erro se a fila estiver vazia
     * @return
     */
    public Integer dequeue() {
        // Primeiro, verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException();
        }
        // Guarda o elemento do inicio da fila
        Integer elem = head.element;

        // Faz a remocao
        head = head.next;
        count--;
        if (count == 0) { // se a fila ficou vazia
            tail = null;
        }

        // Retorna o elemento removido
        return elem;
    }


    /**
     * Metodo que retorna, mas não remove, o primeiro elemento da fila.
     * Dá erro se a fila estiver vazia
     * @return
     */
    public Integer head()  {
         // Primeiro verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException();
        }
        return head.element;
    }

    /**
     * Retorna o numero de elementos da fila.
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * Metodo que retorna true se a fila estiver vazia, 
     * e false caso contrário
     * @return
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Esvazia a fila.
     */
    public void clear()  {
        head = null;
        tail = null;
        count = 0;
    }     
    
}
