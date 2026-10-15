package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// La clase de ejecución del programa, donde está el main basicamente
public class Ejercicio17 {
    static void main(String[] args) throws InterruptedException {

        // IMplementamos un Scanner para que el usuario escriba las consonantes a escribir
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce 5 consonantes separadas por un espacio: ");
        String consonantes = scanner.nextLine();

        // A partir de las consonantes introducidas, haremos una lista para futuras operaciones
        List<String> listaConsonantes = new ArrayList<>(
                Arrays.asList(consonantes.trim().split("\\s+"))
        );

        // Comprobaremos que en verdad sea una consonante, gracias a la IA pude sacar el regex de comprobación para aglizar la excepción
        for (String consonante : listaConsonantes) {
            consonante = consonante.trim();

            if (!consonante.matches("[B-DF-HJ-NP-TV-ZÑb-df-hj-np-tv-zñ]")) {
                System.out.println(consonante + " no es una consonante válida.");
                return;
            }
        }

        // Dará error en caso de que no se introduzcan exactamente 5 consonantes
        if (listaConsonantes.size() != 5){
            System.out.println("\nDeben de ser 5 consonantes");
            return;
        }


        // Aquí se pediría el texto por parte del usuario, pero usaré un .txt paar agilizar las pruebas
        System.out.print("Introduce un texto cualquiera: ");
        StringBuilder texto = new StringBuilder();

        // Se establece al ruta del archivo donde está el texto
        String ruta = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Programacion_Servicios_Procesos\\Trimestre_1\\PSP_17\\texto.txt";

        // Establecemos el texto del archivo en una variable llama "texto"
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))){
            String linea;
            while ((linea = lector.readLine()) != null){
                texto.append(linea).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("\n"+texto);

        // Bucle de iteración, donde creamos e iniciamos todos los hilos
        List<Consonante> hilos = new ArrayList<>();

        for (String consonante : listaConsonantes) {
            Consonante hilo = new Consonante(consonante, texto.toString());
            hilos.add(hilo);
            hilo.start();
        }


        // Esperar a que se terminen todos los hilos, por eso se realizó la lista "hilos" anteriormente
        for (Consonante hilo : hilos) {
            hilo.join();
        }

        // Por último ultimísimo sacaremos el valor del contador global
        System.out.println("\nEl contador total es de "+ Contador.getValor());
    }
}
