package org.example;

import java.util.EmptyStackException;

public class Pilha {
    // Atributos
    private Integer array[];
    private int count;

    public Pilha() {
        array = new Integer[20];
        count =0;
    }

    /**
     * Insere o elemento no topo da pilha
     * @param element
     */
    public void push(Integer element) {
        if (count == array.length) {
            throw new FullStackException();
        }
        array[count] = element;
        count++;
    }

    /**
     * Remove e retorna o elemento do topo da pilha
     * (erro se a pilha estiver vazia)
     * @return
     */
    public Integer pop() {
        // Primeiro verifica se a pilha esta vazia
        if (count == 0) {
            throw new EmptyStackException();
        }
        Integer e = array[count-1];
        array[count-1] = null;
        count--;
        return e;
    }

    /**
     * Retorna o numero de elementos da pilha
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * Retorna, mas nao remove, o elemento do 
     * topo da pilha (erro se a pilha estiver vazia)
     * @return
     */
    public Integer top() {
        // Primeiro verifica se a pilha esta vazia
        if (count == 0) {
            throw new EmptyStackException();
        }
        return array[count-1];
    }

    /**
     * Esvazia a pilha
     */
    public void clear() {
        array = new Integer[20];
        count =0;        
    }

    /**
     * Retorna true se a pilha estiver vazia, 
     * e false caso contrário
     * @return
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    public Pilha toNegative (Pilha s){
        Pilha aux = new Pilha();
        Pilha s2 = new Pilha();
        while (s.size() != 0){
            int element = s.pop();
            if(element > 0){
                aux.push(-(element));
            }else{
                aux.push(element);
            }
        }
        while(!aux.isEmpty()) {
            s2.push(aux.pop());
        }
        return s2;
    }
}