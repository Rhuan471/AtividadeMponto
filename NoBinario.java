import java.util.LinkedList;
import java.util.Queue;

class NoBinario {
    int valor;
    NoBinario esquerda;
    NoBinario direita;

    public NoBinario(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

public class ArvoreBinaria {
    private NoBinario raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private NoBinario inserirRecursivo(NoBinario no, int valor) {
        if (no == null) {
            return new NoBinario(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NoBinario no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.valor) {
            return true;
        }
        return valor < no.valor 
            ? buscarRecursivo(no.esquerda, valor) 
            : buscarRecursivo(no.direita, valor);
    }

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

            System.out.println();
            nivel++;
        }
    }

    public boolean estaDesbalanceada() {
        return verificarBalanceamento(raiz) == -1;
    }

    private int verificarBalanceamento(NoBinario no) {
        if (no == null) {
            return 0;
        }

        int alturaEsq = verificarBalanceamento(no.esquerda);
        if (alturaEsq == -1) {
            return -1;
        }

        int alturaDir = verificarBalanceamento(no.direita);
        if (alturaDir == -1) {
            return -1;
        }

        if (Math.abs(alturaEsq - alturaDir) > 1) {
            return -1;
        }

        return Math.max(alturaEsq, alturaDir) + 1;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        ArvoreBinaria arvore = new ArvoreBinaria();
        int[] valores = {40, 30, 60, 20, 35, 50, 70};

        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("Árvore nível por nível:");
        arvore.imprimirNiveis();

        System.out.println("\nA árvore está desbalanceada? " + arvore.estaDesbalanceada());

        // Inserindo mais elementos para desbalancear
        arvore.inserir(10);
        arvore.inserir(5);

        System.out.println("\nÁrvore após inserções adicionais:");
        arvore.imprimirNiveis();
        System.out.println("\nA árvore está desbalanceada agora? " + arvore.estaDesbalanceada());
    }
}
