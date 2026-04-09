package org.example;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Classe de árvore binaria de números inteiros.
 * @author Isabel H. Manssour
 */

public class BinaryTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da árvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Retorna quem é o elemento pai do elemento passado por parametro.
     * @param element
     * @return pai de element
     */
    public Integer getParent(Integer element){
        Node parent = searchNodeRef(element, root);
        return parent.element;
    }

    /**
     * Altera o elemento da raiz da arvore.
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(Integer element) {
         root.element = element;
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a árvore não estiver
     * vazia e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        if (root != null) // se a arvore nao estiver vazia
            return false;
        root = new Node(element);
        count++;
        return true;
    }

    /**
     * Insere element à esquerda de elemFather. Se nao encontrar father,
     * ou se father ja tiver um filho a esquerda, element nao e´ 
     * inserido.
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addLeft(Integer element, Integer elemFather) {
        // Primeiro procura por elemFather a partir da raiz
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null) { // Se nao achou elemFather...
            return false;  // ...retorna false
        }

        if (aux.left != null) { // Se já tem filho a esquerda...
            return false;       // ... retorna false
        }

        // Senao, insere element na arvore
        Node n = new Node(element); // cria o nodo
        n.father = aux; // faz o nodo criado apontar para o nodo pai
        aux.left = n; // faz o nodo pai a esquerda apontar para o novo filho 
        count++; // atualiza count;
        return true;
    }

    /**
     * Insere element à direita de elemFather. Se não encontrar father,
     * ou se father já tiver um filho a direita, element não e'
     * inserido.
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer elemFather) {
        // Primeiro procura por elemFather a partir da raiz
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null) { // Se nao achou elemFather...
            return false;  // ...retorna false
        }

        if (aux.right != null) { // Se ja tem filho a direita...
            return false;       // ... retorna false
        }

        // Senao, insere element na arvore
        Node n = new Node(element); // cria o nodo
        n.father = aux; // faz o nodo criado apontar para o nodo pai
        aux.right = n; // faz o nodo pai a direita apontar para o novo filho 
        count++; // atualiza count;
        return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado. Retorna null se nao encontrar element.
    private Node searchNodeRef(Integer element, Node n) {
        // Primeiro verifica se n eh null
        if (n == null)
            return null;
        
        // Visita a raiz
        if (element.equals(n.element)) { // Se achou element...
            return n; // ...retorna a referencia para o nodo que contem element
        }

        // Visita a subarvore da esq
        Node aux = searchNodeRef(element, n.left);

        // Visita a subarvore da dir
        if (aux == null) { // Se nao achou element na subarvore da esq...
            aux = searchNodeRef(element, n.right); // ...procura na subarvore da dir
        }

        return aux;
    }

    /**
     * Remove um galho da árvore a partir do elemento recebido por parametro.
     *
     * @param element raiz da subarvore a ser removida.
     */
    public void removeBranch(Integer element) {
        if (root == null) // Se a arvore estiver vazia...
            return; // retorna false porque não fez remocao
        
        if(root.element.equals(element)) { // Se element esta na raiz...
            // ... a arvore fica vazia e retorna true
            root = null;
            count = 0;
            return;
        }    

        // Senao, procura por element a partir da raiz
        Node aux = searchNodeRef(element, root);

        if (aux == null) // Se nao achou element na arvore...
            return;// ...retorna false
        
        // Se achou element, faz a remocao
        Node refPai = aux.father; // Referencia para o pai de element
        if (refPai.left == aux) // Se for um filho an esquerda
            refPai.left = null;
        else // Se for um filho a direita
            refPai.right = null;
        aux.father = null; // Opcional, filho deixa de apontar para o pai
        count = count - countNodes(aux); // Atualiza o atributo count
    }

    // Conta o numero de nodos a partir de "n"
    private int countNodes (Node n) {
        if (n == null) 
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * Conta e retorna o total de nodos folhas da árvore
     */
    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node n) {
        if (n==null)
            return 0;
        if ( (n.left == null) && (n.right == null) )
            return 1;
        return countLeaves(n.left) + countLeaves(n.right);
    }

     public int countLeavesNoRec() {
        int c = 0; // Inicializa contador
        Queue<Node> fila = new Queue<>(); // Instancia a fila
        if (root != null) { // Se a árvore não estiver vazia
            fila.enqueue(root); // Coloca a raiz na fila
            while (!fila.isEmpty()) { // Enquanto a fila não estiver vazia
                Node aux = fila.dequeue(); // Tira o nodo da fila
                if ( (aux.left == null) && (aux.right == null) ) // Verifica se é folha
			        c++; 
                // Coloca os filhos do nodo na fila (se houver)
                if (aux.left != null)
                    fila.enqueue(aux.left);
                if (aux.right != null)
                    fila.enqueue(aux.right);
            }
        }
        return c;
    }

    /**
     * Metodo que altera a árvore para que ela seja um espelho
     * dela mesma.
     */
    public void mirror() {
        mirror(root);
    }
    private void mirror(Node n) {
        if (n != null) {
            // Troca/Inverte os filhos
            Node aux = n.left; // guarda a referencia para subarvore da esq
            n.left = n.right; 
            n.right = aux;
            // Chama recursivamente o algoritmo para os filhos
            mirror(n.left);
            mirror(n.right);
        }
    }

    /**
     * Metodo que percorre a arvore e conta o total de galhos
     * que ela possui. Galho é todo nodo que possui pelo menos
     * um filho e nao eh a raiz.
     * @return total de galhos
     */
    public int countBranches() {
        return countBranchesAux(root);
    }

    private int countBranchesAux(Node n) {
        if(n == null){
            return 0;
        }
        if(n != root && (n.left != null || n.right != null)){
            return 1 + countBranchesAux(n.left) + countBranchesAux(n.right);
        }else{
            return countBranchesAux(n.left) + countBranchesAux(n.right);
        }
    }

    /**
     * Verifica se a arvore recebida por parametro eh igual a esta arvore.
     *
     * @param outra arvore a ser comparada
     * @return truse se as árvores igualarem e false caso contrario
     */
    public boolean equals(BinaryTreeOfInteger outra) {
        return equals(root, outra.root);
    }
    private boolean equals(Node n1, Node n2) {
        if(n1==null && n2==null) {
            return true;
        }
        if (n1!=null && n2!=null) {
            if (n1.element.equals(n2.element) == false) {
                return false;
            }
            return equals(n1.left, n2.left) && equals(n1.right, n2.right);
        }
        return false; // um eh nulo e o outro nao, retorna false
    }

    /**
     * Troca um elemento da árvore pelo elemento passado por parametro.
     * @param old elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return true se fez a troca, false caso contrario.
     */
    public boolean set(Integer old, Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element este armazenado num nodo externo.
     * @param element
     * @return true se element esta num nodo externo.
     */
    public boolean isExternal(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux == null) { // Se nao achou element
            throw new NoSuchElementException(); // Erro
        }
        if (aux.left == null && aux.right == null) { // Se não tem filhos...
            return true; //...retorna true
        }
        else {              // Senao...
            return false;   // ...retorna false
        }
    }

    /**
     * Retorna true se element este armazenado num nodo interno.
     * @param element
     * @return true se element esta num nodo interno.
     */
    public boolean isInternal(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */
    public boolean hasLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux != null){
            return aux.left != null;
        }else {
            return false;
        }
    }

    /**
     * Retorna true se element tem um filho a direita.
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux != null){
            return aux.right != null;
        }else {
            return false;
        }
    }

    /**
     * Retorna o filho à esquerda de element.
     * @param element
     * @return o filho a esquerda, ou null se não tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna o filho à direita de element.
     * @param element
     * @return o filho a direita, ou null se não tiver filho a direita.
     */
    public Integer getRight(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna uma lista com todos os elementos da árvore na ordem do
     * caminhamento prefixado.
     * @return lista com todos os elementos da árvore.
     */
    public LinkedList<Integer> positionsPre() {
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        // Primeiro verifica se n eh diferente de null
        if (n != null) {
            // Visita a raiz
            lista.add(n.element);
            // Visita a subarvore da esquerda
            positionsPreAux(n.left, lista);
            // Visita a subarvore da direita
            positionsPreAux(n.right, lista);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da árvore na ordem do
     * caminhamento posfixado.
     *
     * @return lista com todos os elementos da árvore.
     */
    public LinkedList<Integer> positionsPos() {
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root, lista);
        return lista;
    }

    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        if(n != null) {
            // Visita subarvore da esq
            positionsPosAux(n.left,lista);
            // Visita subarvore da dir
            positionsPosAux(n.right,lista);
            // Visita a raiz
            lista.add(n.element);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da árvore na ordem do
     * caminhamento central.
     * @return lista com todos os elementos da árvore.
     */
    public LinkedList<Integer> positionsCentral() {
        LinkedList<Integer> lista = new LinkedList<>();
        positionsCentralAux(root, lista);
        return lista;
    }

    private void positionsCentralAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            // Visita subarvore da esq
            positionsCentralAux(n.left, lista);
            // Visita a raiz
            lista.add(n.element);
            // Visita subarvore da dir
            positionsCentralAux(n.right, lista);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da árvore na ordem do
     * caminhamento em largura (por niveis).
     * @return lista com todos os elementos da árvore.
     */
    public LinkedList<Integer> positionsWidth() {
        LinkedList<Integer> lista = new LinkedList<>(); // Instancia a lista
        Queue<Node> fila = new Queue<>(); // Instancia a fila
        if (root != null) { // Se a árvore não estiver vazia
            // Coloca a raiz na fila
            fila.enqueue(root);
            while (!fila.isEmpty()) { // Enquanto a fila não estiver vazia
                // Tira o nodo da fila
                Node aux = fila.dequeue();
                // Coloca o elemento do nodo na lista
                lista.add(aux.element);
                // Coloca os filhos do nodo na fila (se houver)
                if (aux.left != null)
                    fila.enqueue(aux.left);
                if (aux.right != null)
                    fila.enqueue(aux.right);
            }
        }
        return lista;
    }

    /**
     * Retorna uma ‘String’ com todos os elementos da árvore na ordem do
     * caminhamento central.
     * @return ‘String’ com todos os elementos da árvore.
     */
    public String strPositionsCentral() {
        return strPositionsCentral(root);
    }

    private String strPositionsCentral(Node n) {
        String s = "";

        return s;
    }

    /**
     * Retorna a altura da arvore.
     * @return
     */
    public int height() {
        // Implementar
        return -1;
    }

    /**
     * Retorna qual eh o nível do nodo no qual element este armazenado.
     * @param element a ser buscado
     * @return nivel no qual element se encontra
     */
    public int level(Integer element) {
        // Implementar
        return -1;
    }

    ///////////////////////////////////////////
    // Codigos abaixo geram saida para GraphViz    

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes ‘online’ do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }

}
