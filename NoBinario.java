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
}
