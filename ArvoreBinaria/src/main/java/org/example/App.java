import org.example.BinaryTreeOfInteger;

/**
 * Classe App.
 * @author Isabel H. Manssour
 */

public class App {

    public static void main(String[] args) {
        BinaryTreeOfInteger b = new BinaryTreeOfInteger();
        b.addRoot(1);
        b.addLeft(2, 1);
        b.addRight(3, 1);
        b.addRight(0, 3);
        b.addLeft(4, 2);
        b.addRight(5, 2);
        b.addRight(6, 5);
        b.addRight(7, 6);
        
        System.out.println("Total de nodos da arvore: " + b.size());

        System.out.println("Elementos da arvore na ordem pre-fixada:\n" + b.positionsPre());
        System.out.println("Elementos da arvore na ordem pos-fixada:\n" + b.positionsPos());
        System.out.println("Elementos da arvore na ordem central:\n" + b.positionsCentral());
        System.out.println("Elementos da arvore em largura:\n" + b.positionsWidth());
        System.out.println("---------------------");
        b.GeraDOT();
        System.out.println("Total de folhas: " + b.countLeaves());
        System.out.println("Total de folhas: " + b.countLeavesNoRec());

        b.removeBranch(5);
        System.out.println("Total de elementos da arvore: " + b.size());
        b.GeraDOT();

        b.mirror();
        System.out.println("Arvore espelhada");
        b.GeraDOT();

        BinaryTreeOfInteger b1 = new BinaryTreeOfInteger();
        b1.addRoot(10);
        b1.addLeft(5, 10);
        b1.addRight(15,10);
        BinaryTreeOfInteger b2 = new BinaryTreeOfInteger();
        b2.addRoot(10);
        //b2.addLeft(3, 10);
        b2.addRight(15,10);
        System.out.println("b1==b2? " + b1.equals(b2));
    }
}
