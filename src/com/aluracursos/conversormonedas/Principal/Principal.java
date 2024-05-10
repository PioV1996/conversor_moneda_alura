package com.aluracursos.conversormonedas.Principal;

import com.aluracursos.reto.conversormonedas.ConsultarDatos;
import com.aluracursos.reto.conversormonedas.Conversor;
import com.aluracursos.reto.conversormonedas.Monedas;

import java.util.Scanner;

public class Principal {
    static Scanner input = new Scanner(System.in);
    static ConsultarDatos datos = new ConsultarDatos();
    static Monedas monedas;
    public static void main(String[] args) {
        int opcion = 0;
        boolean activo = true;

//        System.out.println(monedas.base_code());

        while (opcion != 7){
            menu();
            opcion = input.nextInt();
            switch (opcion){
                case 1:
                    convertirMonedas("USD", "ARS");
                    break;
                case 2:
                    convertirMonedas("ARS", "USD");
                    break;
                case 3:
                    convertirMonedas("USD", "BRL");
                    break;
                case 4:
                    convertirMonedas("BRL", "USD");
                    break;
                case 5:
                    convertirMonedas("USD", "COP");
                    break;
                case 6:
                    convertirMonedas("COP", "USD");
                    break;
                case 7:
                    activo = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        
            

//        System.out.println(monedas.conversion_rates().asMap());

//        JsonElement ars = monedas.conversion_rates().get("ARS");
//        JsonElement bob = monedas.conversion_rates().get("BOB");
//        JsonElement brl = monedas.conversion_rates().get("BRL");
//        JsonElement clp = monedas.conversion_rates().get("CLP");
//        JsonElement cop = monedas.conversion_rates().get("COP");
//        JsonElement usd = monedas.conversion_rates().get("USD");
//        System.out.println(ars);
//        System.out.println(bob);
//        System.out.println(brl);
//        System.out.println(clp);
//        System.out.println(cop);
//        System.out.println(usd);
    }

    public static void menu(){
        System.out.print("""
                Bienvenido al menú para convertir monedas, elige una opción.
                1. Dólar a Peso Argentino.
                2. Peso Argentino a Dólar.
                3. Dólar a Real Brasileño.
                4. Real Brasileño a Dólar.
                5. Dólar a Peso colombiano
                6. Peso colombiano a Dólar
                7. Salir
                Eliga una opción:\s""");
    }

    public static void convertirMonedas(String base, String rate){
        monedas = datos.buscarMonedas(base);
        System.out.print("Ingrese el monto a convetir: ");
        float monto = input.nextShort();
        float cambio = monedas.conversion_rates().get(rate).getAsFloat();
        float conversor = new Conversor().convertirMoneda(cambio,monto);
        System.out.println(conversor);
    }

}
