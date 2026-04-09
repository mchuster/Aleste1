package org.example;

public class App {

    public static void main(String[] args) {    
        Pilha p = new Pilha();
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);
        System.out.println("Tamanho da pilha: " + p.size());

        Pilha clone = getClone(p);
        System.out.println("Tamanho da pilha clone: " + clone.size());        

        while(!p.isEmpty()) { // while (p.size()>0)
            System.out.println(p.pop());
        }

        System.out.println("Conteudo do clone: ");
        int tamPilha = clone.size();
        for(int i=0; i<tamPilha; i++) {
            System.out.println(clone.pop());
        }
        
        
        
    }    

    /**
     * Recebe uma pilha por parâmetro e deve retornar uma 
     * cópia desta pilha sendo que no final a pilha passada 
     * por parâmetro deve estar com o seu conteúdo original.
     * @param p
     * @return
     */
    public static Pilha getClone(Pilha p) {
        Pilha aux = new Pilha();
        Pilha p2 = new Pilha();
        while(!p.isEmpty()) {
            aux.push(p.pop());
        }
        while(!aux.isEmpty()) {
            Integer e = aux.pop(); // Tira da pilha auxiliar
            p.push(e);
            p2.push(e);
        }
        return p2;
    }
}
