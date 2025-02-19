package org.example;

import org.example.Filosofo;

import java.util.concurrent.Semaphore;


class FilosofosCena {
    public static void iniciarFilosofos() {
        int numFilosofos = 5;
        Semaphore[] tenedores = new Semaphore[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1);
        }

        Filosofo[] filosofos = new Filosofo[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % numFilosofos]);
            filosofos[i].start();
        }
    }
}
