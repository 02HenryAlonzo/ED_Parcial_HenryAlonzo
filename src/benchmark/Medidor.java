package benchmark;

/**
 * Utilidad para medir el tiempo de ejecucion de un algoritmo.
 * Ejecuta 5 veces y retorna cada tiempo individual en milisegundos.
 */
public class Medidor {

    public static final int REPETICIONES = 5;

    // Retorna array con los 5 tiempos individuales (ms)
    public static double[] medir(Runnable algoritmo) {
        double[] tiempos = new double[REPETICIONES];
        for (int i = 0; i < REPETICIONES; i++) {
            long inicio = System.nanoTime();
            algoritmo.run();
            long fin = System.nanoTime();
            tiempos[i] = (fin - inicio) / 1_000_000.0;
        }
        return tiempos;
    }

    public static double promedio(double[] tiempos) {
        double total = 0;
        for (double t : tiempos) total += t;
        return total / tiempos.length;
    }
}