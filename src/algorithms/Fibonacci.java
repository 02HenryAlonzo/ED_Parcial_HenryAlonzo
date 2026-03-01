package algorithms;

/**
 * A2 - Serie de Fibonacci
 * Calcula el n-esimo termino de forma iterativa y recursiva.
 * Limite recursivo: n <= 30 (O(2^n) crece exponencialmente)
 * Big-O: Iterativo O(n) | Recursivo O(2^n)
 */
public class Fibonacci {

    // --- ITERATIVO ---
    public static long iterativo(int n) {
        if (n <= 1) return n;
        long anterior = 0, actual = 1;
        for (int i = 2; i <= n; i++) {
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        return actual;
    }

    // --- RECURSIVO ---
    // Sin memoizacion: cada llamada genera dos llamadas nuevas → arbol exponencial
    public static long recursivo(int n) {
        if (n <= 1) return n;
        return recursivo(n - 1) + recursivo(n - 2);
    }
}