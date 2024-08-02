import java.util.*;

public class Main {

    public static void main(String[] args) {

        int longitudArray = 100;
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[longitudArray];
        for (int i = 0; i < longitudArray; i++) {
            array[i] = random.nextInt(50);
        }

        while (true) {
            System.out.println("Seleccione el método para encontrar el número más frecuente:");
            System.out.println("1. Complejidad Lineal (O(n))");
            System.out.println("2. Complejidad Cuadrática (O(n^2))");
            System.out.println("3. Complejidad Logarítmica (O(n log n))");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El numero mas frecuente es: "+encontrarMasFrecuenteLineal(array));
                    break;
                case 2:
                    System.out.println("El numero mas frecuente es: "+encontrarMasFrecuenteCuadratica(array));
                    break;
                case 3:
                    System.out.println("El numero mas frecuente es: "+encontrarMasFrecuenteLogaritmica(array));
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static int encontrarMasFrecuenteLineal(int[] array) {
        int[] conteo = new int[array.length];
        for (int num : array) {
            conteo[num]++;
        }
        int masFrecuente = -1;
        int maxFrecuencia = 0;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] > maxFrecuencia) {
                masFrecuente = i;
                maxFrecuencia = conteo[i];
            }
        }
        return masFrecuente;
    }


    private static int encontrarMasFrecuenteCuadratica(int[] array) {
        int masFrecuente = -1;
        int maxFrecuencia = 0;
        for (int i = 0; i < array.length; i++) {
            int cuenta = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    cuenta++;
                }
            }
            if (cuenta > maxFrecuencia) {
                masFrecuente = array[i];
                maxFrecuencia = cuenta;
            }
        }
        return  masFrecuente;
    }

    private static int encontrarMasFrecuenteLogaritmica(int[] array) {
        Arrays.sort(array);
        int masFrecuente = array[0];
        int maxFrecuencia = 1;
        int cuentaActual = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                cuentaActual++;
            } else {
                if (cuentaActual > maxFrecuencia) {
                    maxFrecuencia = cuentaActual;
                    masFrecuente = array[i - 1];
                }
                cuentaActual = 1;
            }
        }

        if (cuentaActual > maxFrecuencia) {
            masFrecuente = array[array.length - 1];
        }
        return masFrecuente;
    }
}
