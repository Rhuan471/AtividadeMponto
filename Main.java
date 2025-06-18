public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arv = new ArvoreBinaria();
        int[] valores = {40, 30, 60, 20, 35, 50, 70};
        for (int v : valores) {
            arv.inserir(v);
        }

        arv.imprimirNiveis();
        System.out.println("Árvore desbalanceada? " + arv.estaDesbalanceada());

        // Inserir para desbalancear
        arv.inserir(10);
        arv.inserir(5);
        arv.imprimirNiveis();
        System.out.println("Árvore desbalanceada? " + arv.estaDesbalanceada());
    }
}
