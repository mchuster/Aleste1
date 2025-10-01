package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    LinkedListOfInteger lista = new LinkedListOfInteger();

    lista.add(0);
    lista.add(2);
    lista.add(4);
    lista.add(6);
    lista.add(8);
    lista.add(10);
    lista.add(12);

    System.out.println(lista);

    System.out.println("Elemento da posicao 2: " + lista.get(2));

    System.out.println("lista contem 8? " + lista.contains(8));
    System.out.println("lista contem 45? " + lista.contains(45));

    lista.remove(6);
    lista.remove(2);
    lista.remove(12);
    System.out.println(lista);
    }

}
