package contadorsynchro;

import java.util.concurrent.TimeUnit;

public class Contsync extends Thread {
    private int valor = 0;

    private synchronized int getAndIncrement() {
        int valorAtual = valor;
        valor++;
        return valorAtual;
    }

    @Override
    public void run() {
        while (true) {

            int currentValue = getAndIncrement();

            // Nome dado à thread
            String nome = Thread.currentThread().getName();

            System.out.println(nome + ": " + currentValue);

            try {
                TimeUnit.SECONDS.sleep(1);            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}