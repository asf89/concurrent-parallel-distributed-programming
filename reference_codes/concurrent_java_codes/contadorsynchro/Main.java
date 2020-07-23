package contadorsynchro;

public class Main {
    public static void main(String[] args) {
        Contsync cont = new Contsync();
        Thread cont1 = new Thread(cont, "Jorge");
        Thread cont2 = new Thread(cont, "Marcos");
        Thread cont3 = new Thread(cont, "Felipe");

        cont1.start();
        cont2.start();
        cont3.start();
    }
}