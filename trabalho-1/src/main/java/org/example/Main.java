package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Funcoes f = new Funcoes();

        for(int n = 10; n <= 200; n= n+10){
            int r = f.fe(n);
            System.out.println(n+";"+r);

        }
    }
}