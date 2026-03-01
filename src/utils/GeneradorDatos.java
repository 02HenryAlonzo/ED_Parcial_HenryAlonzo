package utils;

import java.util.Random;

/**
 * Genera arreglos de enteros aleatorios para las pruebas de benchmark.
 */
public class GeneradorDatos {

    private static final Random random = new Random(42); // semilla fija para reproducibilidad

    public static int[] generarArreglo(int tamano) {
        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextInt(tamano * 10);
        }
        return arreglo;
    }

    // Retorna un valor que NO está en el arreglo → fuerza recorrido completo O(n)
    public static int valorNoExistente() {
        return -999;
    }
}