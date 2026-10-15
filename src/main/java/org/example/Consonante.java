package org.example;

public class Consonante extends Thread{
    String consonante = "b";
    String texto = "";
    long contador = 0;

    public Consonante (String consonante, String texto){
        this.consonante = consonante;
        this.texto = texto;
    }

    @Override
    public void run(){
        for (int i = 0; i < texto.length(); i++) {
            if (String.valueOf(texto.charAt(i)).equalsIgnoreCase(consonante)) {
                contador++;
                Contador.incrementar();
            }
        }
        System.out.println("La Consonante ["+consonante+ "] se repite: " + contador + " veces");
    }
}
