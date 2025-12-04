package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la edad de la persona:");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el número de vuelos al año:");
        int numeroVuelos = scanner.nextInt();

        System.out.println("¿Es estudiante? (true/false):");
        boolean esEstudiante = scanner.nextBoolean();

        scanner.nextLine(); 

        System.out.println("Ingrese el tipo de clase:");
        String tipoClase = scanner.nextLine();

        System.out.println("Número de desplazamientos mensuales:");
        int numDesplazamientosMes = scanner.nextInt();

        System.out.println("¿Trabaja? (true/false):");
        boolean trabaja = scanner.nextBoolean();

        System.out.println("¿Vive con padres? (true/false):");
        boolean viveConPadres = scanner.nextBoolean();

        System.out.println("Ingrese ingresos:");
        double ingresos = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Destino del vuelo:");
        String destino = scanner.nextLine();

        System.out.println("¿Viaja con niños? (true/false):");
        boolean viajaConNinos = scanner.nextBoolean();

        int edadNinos = 0;
        int numNinos = 0;

        if (viajaConNinos) {
            System.out.println("¿Cuántos niños?");
            numNinos = scanner.nextInt();

            System.out.println("Edad del niño menor:");
            edadNinos = scanner.nextInt();
        }

        System.out.println("Precio del vuelo:");
        double precioVuelo = scanner.nextDouble();

        System.out.println("Número de billetes:");
        int numBilletes = scanner.nextInt();

        String resultado = Tarifa.calcularTarifa(edad, numeroVuelos, esEstudiante, tipoClase, numDesplazamientosMes,trabaja, viveConPadres, ingresos, destino, viajaConNinos,numNinos, edadNinos, precioVuelo, numBilletes);

        System.out.println(resultado);
        scanner.close();
    }
}
