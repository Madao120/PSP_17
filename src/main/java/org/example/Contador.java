package org.example;

// Es el contador global para cada uno de los hilos
public class Contador {

    // Establecemos el contador en 0
    static int valor = 0;

    // Para incrementar haremos un sleep de 10ms, basado en el contador de las diapositivas.
    static synchronized void incrementar(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        valor ++;
    }

    // Puse un getter para poder sacar la variable hacia la calse main
    public static int getValor() {
        return valor;
    }
}
