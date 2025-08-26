
public class Funcoes {
    
    public int fa(int n) {
        int cont=0;

     for (int i=0; i < n; i++)
     {
        cont++;
     }
        return cont;
    }

    public int fb(int n) {
        int cont=0;
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                cont++;
            }
        }
        return cont;
    }

    public int fc(int n) {
        int cont=0;
        for (int i=0; i < n; i++){
            for (int j=i; j < 2*i; j++){
                cont++;
            }
        }

        return cont;
    }

    public int fd(int n) {
        int cont=0;
        for (int i=1; i < n; i=i+i){
            cont++;
        } 
        return cont;
    }

    public int fe(int n) {
        int cont=0;
        for (int i=1; i < n; i++)
            for (int j=1; j < n; j=j+j)
                cont++;

        return cont;
    }

    public int ff(int n) {
        int cont=0;
        for (int i=0; i < n; i++)
            for (int j=0; j < n; j++)
                for (int k=0; k < n; k++)
                    cont++;

        return cont;
    }

    public int fg(int n) {
        int cont=0;
         for (int i=0; i < n; i++)
            for (int j=i; j < i+2; j++)
                for (int k=0; k < n; k++)
                    cont++;


        return cont;
    }

    public int fh(int n) {
        int cont=0;
         for (int i=0; i < n; i++)
            for (int j=i; j < i+2; j++)
                for (int k=j; k < j+3; k++)
                    cont++;


        return cont;
    }    
    
    public int getTotalSequencias(int v) {
        return 0;
    }
}
