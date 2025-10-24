public class Parking {
    private final int[] plazas;
    private int libres;
    private final int espera = (int)(Math.random() * (9000 - 3000 + 1)) + 3000;

    public Parking(int capacidad) {
        this.plazas = new int[capacidad];
        this.libres = capacidad;
    }

    public synchronized int aparcar(int matricula) {
        while (true) {
            int plaza = buscarLibre();
            if (plaza != -1) {
                plazas[plaza] = matricula;
                libres--;
                System.out.println("El coche con matricula: " + matricula + " aparca en la plaza " + plaza);
                notifyAll();
                return plaza;
            }
            try {
                wait(); // si no hay plaza, espera hasta que alguien salga
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void salir (int matricula, int plaza) {
        plazas[plaza] = 0;
        libres++;

        System.out.println("El coche con matricula: " + matricula + " acaba de salir: " + plaza );
        notifyAll();
    }

    private int buscarLibre() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == 0) return i;
        }
        return -1;
    }


}
