package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Resolver el problema de los filósofos");
            System.out.println("2. Resolver el problema de las N-Reinas");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    FilosofosCena.iniciarFilosofos();
                    break;
                case 2:
                    int n;
                    do {
                        System.out.println("Ingrese el número de reinas (mínimo 4): ");
                        n = scanner.nextInt();
                        if (n < 4) {
                            System.out.println("El número de reinas debe ser al menos 4. Intente nuevamente.");
                        }
                    } while (n < 4);
                    NReinas problema = new NReinas(n);
                    problema.resolver();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
