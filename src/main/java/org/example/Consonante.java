package org.example;

public class Consonante extends Thread{
    // Nombre de la consonante que representará, b por defecto
    String consonante = "b";
    // El texto donde veremos cuantas veces se repite la consonante
    String texto = "";
    // Long donde contaremos las veces que aparece
    long contador = 0;

    // Contrsuctor con la consonanet y el texto completo
    public Consonante (String consonante, String texto){
        this.consonante = consonante;
        this.texto = texto;
    }

    // A partir de la longitud del texto, haremos un bucle por cada letra (Char), para ver si es la misma que la consonante introducida
    @Override
    public void run(){
        for (int i = 0; i < texto.length(); i++) {
            if (String.valueOf(texto.charAt(i)).equalsIgnoreCase(consonante)) {
                // Si es la misma letra, incrementamos tanto el contador de la consonante como el contados global
                contador++;
                Contador.incrementar();
            }
        }
        System.out.println("La Consonante ["+consonante+ "] se repite: " + contador + " veces");
    }
}
