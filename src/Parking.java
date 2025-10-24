public class Parking {
    private final int[] plazas;
    private int libres;
    private final int espera = (int)(Math.random() * (9000 - 3000 + 1)) + 3000;

    public Parking(int capacidad) {
        this.plazas = new int[capacidad];
        this.libres = capacidad;
    }

    public synchronized int aparcar(int matricula) {

        while (libres == 0) {
            try {
                wait(espera);
            } catch (InterruptedException e) {
                System.out.println("Error al aparcar: " + e.getMessage());
            }
        }
        int plaza = buscarLibre();
        plazas[plaza] = matricula;
        libres--;

        System.out.println("El coche con matricula: " + matricula + " acaba de aparcar en la plaza " + plazas[plaza] );

        notifyAll();
        return plaza;
    }

    public synchronized void salir (int matricula, int plaza) {
        while (plazas[plaza] != matricula){
            try {
                wait(espera);
            } catch (InterruptedException e) {
                System.out.println("Error en salir: " + e.getMessage());
            }
        }
        plazas[plaza] = 0;
        libres++;
        System.out.println("El coche con matricula: " + matricula + " acaba de salir: " + plazas[plaza] );
        notifyAll();

    }

    private int buscarLibre() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == 0) return i;
        }
        return -1;
    }


}
