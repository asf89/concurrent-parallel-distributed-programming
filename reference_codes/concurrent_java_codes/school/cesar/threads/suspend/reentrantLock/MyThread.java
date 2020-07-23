package school.cesar.threads.suspend.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
    private ReentrantLock lock = new ReentrantLock();

    public MyThread(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ": Thread filha iniciada");
        lock.lock();

        try {
            TimeUnit.SECONDS.sleep(5);            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getId() + ": Thread filha encerrada, notificando...");
        lock.notify();
        lock.unlock();
    }
}