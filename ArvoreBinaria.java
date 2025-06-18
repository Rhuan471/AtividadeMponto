import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    // ... (código anterior)

    public void imprimirNiveis() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        }

        Queue<NoBinario> fila = new LinkedList<>();
        fila.add(raiz);
        int nivel = 0;

        while (!fila.isEmpty()) {
            System.out.print("Nível " + nivel + ": ");
            int tamanhoNivel = fila.size();

            for (int i = 0; i < tamanhoNivel; i++) {
                NoBinario no = fila.poll();
                System.out.print(no.valor + " ");

                if (no.esquerda != null) {
                    fila.add(no.esquerda);
                }
                if (no.direita != null) {
                    fila.add(no.direita);
                }
            }

            System.out.println(); // Nova linha para o próximo nível
            nivel++;
        }
    }
}
