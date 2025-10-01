package org.example;

public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
        
        System.out.println(l);
        System.out.println("size="+l.size());
        System.out.println("Elemento da posicao 1:" + l.get(1));
        System.out.println("Elemento da posicao 5:" + l.get(5));
        l.remove(10);
        l.remove(50);
        System.out.println(l);
        l.add(0,0);
        l.add(l.size(),80);
        l.add(2,25);
        System.out.println(l);
        System.out.println("Removeu o " + l.removeByIndex(3));
        System.out.println(l);

        l.reverse();
        System.out.println("Lista invertida: \n"+l);

        Integer a[] = l.subList(1, 4);
        System.out.println("\nSublist 1-4: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }        
    }
}
