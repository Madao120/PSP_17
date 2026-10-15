package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio17 {
    static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in); // 2. Declarar e instanciar

        System.out.print("Introduce 5 consonantes separadas por un espacio: ");
        String consonantes = scanner.nextLine();

        System.out.print("Introduce un texto cualquiera (No voy a poner scanner, usaré un archivo)");

        StringBuilder texto = new StringBuilder();

        String ruta = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Programacion_Servicios_Procesos\\Trimestre_1\\PSP_17\\texto.txt";

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))){
            String linea;
            while ((linea = lector.readLine()) != null){
                texto.append(linea).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // A partir de las consonantes introducidas, haremos una lista para futuras operaciones
        List<String> listaConsonantes = new ArrayList<>(
                Arrays.asList(consonantes.trim().split("\\s+"))
        );

        for (String consonante : listaConsonantes) {
            consonante = consonante.trim();

            if (!consonante.matches("[B-DF-HJ-NP-TV-ZÑb-df-hj-np-tv-zñ]")) {
                System.out.println(consonante + " no es una consonante válida.");
                return;
            }
        }

        if (listaConsonantes.size() != 5){
            System.out.println("\nDeben de ser 5 consonantes");
            return;
        }

        System.out.println("\n"+texto);

        // Bucle de iteración
        List<Consonante> hilos = new ArrayList<>();

        for (String consonante : listaConsonantes) {
            Consonante hilo = new Consonante(consonante, texto.toString());
            hilos.add(hilo);
            hilo.start();
        }


        // Esperar a que terminen todos los hilos
        for (Consonante hilo : hilos) {
            hilo.join();
        }

        System.out.println("\nEl contador total es de "+ Contador.getValor());
    }
}
