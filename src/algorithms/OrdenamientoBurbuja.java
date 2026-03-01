package algorithms;

import java.util.Arrays;

/**
 * A4 - Ordenamiento Burbuja
 * Ordena un arreglo de menor a mayor.
 * Big-O: O(n^2) en ambas versiones
 */
public class OrdenamientoBurbuja {

    // --- ITERATIVO ---
    public static int[] iterativo(int[] arreglo) {
        int[] arr = Arrays.copyOf(arreglo, arreglo.length);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // --- RECURSIVO ---
    // Cada llamada "burbujea" el mayor elemento al final, luego reduce el problema en 1
    public static int[] recursivo(int[] arreglo) {
        int[] arr = Arrays.copyOf(arreglo, arreglo.length);
        burbujearRecursivo(arr, arr.length);
        return arr;
    }

    private static void burbujearRecursivo(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        burbujearRecursivo(arr, n - 1);
    }
}