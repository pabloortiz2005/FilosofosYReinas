package org.example;

class NReinas {
    private int n;
    private int[] tablero;

    public NReinas(int n) {
        this.n = n;
        this.tablero = new int[n];
    }

    private boolean esValido(int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == col || Math.abs(tablero[i]
                    - col) == Math.abs(i - fila)) {
                return false;
            }
        }
        return true;
    }

    private void resolver(int fila) {
        if (fila == n) {
            mostrarTablero();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (esValido(fila, col)) {
                tablero[fila] = col;
                resolver(fila + 1);
            }
        }
    }

    private void mostrarTablero() {
        System.out.println("Solución encontrada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resolver() {
        resolver(0);
    }
}