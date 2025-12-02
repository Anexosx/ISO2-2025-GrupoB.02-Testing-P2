package org.example;
class Problema2 {

    public static void main(String[] args){

    }
    public String calcularTarifa(int edad, int numeroVuelos, boolean esEstudiante, String tipoClase, int numDesplazamientosMes, boolean trabaja, boolean viveConPadres, double ingresos, String destino, boolean viajaConNinos, int edadNinos, double precioVuelo, int numBilletes) {

        String tarifa = "Sin tarifa"; //inicializacion de la tarifa por si no se cumple ningun tipo de condicion de tarifa

        /* 1- Pajarillo: Si el cliente es menor de edad, y realiza al menos 6 vuelos al año, el tipo de tarifa que se
           le puede ofrecer es “Pajarillo” (con un descuento de 10% sobre el precio del vuelo). */

        if (edad < 18 && numeroVuelos >= 6) {
            tarifa = "Pajarillo";
            precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
        }

        /* 2- Gorrión:  Si el cliente tiene entre 18 y 25 años y está estudiando en una universidad en otra
           ciudad, desplazándose en clase turista del domicilio familiar al menos una vez al mes
           durante los meses del curso entre ambas ciudades, se le ofrecerá la tarifa “Gorrión” (con
           un descuento del 15% sobre el precio del vuelo).  */

        if (edad >= 18 || edad <= 25 && esEstudiante && tipoClase.equals("turista") && numDesplazamientosMes >= 1) {

            tarifa = "Gorrión";
            precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
            precioVuelo = precioVuelo * 0.85;
        }

        /* 3- Viaja ahora que puedes / Atreviéndose a saltar del Nido: Si el cliente tiene entre 18 y 25 años, y si ha empezado a trabajar, pero vive aun con sus
           padres, y realiza al menos tres viajes de placer al año en clase turista se le ofrecerá la
           tarifa “Viaja ahora que puedes” (con un descuento del 5% sobre el precio del vuelo); por
           el contrario, si ya no vive con sus padres, se le ofrecerá la tarifa “Atreviéndose a saltar
           del Nido” (con un descuento del 25% sobre el precio del vuelo).  */

        if (edad >= 18 && edad <= 25 && trabaja && numeroVuelos >= 3 && tipoClase.equals("turista")) {

            if (viveConPadres) {
                tarifa = "Viaja ahora que puedes";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = precioVuelo * 0.95; // 5% descuento
            }

            if (!viveConPadres) {
                tarifa = "Atreviéndose a saltar del Nido";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = precioVuelo * 0.75; // 25% descuento
            }
        }

        /* 4- Conoce Europa (sin o con niños): Si el cliente tiene entre 18 y 25 años, y si ha empezado a trabajar, pero vive aun con sus
           padres, y realiza al menos tres viajes de placer al año en clase turista se le ofrecerá la
           tarifa “Viaja ahora que puedes” (con un descuento del 5% sobre el precio del vuelo); por
           el contrario, si ya no vive con sus padres, se le ofrecerá la tarifa “Atreviéndose a saltar
           del Nido” (con un descuento del 25% sobre el precio del vuelo).  */

        if (edad > 25 && ingresos > 20000 && ingresos < 35000 && numeroVuelos >= 6 && tipoClase.equals("turista") && destino.equals("Europa")) {

            if (!viajaConNinos) {
                tarifa = "Conoce Europa";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = precioVuelo * 0.85; // 15%
            }

            if (viajaConNinos && edadNinos < 12) {
                tarifa = "Conoce Europa con tus peques";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = (precioVuelo * 0.90)*numBilletes; // 10%
            }
        }

        /* 5- Conoce el Mundo (sin o con niños): Si es mayor de 25 años, tiene unos ingresos superiores a 20.000 € pero menores que
              35.000 y realiza al menos 6 viajes al año en clase turista a destinos dentro de Europa se
              le puede ofrecer la tarifa “Conoce Europa” (con un descuento del 15% sobre el precio
              del vuelo) y si viaja con niños (menores de 12 años), se le puede ofrecer la tarifa “Conoce
              Europa con tus peques” (con un descuento del 10% sobre el precio de cada uno de los
              billetes).  */

        if (edad > 25 && ingresos >= 35000 && numeroVuelos >= 6 && tipoClase.equals("business") && destino.equals("Asia") || destino.equals("America")) {

            if (!viajaConNinos) {
                tarifa = "Conoce el Mundo";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = precioVuelo * 0.80; // 20%
            }

            if (viajaConNinos && edadNinos < 12) {
                tarifa = "Conoce el Mundo con tus peques";
                precioVuelo = calcularPrecioVuelo(tarifa, precioVuelo,numBilletes);
                precioVuelo = (precioVuelo * 0.90)*numBilletes; // 10%
            }
        }
        return tarifa;
    }

    public double calcularPrecioVuelo(String tarifa, double precioVuelo, int numBillestes){
        double precio = 0.0;
        switch (tarifa) {
            case "Pajarillo":
                precio = precioVuelo * 0.90;
                break;
            case "Gorrión":
                precio = precioVuelo * 0.85;
                break;
            case "Viaja ahora que puedes":
                precio = precioVuelo * 0.95; 
                break;
            case "Atreviéndose a saltar del Nido":
                precio = precioVuelo * 0.75;
                break;
            case "Conoce Europa":
                precio = precioVuelo * 0.85;
                break;
            case "Conoce Europa con tus peques":
                precio = (precioVuelo * 0.90) * numBillestes;
                break;
            case "Conoce el Mundo":
                precio = precioVuelo * 0.80;
                break;
            case "Conoce el Mundo con tus peques":
                precio = (precioVuelo * 0.90) * numBillestes;
                break;
            default:
                break;
        }
        return precio;
    }
}
