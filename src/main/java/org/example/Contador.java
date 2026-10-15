package org.example;

public class Contador {

    static int valor = 0;

    static synchronized void incrementar(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        valor ++;
    }

    public static int getValor() {
        return valor;
    }
}
