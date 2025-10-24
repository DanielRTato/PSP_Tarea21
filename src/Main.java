public class Main {
    public static void main(String[] args) {

        int capacidadParking = 2;
        int cantidadCoches = 11;

        Parking parking = new Parking(capacidadParking);

//        Coche c1 = new Coche(1, parking);
//        Coche c2 = new Coche(2, parking);
//        Coche c3 = new Coche(3, parking);
//        Coche c4 = new Coche(4, parking);
//        Coche c5 = new Coche(5, parking);
//        Coche c6 = new Coche(6, parking);
//        Coche c7 = new Coche(7, parking);
//        Coche c8 = new Coche(8, parking);

        //c1.start(); c2.start(); c3.start(); c4.start(); c5.start(); c6.start(); c7.start(); c8.start();

        for (int i = 0; i < cantidadCoches; i++){
            Coche coche = new Coche(i, parking);
            coche.start();
        }

        }
    }


