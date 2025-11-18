/*
TRABAJO PRÁCTICO FINAL INTEGRADOR PROGRAMA (ADP) 
PROGRAMACION 1 

Autores: 
Aramburu Tiziano Sebastian
Guebara Alberto Iñaki
*/
import java.util.ArrayList; // Arrays modificables
import java.util.Scanner;

public class main {
    // Variables globales
    static float total_dinero = 0;
        // Utilizamos arraylist's para poder añadir elementos mas facilmente
    static ArrayList<Float> gastos_mensuales_monto = new ArrayList<Float>();;
    static ArrayList<String> gastos_mensuales_motivo = new ArrayList<String>();;
    static ArrayList<String> recordatorios = new ArrayList<String>();

    Scanner input = new Scanner(System.in);

    // Funcion que permite ingresar el dinero total
    static void ingresar_dinero(Scanner input) {

        System.out.println("Ingrese el dinero total a continuacion: ");
        total_dinero = input.nextFloat();
        input.nextLine();
        System.out.println("Dinero total actualizado: "+total_dinero);
    }

    // Funcion que permite registrar un nuevo gasto
    static void registrar_gasto(Scanner input, ArrayList<Float> gastos_mensuales_monto, ArrayList<String> gastos_mensuales_motivo) {

        System.out.println("Ingrese el motivo del gasto: ");
        String motivo = input.nextLine();
        System.out.println("Ingrese el monto correspondiente al gasto: ");
        Float monto = input.nextFloat();
        input.nextLine();

        if (monto <= total_dinero){ // Verifica que el gasto no sea mayor al monto total
            total_dinero -= monto;
            gastos_mensuales_motivo.add(motivo); // Añade el motivo y monto a cada array correspondiente
            gastos_mensuales_monto.add(monto);
            System.out.println("Gasto registrado con exito, dinero restante: "+ total_dinero);
        }else{
            System.out.println("Error: no hay suficiente dinero disponible.");
        }
    }
    
    // Funcion que permite consultar los gastos mensuales
    static void consultar_gastos(Scanner input, ArrayList<String> gastos_mensuales_motivo, ArrayList<Float> gastos_mensuales_monto){

        if (gastos_mensuales_monto.isEmpty()){ // Revisa si el array que almacena los gastos mensuales esta vacio
            System.out.println("No hay gastos registrados.");
        }else{
            System.out.println("--- GASTOS DEL MES ---");
            for (int i=0; i < gastos_mensuales_monto.size();i++){ // Muestra los gastos mensuales como una lista enumerada
                System.out.println((i+1) + " | "+ gastos_mensuales_motivo.get(i) + " | " + gastos_mensuales_monto.get(i));
            }
        System.out.println("¿Desea reinciar los gastos del mes?(s/n)");
        String reiniciar = input.nextLine();
        if (reiniciar.equals("s")){ // Si la respuesta es si, llama a la funcion reiniciar_gastos
            reiniciar_gastos();
        }
        }
    }

    static void reiniciar_gastos(){
        gastos_mensuales_monto.clear(); // Limpia ambos arrays
        gastos_mensuales_motivo.clear();

        System.out.println("Los gastos mensuales se han reiniciado correctamente.");
    }

    // Funcion que administra recordatorios
    static void gestionar_recordatorios(Scanner input, ArrayList<String> gastos_mensuales_motivo, ArrayList<Float> gastos_mensuales_monto, ArrayList<String> recordatorios) {

    while (true) {
        System.out.println("--- GESTOR DE RECORDATORIOS ---");
        System.out.println("1. Registrar nuevo recordatorio");
        System.out.println("2. Eliminar un recordatorio");
        System.out.println("3. Ver lista de recordatorios");
        System.out.println("4. Volver al menú principal");
        System.out.print("Seleccione una opción: ");

        int opcion = input.nextInt();
        input.nextLine();
        System.out.println();

        if (opcion == 1) { // Añadir rerdatorio
            System.out.print("Ingrese recordatorio (ej. pagar luz): ");
            String recordatorio = input.nextLine();
            recordatorios.add(recordatorio);
            System.out.println("Recordatorio agregado con éxito.");
            System.out.println();

        } else if (opcion == 2) { // Eliminar recordatorio
            if (recordatorios.isEmpty()) {
                System.out.println("No hay recordatorios para eliminar.");
            } else {
                System.out.println("--- LISTA DE RECORDATORIOS ---");
                for (int i = 0; i < recordatorios.size(); i++) {
                    System.out.println((i + 1) + ". " + recordatorios.get(i));
                }
                System.out.print("Seleccione el indice del recordatorio a eliminar (0 para cancelar): ");
                int numero = input.nextInt();
                input.nextLine();

                if (numero == 0) {
                    System.out.println("Operación cancelada.");
                } else if (numero >= 1 && numero <= recordatorios.size()) {
                    String eliminado = recordatorios.remove(numero - 1);
                    System.out.println("Recordatorio eliminado: " + eliminado);
                    System.out.println();
                } else {
                    System.out.println("Número fuera de rango.");
                }
            }

        } else if (opcion == 3) { // Listar recordatorios
            if (recordatorios.isEmpty()) {
                System.out.println("No hay recordatorios registrados.");
            } else {
                System.out.println("--- LISTA DE RECORDATORIOS ---");
                for (int i = 0; i < recordatorios.size(); i++) {
                    System.out.println((i + 1) + ". " + recordatorios.get(i));
                }
                System.out.println();
            }

        } else if (opcion == 4) { // Volver al menu principal
            break;
        } else {
            System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
    }


    public static void main(String[] args) {
    // main que contiene el menu principal

    Scanner input = new Scanner(System.in);
    String rta = "s";
    do{
    System.out.println("Administración del Dinero Personal (ADP), elija una opcion para continuar: ");
        System.out.println("1. Ingresar dinero total");
        System.out.println("2. Registrar gasto");
        System.out.println("3. Consultar gastos");
        System.out.println("4. Gestor de recordatorios");
        System.out.println("5. Salir");

        int opcion = input.nextInt();
        input.nextLine();

        if (opcion == 1){
            ingresar_dinero(input);
        }else if(opcion == 2) {
            registrar_gasto(input, gastos_mensuales_monto, gastos_mensuales_motivo);
        }else if(opcion == 3) {
            consultar_gastos(input, gastos_mensuales_motivo, gastos_mensuales_monto);
        }else if(opcion == 4){
            gestionar_recordatorios(input, gastos_mensuales_motivo, gastos_mensuales_monto, recordatorios);
        
        }else if (opcion == 5){
            System.out.println("Saliendo...");
            break;
        }else{ 
            System.out.println("Opción inválida.");
        }

        System.out.println("¿Desea realizar otra operación? (s/n)");
        rta = input.nextLine();

    }
    while (rta.equals("s"));
    }
}
