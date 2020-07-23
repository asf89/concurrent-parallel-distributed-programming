package school.cesar.threads.suspend.mutexCondition;

import java.util.concurrent.TimeUnit;

public class MutexCondition extends Thread {

    private Object mutex = new Object();
    private boolean condition = false;

    public MutexCondition(Object mutex) {
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

            condition = true;
            System.out.println(Thread.currentThread().getId() + ": Thread filha encerrada. Notificando...");
            mutex.notify();
        }
    }

    public boolean getCondition() {
        return condition;
    }

}