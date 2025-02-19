package org.example;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


class Filosofo extends Thread {
    private int id;
    private Semaphore izq, der;

    public Filosofo(int id, Semaphore izq, Semaphore der) {
        this.id = id;
        this.izq = izq;
        this.der = der;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Filósofo " + id + " está pensando.");
                Thread.sleep((int) (Math.random() * 1000));
                izq.acquire();
                der.acquire();
                System.out.println("Filósofo " + id + " está comiendo.");
                Thread.sleep((int) (Math.random() * 1000));
                izq.release();
                der.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}