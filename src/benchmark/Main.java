package benchmark;

import algorithms.BusquedaLineal;
import algorithms.Factorial;
import algorithms.Fibonacci;
import algorithms.OrdenamientoBurbuja;
import utils.GeneradorDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Punto de entrada: ejecuta todas las pruebas de benchmark,
 * muestra resultados agrupados en consola y exporta a CSV.
 *
 * IMPORTANTE: Ejecutar siempre desde la RAIZ del proyecto:
 *   javac -d bin src/algorithms/*.java src/utils/*.java src/benchmark/*.java
 *   java -cp bin benchmark.Main
 */
public class Main {

    private static final int[] N_PEQUENOS = {5, 10, 15, 20, 25, 30};
    private static final int[] N_GRANDES  = {100, 500, 1000, 5000, 10000};
    private static final String RUTA_CSV  = "resultados/tiempos.csv";

    public static void main(String[] args) {
        printHeader();
        new File("resultados").mkdirs();

        try (PrintWriter csv = new PrintWriter(new FileWriter(RUTA_CSV))) {
            csv.println("Algoritmo,Version,n,Ej.1(ms),Ej.2(ms),Ej.3(ms),Ej.4(ms),Ej.5(ms),Promedio(ms)");

            medirFactorial(csv);
            medirFibonacci(csv);
            medirBusquedaLineal(csv);
            medirBurbuja(csv);

        } catch (IOException e) {
            System.err.println("Error al escribir CSV: " + e.getMessage());
        }

        System.out.println("\n✔ Resultados exportados a: " + RUTA_CSV);
    }

    // ── Helpers de impresion ───────────────────────────────────────

    private static void printHeader() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Benchmark - Estructura de Datos                              ║");
        System.out.println("║         Henry Alonzo | Universidad Da Vinci de Guatemala             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    private static void printTablaHeader() {
        System.out.printf("  %-8s", "n");
        for (int i = 1; i <= Medidor.REPETICIONES; i++) {
            System.out.printf("  %-12s", "Ej." + i + "(ms)");
        }
        System.out.printf("  %-12s%n", "Promedio(ms)");
        System.out.println("  " + "─".repeat(96));
    }

    private static void printFila(int n, double[] tiempos) {
        double prom = Medidor.promedio(tiempos);
        System.out.printf("  %-8d", n);
        for (double t : tiempos) System.out.printf("  %-12.6f", t);
        System.out.printf("  %-12.6f%n", prom);
    }

    private static void writeCsv(PrintWriter csv, String algoritmo, String version, int n, double[] tiempos) {
        double prom = Medidor.promedio(tiempos);
        csv.printf("%s,%s,%d,%.6f,%.6f,%.6f,%.6f,%.6f,%.6f%n",
                algoritmo, version, n,
                tiempos[0], tiempos[1], tiempos[2], tiempos[3], tiempos[4], prom);
    }

    // ── A1: Factorial ──────────────────────────────────────────────
    private static void medirFactorial(PrintWriter csv) {
        System.out.println("\n╔═ A1 - Factorial ════════════════════════════════════════════════════╗");

        System.out.println("  --- ITERATIVO ---");
        printTablaHeader();
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double[] t = Medidor.medir(() -> Factorial.iterativo(fn));
            printFila(n, t);
            writeCsv(csv, "A1 - Factorial", "Iterativo", n, t);
        }

        System.out.println("\n  --- RECURSIVO ---");
        printTablaHeader();
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double[] t = Medidor.medir(() -> Factorial.recursivo(fn));
            printFila(n, t);
            writeCsv(csv, "A1 - Factorial", "Recursivo", n, t);
        }
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }

    // ── A2: Fibonacci ──────────────────────────────────────────────
    private static void medirFibonacci(PrintWriter csv) {
        System.out.println("\n╔═ A2 - Fibonacci ════════════════════════════════════════════════════╗");

        System.out.println("  --- ITERATIVO ---");
        printTablaHeader();
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double[] t = Medidor.medir(() -> Fibonacci.iterativo(fn));
            printFila(n, t);
            writeCsv(csv, "A2 - Fibonacci", "Iterativo", n, t);
        }

        System.out.println("\n  --- RECURSIVO ---");
        printTablaHeader();
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double[] t = Medidor.medir(() -> Fibonacci.recursivo(fn));
            printFila(n, t);
            writeCsv(csv, "A2 - Fibonacci", "Recursivo", n, t);
        }
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }

    // ── A3: Busqueda Lineal ────────────────────────────────────────
    private static void medirBusquedaLineal(PrintWriter csv) {
        System.out.println("\n╔═ A3 - Busqueda Lineal ══════════════════════════════════════════════╗");
        int objetivo = GeneradorDatos.valorNoExistente();

        System.out.println("  --- ITERATIVO ---");
        printTablaHeader();
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double[] t = Medidor.medir(() -> BusquedaLineal.iterativo(arreglo, objetivo));
            printFila(n, t);
            writeCsv(csv, "A3 - Busqueda Lineal", "Iterativo", n, t);
        }

        System.out.println("\n  --- RECURSIVO ---");
        printTablaHeader();
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double[] t = Medidor.medir(() -> BusquedaLineal.recursivo(arreglo, objetivo));
            printFila(n, t);
            writeCsv(csv, "A3 - Busqueda Lineal", "Recursivo", n, t);
        }
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }

    // ── A4: Burbuja ────────────────────────────────────────────────
    private static void medirBurbuja(PrintWriter csv) {
        System.out.println("\n╔═ A4 - Ordenamiento Burbuja ═════════════════════════════════════════╗");

        System.out.println("  --- ITERATIVO ---");
        printTablaHeader();
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double[] t = Medidor.medir(() -> OrdenamientoBurbuja.iterativo(arreglo));
            printFila(n, t);
            writeCsv(csv, "A4 - Burbuja", "Iterativo", n, t);
        }

        System.out.println("\n  --- RECURSIVO ---");
        printTablaHeader();
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double[] t = Medidor.medir(() -> OrdenamientoBurbuja.recursivo(arreglo));
            printFila(n, t);
            writeCsv(csv, "A4 - Burbuja", "Recursivo", n, t);
        }
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }
}