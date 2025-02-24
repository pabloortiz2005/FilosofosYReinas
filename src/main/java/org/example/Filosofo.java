package org.example;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


class Filosofo extends Thread {
    private int id;
    private Semaphore izq, der;
    private volatile boolean seguirEjecutando = true; // Variable de control

    public Filosofo(int id, Semaphore izq, Semaphore der) {
        this.id = id;
        this.izq = izq;
        this.der = der;
    }

    public void detener() {
        seguirEjecutando = false;
        this.interrupt(); // Interrumpe el hilo para salir de sleep() o acquire()
    }

    public void run() {
        try {
            while (seguirEjecutando) {
                System.out.println("Filósofo " + id + " está pensando.");
                Thread.sleep((int) (Math.random() * 1000));
                //intenta tomar los cubiertos
                izq.acquire();
                der.acquire();
                System.out.println("Filósofo " + id + " está comiendo.");
                Thread.sleep((int) (Math.random() * 1000));
                //liberar cubiertos
                izq.release();
                der.release();
            }
            System.out.println("Filósofo " + id + " ha terminado.");
        } catch (InterruptedException e) {
            System.out.println("Filósofo " + id + " interrumpido.");
        }
    }
}