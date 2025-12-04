package org.example;
class Tarifa {
    public static String calcularTarifa(int edad, int numeroVuelos, boolean esEstudiante, String tipoClase, int numDesplazamientosMes, boolean trabaja, boolean viveConPadres, double ingresos, String destino, boolean viajaConNinos, int numNinos, int edadNinos, double precioVuelo, int numBilletes) {

        String tarifa = "Sin tarifa"; //inicializacion de la tarifa por si no se cumple ningun tipo de condicion de tarifa
        double precioFinal = precioVuelo * numBilletes;

        if (edad < 18 && numeroVuelos >= 6) {
            tarifa = "Pajarillo";
            precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes);
        }

        if ((edad >= 18 && edad <= 25) && esEstudiante && tipoClase.equals("turista") && numDesplazamientosMes >= 1) {

            tarifa = "Gorrión";
            precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes);
        }


        if (edad >= 18 && edad <= 25 && trabaja && numeroVuelos >= 3 && tipoClase.equals("turista")) {

            if (viveConPadres) {
                tarifa = "Viaja ahora que puedes";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 5% descuento
            }

            if (!viveConPadres) {
                tarifa = "Atreviéndose a saltar del Nido";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 25% descuento
            }
        }

        if (edad > 25 && ingresos > 20000 && ingresos < 35000 && numeroVuelos >= 6 && tipoClase.equals("turista") && destino.equals("Europa")) {

            if (!viajaConNinos) {
                tarifa = "Conoce Europa";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 15%
            }

            if (viajaConNinos && edadNinos < 12) {
                tarifa = "Conoce Europa con tus peques";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 10%
            }
        }


        if (edad > 25 && ingresos >= 35000 && numeroVuelos >= 6 &&
                tipoClase.equals("business") &&
                (destino.equals("Asia") || destino.equals("America"))) {

            if (!viajaConNinos) {
                tarifa = "Conoce el Mundo";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 20%
            }

            if (viajaConNinos && edadNinos < 12) {
                tarifa = "Conoce el Mundo con tus peques";
                precioFinal = calcularPrecioVuelo(tarifa, precioVuelo, numBilletes); // 10%
            }
        }

        return tarifa + " | Precio: " + precioFinal + " €";
    }

    public static double calcularPrecioVuelo(String tarifa, double precioVuelo, int numBillestes){
        double precio = 0.0;

        switch (tarifa) {
            case "Pajarillo":
                precio = (precioVuelo * 0.90) * numBillestes;
                break;
            case "Gorrión":
                precio = (precioVuelo * 0.85) * numBillestes;
                break;
            case "Viaja ahora que puedes":
                precio = (precioVuelo * 0.95) * numBillestes;
                break;
            case "Atreviéndose a saltar del Nido":
                precio = (precioVuelo * 0.75) * numBillestes;
                break;
            case "Conoce Europa":
                precio = (precioVuelo * 0.85) * numBillestes;
                break;
            case "Conoce Europa con tus peques":
                precio = (precioVuelo * 0.90) * numBillestes;
                break;
            case "Conoce el Mundo":
                precio = (precioVuelo * 0.80) * numBillestes;
                break;
            case "Conoce el Mundo con tus peques":
                precio = (precioVuelo * 0.90) * numBillestes;
                break;
            default:
                precio = precioVuelo * numBillestes;
                break;
        }
        return precio;
    }
}
