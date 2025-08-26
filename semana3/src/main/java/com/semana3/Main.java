package com.semana3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int potenciaRec(int base, int expoente){
    if(expoente == 0){
        return 1;
    }
    return base * potenciaRec(base, expoente - 1);
    }

    public static void inverteVetor(int vet[]){
        inverteVetor(vet, 0, vet.length-1);
    }
    //metodo que faz a inversao do vetor de forma recursiva
    public static void inverteVetor(int vet[], int i, int f){
        if(i < f){
            //trocar os elementos de lugar
            int aux = vet[i];
            vet[i] = vet[f];
            vet[f] = aux;
            //chama o metodo recuivamente
            inverteVetor(vet, i+1, f-1);
        }
    }

    public static boolean epalindromo(String p){
        for(int i = 1; i < p.length(); i++){
            if(!epalindromo(p, i)){
                return false;
            }
        }
        
        return true;
    }
    public static boolean epalindromo(String p, int posicao){
        char p1 = p.charAt(p.length()- posicao);
        char p2 = p.charAt(posicao - 1);
        return (p1 == p2);
    }
    
}