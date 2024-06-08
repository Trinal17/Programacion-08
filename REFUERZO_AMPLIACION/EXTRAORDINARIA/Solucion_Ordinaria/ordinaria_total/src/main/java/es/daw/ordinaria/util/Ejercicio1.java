package es.daw.ordinaria.util;

import java.util.Scanner;

public class Ejercicio1 {
    
    // Global ...
    static Scanner lector = new Scanner(System.in);
    static float[][] facturas = null;
    static final int NUM_GASTOS = 3;


    public static void ejecuta(){


        int opcion = 0;
        do{

            pintaMenu();

            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el número de facturas");
                    int numFacturas = lector.nextInt();
                    facturas = new float[numFacturas][NUM_GASTOS];

                    //facturas = new float[numFacturas][];
                    // podría crear una matriz variable de la segunda dimensión
                    // y tendría que preguntar por cada factura cuántos gasto tiene

                    // ALTERNATIVA: SI NO SABES CARGAR LOS DATOS, CREA A MANO!!!!
                    // A mano: primera forma
                    // float[][] facturas = {{1,2,3},{4,5,6}};
                    // float[] gasto1 = {1,2,3};
                    // float[] gasto2 = {1,2,3};
                    // float[][] facturas2 = {gasto1,gasto2};
                    
                    // A mano: segunda forma
                    /*float[][] facturas = new float[2][3]; // 2 facturas de 3 gastos cada una
                    facturas[0][0] = 1;
                    facturas[0][1] = 2;
                    facturas[0][2] = 3;
                    facturas[1][0] = 4;
                    facturas[1][1] = 5;
                    facturas[1][2] = 6;*/


                    pedirGastosFacturas();

                    break;
            
                case 2:
                    if (facturas == null)
                        System.out.println("No has introducido primero los datos...");
                    else
                        obtenerImportesFacturas();

                    break;
                case 3:
                    System.out.println("Vas a salir del programa..");
                    break;

                default:
                    System.out.println("Has elegido una opción incorrecta!");
                    break;
            }

        }while(opcion != 3);





    }

    /**
     * 
     */
    public static void pintaMenu(){
        System.out.println("**** MENÚ ****");
        System.out.println("1. Introducir datos");
        System.out.println("2. Informe completo");
        System.out.println("3. Salir");
        System.out.println("Elige una opción: ");
    }

    public static void pedirGastosFacturas(){

        for (int i = 0; i < facturas.length; i++) {
            System.out.println("* Introduce los gastos de la factura <"+(i+1)+">");
            for (int j = 0; j < facturas[i].length; j++) {
                System.out.println("\t* Gasto <"+(j+1)+">");
                facturas[i][j] = lector.nextFloat();
            }
        }
    }

    public static void obtenerImportesFacturas(){

        float sumaTotalFacturas = 0;
        float sumaTotalFactura = 0;

        for (int i = 0; i < facturas.length; i++){
            System.out.println("\tFactura ("+(i+1)+"): ");
            for (int j = 0; j < facturas[i].length; j++){
                System.out.println("\tGasto ("+(j+1)+"): "+facturas[i][j]);
                sumaTotalFactura += facturas[i][j];
            }
            sumaTotalFacturas += sumaTotalFactura;
            System.out.println("Factura "+(i+1)+", total importe: "+sumaTotalFactura+" euros.");
            sumaTotalFactura = 0;
        }
        System.out.println("Importe total: "+sumaTotalFacturas+" euros.");
        

    }

}
