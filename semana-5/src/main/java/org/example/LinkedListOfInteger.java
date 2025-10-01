package org.example;

public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }


    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;


    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Depois, conecta o novo nodo na lista
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        // No final, atualiza o atributo count
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException(); //erro
        }
        //verifica se é para retornar o ultimo elemento da lista
        if(index == count - 1){
            return tail.element;
        }
        Node aux = head;
        //faz o aux "caminhar" ate a posiçao index
        for(int i = 0; i<index; i++){
            aux = aux.next;
        }
        //retorna o elemento da posiçao index
        return aux.element;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) {
    Node aux = head;
    for(int i = 0; i < size(); i++){
        if(element.equals(aux.element)){
            return true;
        }
        aux = aux.next;
    }
        return false;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1){
            Integer temp = tail.element;
            tail.element = element;
            return temp;
        }
        Node aux = head;
        for(int i = 0; i < index; i++){
            aux = aux.next;
        }
        Integer temp = aux.element;
        aux.element = element;
        return temp;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        Node n = new Node(element);
        if(index == count){
            tail.next = n;
            tail = n;
        }else if(index == 0){
            if(count == 0){
                tail = n;
            }else{
                n.next = head;
            }
            head = n;
        }else{
            Node aux = head;
            for(int i = 0; i < index - 1; i++){
                aux = aux.next;
            }
            n.next = aux.next;
            aux.next = n;
        }
        count ++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        //verificar se a lista nao esta vazia
        if(count == 0){
            return false;
        }
        //verificar se é remoçao do primeiro elemento
        if(element.equals(head.element)){
            if(count == 1){//se tem apenas 1 elemenro na lista
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }
        //remover elemento do meio da lista
        Node ant = head; //referencia para o nodo anterior
        Node aux = head.next; //referencia para o nodo que esta sendo verificado

        for(int i = 1; i < count; i++){
            if(element.equals(aux.element)){// se achou o elemento a ser removido
                if(aux == tail){// se é remoçao do ultimo
                    tail = ant;
                    tail.next = null;
                }else{// se remoçao do meio
                    ant.next = aux.next;
                }
                count--;//atualiza o count
                return true;
            }
            ant = ant.next;
            aux = aux.next;
        }

        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
       Node aux = head;
        if(index == 0){
            if(count == 0){
                tail = null;
            }
            head = head.next;
            count--;
            return aux.element;
        }
        for(int i = 0; i < index - 1; i++){
            aux = aux.next;
        }
        Integer element = aux.next.element;
        if(tail == aux.next){
            tail = aux;
            tail.next = null;
        }else{
            aux.next = aux.next.next;
        }
        count--;
        return element;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        Node aux = head;
        int i = 0;
       while(aux != null){
           if(element.equals(aux.element)){
               return i;
           }
           i++;
           aux = aux.next;
       }
        return -1;
    }
}
