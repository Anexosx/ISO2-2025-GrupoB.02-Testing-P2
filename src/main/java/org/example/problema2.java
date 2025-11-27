package org.example;

public class problema2 {
    public String calcularTarifa(int edad, int numeroVuelos, boolean esEstudiante, String tipoClase, int numDesplazamientosMes, boolean trabaja, boolean viveConPadres, double ingresos, String destino, boolean viajaConNinos, int edadNinos, double precioVuelo, int numBilletes){
        String tarifa = "";
        int numVuelos = 0;
        int numViajes = 0;
        int numBillestes = 0;
        
        if(edad < 18 && numeroVuelos >= 6){
        tarifa = "Pajarillo";
        precioVuelo = precioVuelo * 0.90;
    }

    if((edad > 18 || edad < 25) && (esEstudiante == true && tipoClase == "turista" && numDesplazamientosMes >= 1)){
       tarifa = "Gorrión";
       precioVuelo = precioVuelo * 0.85;
    }

    if((edad > 18 || edad < 25) && (trabaja == true && numVuelos >= 3 && tipoClase == "turista")){
        if(viveConPadres == true){
            tarifa = "Viaja ahora que puedes";
            precioVuelo = precioVuelo * 0.95;
        }else{
            tarifa = "Atreviéndose a saltar del Nido";
            precioVuelo = precioVuelo * 0.75;
        }
    }

    if((edad > 25) && (ingresos > 20000 && ingresos < 35000) && (numViajes >= 6 && tipoClase == "turista" && destino == "Europa")){
        if(viajaConNinos == false){
            tarifa = "Conoce Europa";
            precioVuelo = precioVuelo * 0.85;
        }else if(viajaConNinos == true && edadNinos < 12){
            tarifa = "Conoce Europa con tus peques";
            for(int i = 0; i < numBilletes; i++){
                precioVuelo = precioVuelo * 0.90;
            }
        }
    }

    if(edad > 25 && ingresos > 35000 && (numVuelos >= 6 && tipoClase == "business" && (destino == "Asia" || destino == "America"))){
        if(viajaConNinos == false){
            tarifa = "Conoce el Mundo";
            precioVuelo = precioVuelo * 0.80;
        }else if(viajaConNinos == true && edadNinos < 12){
            tarifa = "Conoce el Mundo con tus peques";
            for(int i = 0; i < numBillestes; i++){
                precioVuelo = precioVuelo * 0.90;
            }
        }
    }
    return tarifa;
    } 
}
