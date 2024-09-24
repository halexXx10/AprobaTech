import java.util.Scanner;

public class NotasEstudiantes {
    public static void main(String[] args) {
        // Se asignan variables a algunos valores mágicos
        final double APROBACION = 3.0;
        final int NUM_ESTUDIANTES = 5; // Modifica aquí el número de estudiantes para probar
        final int NUM_NOTAS = 3;

        // Crear un escáner para leer los datos
        Scanner scanner = new Scanner(System.in);

        // Declaración de arrays para almacenar datos de los estudiantes
        String[] nombres = new String[NUM_ESTUDIANTES];
        String[] identificaciones = new String[NUM_ESTUDIANTES];
        double[][] matrizNotas = new double[NUM_ESTUDIANTES][NUM_NOTAS];

        // Entrada de datos
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println("Ingrese el nombre del estudiante " + (i + 1) + ":");
            nombres[i] = scanner.nextLine();

            System.out.println("Ingrese la identificación del estudiante " + (i + 1) + ":");
            identificaciones[i] = scanner.nextLine();

            for (int j = 0; j < NUM_NOTAS; j++) {
                double nota = 0.0;
                // Ciclo para validar que la nota esté en el rango correcto
                while (true) {
                    System.out.println("Ingrese la nota " + (j + 1) + " del estudiante " + (i + 1) + " (rango del 0.0 al 5.0):");
                    String input = scanner.nextLine(); // Lee el input completo como una línea
                    try {
                        nota = Double.parseDouble(input); // Intenta convertir el input a double
                        if (nota >= 0.0 && nota <= 5.0) {
                            matrizNotas[i][j] = nota;
                            break; // Sale del ciclo si la nota es válida
                        } else {
                            System.out.println("Nota fuera de rango. Intente nuevamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Intente nuevamente.");
                    }
                }
            }
        }

        // Mostrar reporte de estudiantes aprobados y reprobados
        System.out.println("--- Reporte Final ---");

        // Estudiantes Aprobados
        boolean hayAprobados = false;
        System.out.println("Estudiantes Aprobados:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            // Calcular el promedio manualmente
            double suma = 0;
            for (int j = 0; j < NUM_NOTAS; j++) {
                suma += matrizNotas[i][j];
            }
            double promedio = suma / NUM_NOTAS;

            if (promedio >= APROBACION) {
                hayAprobados = true;
                System.out.println("Nombre: " + nombres[i] + ", ID: " + identificaciones[i] + ", Promedio: " + promedio);
            }
        }
        if (!hayAprobados) {
            System.out.println("No hay estudiantes aprobados.");
        }

        // Estudiantes Reprobados
        boolean hayReprobados = false;
        System.out.println("\nEstudiantes Reprobados:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            // Calcular el promedio manualmente
            double suma = 0;
            for (int j = 0; j < NUM_NOTAS; j++) {
                suma += matrizNotas[i][j];
            }
            double promedio = suma / NUM_NOTAS;

            if (promedio < APROBACION) {
                hayReprobados = true;
                System.out.println("Nombre: " + nombres[i] + ", ID: " + identificaciones[i] + ", Promedio: " + promedio);
            }
        }
        if (!hayReprobados) {
            System.out.println("No hay estudiantes reprobados.");
        }

        // Cerrar el escáner
        scanner.close();
    }
}
