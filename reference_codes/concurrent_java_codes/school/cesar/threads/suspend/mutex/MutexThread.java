package school.cesar.threads.suspend.mutex;

import java.util.concurrent.TimeUnit;

public class MutexThread extends Thread {

    private Object mutex = new Object();

    public MutexThread(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ": Thread filha rodando!");

        synchronized(mutex) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getId() + ": Thread filha encerrada. Notificando...");
            mutex.notify();
        }
    }

}