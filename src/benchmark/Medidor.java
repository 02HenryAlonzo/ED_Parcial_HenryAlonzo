package benchmark;

/**
 * Utilidad para medir el tiempo de ejecución de un algoritmo.
 * Ejecuta 5 veces y retorna el promedio en milisegundos.
 */
public class Medidor {

    private static final int REPETICIONES = 5;

    public static double medir(Runnable algoritmo) {
        double total = 0;
        for (int i = 0; i < REPETICIONES; i++) {
            long inicio = System.nanoTime();
            algoritmo.run();
            long fin = System.nanoTime();
            total += (fin - inicio) / 1_000_000.0;
        }
        return total / REPETICIONES;
    }
}