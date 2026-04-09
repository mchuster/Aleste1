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
    
}
