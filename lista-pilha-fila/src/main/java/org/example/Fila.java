package org.example;

public class Fila {

    // Atributos
    private Integer fila[];
    private int count; // guarda o total de elementos da fila
    private int primeiro; // indice do primeiro elemento da fila
    private int ultimo; // indice do ultimo elemento da fila

    public Fila() {
        fila = new Integer[20];
        count=0;
        primeiro=0;
        ultimo=0;
    }

    /**
     * Metodo que insere um elemento no final da fila.
     * @param element
     */
    public void enqueue(Integer element) {
        // Primeiro, verifica se a fila esta cheia
        if (count == fila.length) {
            throw new FullQueueException();
        }
        // Insere no final
        fila[ultimo] = element;
        // Atualiza o atributo ultimo
        ultimo = (ultimo+1) % fila.length;
        // Por exemplo: fila[] eh um vetor de 5 posicoes, indice 0 a 4
        // - Se ultimo estava na posicao 2: (2+1)/5, resto eh 3
        // - Se ultimo estava na posicao 4: (4+1)/5, resto eh 0

        // Atualiza o count
        count++;
    }
    
    /**
     * Metodo que remove o elemento do inicio da fila, e retorna
     * o elemento removido. Dá erro se a fila estiver vazia
     * @return
     */
    public Integer dequeue() { 
        if(count == 0){
            throw new FullQueueException();
        }

        Integer temp = fila[primeiro];
        fila[primeiro] = null;
        primeiro = (primeiro + 1) % fila.length;
        count--;

        return temp;
    }   

    /**
     * Metodo que retorna, mas não remove, o primeiro elemento da fila.
     * Dá erro se a fila estiver vazia
     * @return
     */
    public Integer head()  {
        if(count == 0){
            throw new FullQueueException();
        }

        return fila[primeiro];
    }  

    /**
     * Esvazia a fila.
     */
    public void clear()  {
        fila = new Integer[20];
        count = 0;
        primeiro = 0;
        ultimo = 0;
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

    public void concatenate (Pilha p){
        Pilha aux = new Pilha();
        while(!p.isEmpty()){
            int element = p.pop();
            aux.push(element);
            enqueue(element);
        }

        while(!aux.isEmpty()){
            p.push(aux.pop());
        }
    }
    
}
