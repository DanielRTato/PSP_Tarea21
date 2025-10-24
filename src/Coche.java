import java.util.Random;

public class Coche extends Thread{
    private final int matricula;
    private final Parking parking;
    private final int espera = (int)(Math.random() * (9000 - 3000 + 1)) + 3000;


    public Coche(int matricula, Parking parking) {
        this.matricula = matricula;
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            int plaza = parking.aparcar(matricula);

            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                System.out.println("Error en el run: " + e.getMessage());
            }

            parking.salir(matricula, plaza);

            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                System.out.println("Error en el run: " + e.getMessage());

            }
        }

        }
    }

