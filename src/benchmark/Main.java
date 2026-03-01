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
 * Punto de entrada: ejecuta todas las pruebas de benchmark
 * y exporta los resultados a resultados/tiempos.csv
 *
 * IMPORTANTE: Ejecutar siempre desde la RAIZ del proyecto:
 *   javac -d bin src/algorithms/*.java src/utils/*.java src/benchmark/*.java
 *   java -cp bin benchmark.Main
 */
public class Main {

    // Tamaños para Factorial y Fibonacci
    private static final int[] N_PEQUENOS = {5, 10, 15, 20, 25, 30};

    // Tamaños para Busqueda Lineal y Burbuja
    private static final int[] N_GRANDES = {100, 500, 1000, 5000, 10000};

    // Ruta del CSV relativa a la raiz del proyecto
    private static final String RUTA_CSV = "resultados/tiempos.csv";

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Benchmark - Estructura de Datos        ║");
        System.out.println("║   Henry Alonzo | Universidad Da Vinci    ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();
        System.out.printf("%-25s %-12s %-10s %s%n", "Algoritmo", "Version", "n", "Tiempo (ms)");
        System.out.println("─".repeat(65));

        // Crea la carpeta resultados si no existe
        new File("resultados").mkdirs();

        try (PrintWriter csv = new PrintWriter(new FileWriter(RUTA_CSV))) {
            csv.println("Algoritmo,Version,n,Tiempo_ms");

            medirFactorial(csv);
            medirFibonacci(csv);
            medirBusquedaLineal(csv);
            medirBurbuja(csv);

        } catch (IOException e) {
            System.err.println("Error al escribir CSV: " + e.getMessage());
        }

        System.out.println("─".repeat(65));
        System.out.println();
        System.out.println("✔ Resultados exportados a: " + RUTA_CSV);
    }

    private static void imprimir(String algoritmo, String version, int n, double tiempo) {
        System.out.printf("%-25s %-12s %-10d %.6f ms%n", algoritmo, version, n, tiempo);
    }

    // ── A1: Factorial ──────────────────────────────────────────────
    private static void medirFactorial(PrintWriter csv) {
        System.out.println("\n[ A1 - Factorial ]");
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double tIter = Medidor.medir(() -> Factorial.iterativo(fn));
            double tRec  = Medidor.medir(() -> Factorial.recursivo(fn));
            imprimir("A1 - Factorial", "Iterativo", n, tIter);
            imprimir("A1 - Factorial", "Recursivo", n, tRec);
            csv.printf("A1 - Factorial,Iterativo,%d,%.6f%n", n, tIter);
            csv.printf("A1 - Factorial,Recursivo,%d,%.6f%n", n, tRec);
        }
    }

    // ── A2: Fibonacci ──────────────────────────────────────────────
    private static void medirFibonacci(PrintWriter csv) {
        System.out.println("\n[ A2 - Fibonacci ]");
        for (int n : N_PEQUENOS) {
            final int fn = n;
            double tIter = Medidor.medir(() -> Fibonacci.iterativo(fn));
            double tRec  = Medidor.medir(() -> Fibonacci.recursivo(fn));
            imprimir("A2 - Fibonacci", "Iterativo", n, tIter);
            imprimir("A2 - Fibonacci", "Recursivo", n, tRec);
            csv.printf("A2 - Fibonacci,Iterativo,%d,%.6f%n", n, tIter);
            csv.printf("A2 - Fibonacci,Recursivo,%d,%.6f%n", n, tRec);
        }
    }

    // ── A3: Busqueda Lineal ────────────────────────────────────────
    private static void medirBusquedaLineal(PrintWriter csv) {
        System.out.println("\n[ A3 - Busqueda Lineal ]");
        int objetivo = GeneradorDatos.valorNoExistente();
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double tIter = Medidor.medir(() -> BusquedaLineal.iterativo(arreglo, objetivo));
            double tRec  = Medidor.medir(() -> BusquedaLineal.recursivo(arreglo, objetivo));
            imprimir("A3 - Busqueda Lineal", "Iterativo", n, tIter);
            imprimir("A3 - Busqueda Lineal", "Recursivo", n, tRec);
            csv.printf("A3 - Busqueda Lineal,Iterativo,%d,%.6f%n", n, tIter);
            csv.printf("A3 - Busqueda Lineal,Recursivo,%d,%.6f%n", n, tRec);
        }
    }

    // ── A4: Burbuja ────────────────────────────────────────────────
    private static void medirBurbuja(PrintWriter csv) {
        System.out.println("\n[ A4 - Ordenamiento Burbuja ]");
        for (int n : N_GRANDES) {
            int[] arreglo = GeneradorDatos.generarArreglo(n);
            double tIter = Medidor.medir(() -> OrdenamientoBurbuja.iterativo(arreglo));
            double tRec  = Medidor.medir(() -> OrdenamientoBurbuja.recursivo(arreglo));
            imprimir("A4 - Burbuja", "Iterativo", n, tIter);
            imprimir("A4 - Burbuja", "Recursivo", n, tRec);
            csv.printf("A4 - Burbuja,Iterativo,%d,%.6f%n", n, tIter);
            csv.printf("A4 - Burbuja,Recursivo,%d,%.6f%n", n, tRec);
        }
    }
}