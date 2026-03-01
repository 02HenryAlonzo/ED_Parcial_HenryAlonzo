package algorithms;

/**
 * A1 - Factorial
 * Calcula n! de forma iterativa y recursiva.
 * Limite: n <= 20 (evita desbordamiento con long)
 * Big-O: O(n) en ambas versiones
 */
public class Factorial {

    // --- ITERATIVO ---
    public static long iterativo(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // --- RECURSIVO ---
    public static long recursivo(int n) {
        if (n <= 1) return 1;
        return n * recursivo(n - 1);
    }
}