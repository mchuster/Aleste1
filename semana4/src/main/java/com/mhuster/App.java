package com.mhuster;

public class App {
    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
    }
    public static ListArrayOfInteger intersec(ListArrayOfInteger l1, ListArrayOfInteger l2){
        ListArrayOfInteger l3 = new ListArrayOfInteger();
        //percorrer l1 e para cada elemento verificar se esta na l2, se estiver colocar na lista l3
        
        // for(int i = 0; i<l1.size(); i++){
        //    if(l2.contains(l1.get(i)))
        //       l3.add(l1.get(i));
        //}
        for(int i = 0; i < l1.size(); i++){
            Integer n1 = l1.get(i);
            for(int j = 0; j < l2.size(); j++){
                Integer n2 = l2.get(j);
                if(n1.equals(n2)){
                    l3.add(n1);
                }
            }
        }
        return l3;
    }
}
