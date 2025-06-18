public class ArvoreBinaria {

    private NoBinario raiz;
    // ... (código anterior)

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
}