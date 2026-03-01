package algorithms;

/**
 * A3 - Busqueda Lineal
 * Busca un valor en un arreglo y retorna su índice, o -1 si no existe.
 * Big-O: O(n) en ambas versiones
 */
public class BusquedaLineal {

    // --- ITERATIVO ---
    public static int iterativo(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) return i;
        }
        return -1;
    }

    // --- RECURSIVO ---
    public static int recursivo(int[] arreglo, int objetivo, int indice) {
        if (indice >= arreglo.length) return -1;
        if (arreglo[indice] == objetivo) return indice;
        return recursivo(arreglo, objetivo, indice + 1);
    }

    // Sobrecarga para llamada limpia desde Main
    public static int recursivo(int[] arreglo, int objetivo) {
        return recursivo(arreglo, objetivo, 0);
    }
}