package listajava;

public class Fila<T> {
    private Object[] elementos;
    private int tamanho;
    private int primeiro;
    private int ultimo;

    public Fila(int capacidadeInicial) {
        elementos = new Object[capacidadeInicial];
        tamanho = 0;
        primeiro = 0;
        ultimo = -1;
    }

    public void enfileirar(T elemento) {
        if (tamanho == elementos.length) {
            redimensionar(elementos.length * 2);
        }
        ultimo = (ultimo + 1) % elementos.length;
        elementos[ultimo] = elemento;
        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public T desenfileirar() {
        if (tamanho == 0) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T elementoDesenfileirado = (T) elementos[primeiro];
        primeiro = (primeiro + 1) % elementos.length;
        tamanho--;
        return elementoDesenfileirado;
    }

    private void redimensionar(int novaCapacidade) {
        Object[] novoArray = new Object[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            int index = (primeiro + i) % elementos.length;
            novoArray[i] = elementos[index];
        }
        elementos = novoArray;
        primeiro = 0;
        ultimo = tamanho - 1;
    }

    public void percorrer() {
        for (int i = 0; i < tamanho; i++) {
            int index = (primeiro + i) % elementos.length;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }
}