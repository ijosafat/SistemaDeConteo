/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeconteo;

/**
 *
 * @author lachi
 */
import java.util.Arrays;
import java.util.Scanner;

public class SistemaDeConteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //declaracion de variables iniciales
        Scanner scanner = new Scanner(System.in);
        String[] arregloDeVotosStr;
        int[] arregloDeVotosInt;
        crearCabecera();

        try {

            String inputDeUsuario = scanner.nextLine();
            arregloDeVotosStr = inputDeUsuario.split(",");
            arregloDeVotosInt = conversorDeArreglo(arregloDeVotosStr);
            contarFrecuencia(arregloDeVotosInt, arregloDeVotosInt.length);
        } catch (Exception e) {
            System.out.println("Por favor ingrese solo numeros seguidos por una coma e intente de nuevo");
        }

    }

    public static void crearCabecera() {
        System.out.println("*************************************************************");
        System.out.println("*************************************************************\n");
        System.out.println("Ingrese la cantidad de votos, cada voto debe de ser seguido por una coma: \n");
        System.out.println("Ejemplo: 1, 3, 4, 2, 1, 4, 4, 3, 3, 2");
    }

    public static int[] conversorDeArreglo(String[] strArray) {
        int[] nuevoArregloNumerico = new int[strArray.length];
        for (int i = 0; i < nuevoArregloNumerico.length; i++) {
            String elemento = strArray[i];
            nuevoArregloNumerico[i] = Integer.parseInt((elemento.trim()));
        }
        return nuevoArregloNumerico;
    }

    public static void contarFrecuencia(int arr[], int n) {
        boolean visitado[] = new boolean[n];
        Arrays.fill(visitado, false);
        for (int i = 0; i < n; i++) {
            // Saltar elemento si ya lo conocemos
            if (visitado[i] == true) {
                continue;
            }

            // Contar frecuencia
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visitado[j] = true;
                    count++;
                }
            }
            System.out.println("Votos para candidato " + arr[i] + ": " + count);
        }
    }

}
