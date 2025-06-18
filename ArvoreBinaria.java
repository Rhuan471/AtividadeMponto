import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private NoBinario raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int chave) {
        if (raiz == null) {
            raiz = new NoBinario(chave);
        } else {
            inserirRec(raiz, chave);
        }
    }

    private void inserirRec(NoBinario no, int chave) {
        if (chave < no.chave) {
            if (no.esquerda == null) {
                no.esquerda = new NoBinario(chave);
            } else {
                inserirRec(no.esquerda, chave);
            }
        } else {
            if (no.direita == null) {
                no.direita = new NoBinario(chave);
            } else {
                inserirRec(no.direita, chave);
            }
        }
    }

    public void imprimirNiveis() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        }

        Queue<NoBinario> fila = new LinkedList<>();
        Queue<Integer> niveis = new LinkedList<>();
        fila.add(raiz);
        niveis.add(0);

        int nivelAtual = 0;
        StringBuilder sb = new StringBuilder();
        
        while (!fila.isEmpty()) {
            NoBinario no = fila.poll();
            int nivel = niveis.poll();

            if (nivel != nivelAtual) {
                System.out.println("Nível " + nivelAtual + ": " + sb.toString().trim());
                sb = new StringBuilder();
                nivelAtual = nivel;
            }

            sb.append(no.chave).append(" ");

            if (no.esquerda != null) {
                fila.add(no.esquerda);
                niveis.add(nivel + 1);
            }
            if (no.direita != null) {
                fila.add(no.direita);
                niveis.add(nivel + 1);
            }
        }

        // Imprime o último nível
        System.out.println("Nível " + nivelAtual + ": " + sb.toString().trim());
    }

    public boolean estaDesbalanceada() {
        return altura(raiz) == -1;
    }

    private int altura(NoBinario no) {
        if (no == null)
            return 0;

        int alturaEsq = altura(no.esquerda);
        if (alturaEsq == -1)
            return -1;

        int alturaDir = altura(no.direita);
        if (alturaDir == -1)
            return -1;

        if (Math.abs(alturaEsq - alturaDir) > 1)
            return -1;

        return Math.max(alturaEsq, alturaDir) + 1;
    }
}
