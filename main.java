import java.util.ArrayList; // Arrays modificables
import java.util.Scanner;

public class main {
    // Variables globales
    float total_dinero = 0;
        // Utilizamos arraylist's para poder añadir elementos mas facilmente
    static ArrayList<Float> gastos_mensuales_monto = new ArrayList<Float>();;
    static ArrayList<String> gastos_mensuales_motivo = new ArrayList<String>();;
    static ArrayList<String> recordatorios = new ArrayList<String>();

    // Funcion que permite ingresar el dinero total
    static void ingreso_dinero() {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el dinero total a continuacion: ");
        float total_dinero = input.nextFloat();
        System.out.println("Dinero total actualizado: "+total_dinero);
        input.close();
    }

    static void registrar_gasto(float total_dinero, float gastos_mensuales) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el motivo del gasto: ");
        String motivo = input.nextLine();
        System.out.println("Ingrese el monto correspondiente al gasto: ");
        float monto = input.nextFloat();

        if (monto <= total_dinero){
            total_dinero -= monto;
            gastos_mensuales_motivo.add(motivo);
            gastos_mensuales_monto.add(monto);
            System.out.println("Gasto registrado. Dinero restante: "+ total_dinero);
        }else{
            System.out.println("Error: no hay suficiente dinero disponible.");
        }
        input.close();
    }
    
    public static void main(String[] args) {
    
    }
}
