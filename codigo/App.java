
public class App {
    public static void main(String[] args) {
        Funcoes f  = new Funcoes();
        
        for(int n=10; n<1000; n+=50) {
            int r = f.fh(n); // Chame uma a uma as funcoes para 
                             // analisar os seus comportamentos.
            System.out.println(n+";"+r);
        }
            
    }
}

