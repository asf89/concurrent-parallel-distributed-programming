package contador.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Contador extends Thread {
    private ReentrantLock lock = new ReentrantLock();
    private int valor = 0;

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                int currentValue = valor;
                valor++;
                String nome = Thread.currentThread().getName();
                System.out.println(nome + ": " + currentValue);
            } finally {
                lock.unlock();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}