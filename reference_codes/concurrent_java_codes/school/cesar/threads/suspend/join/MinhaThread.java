package school.cesar.threads.suspend.join;

import java.util.concurrent.TimeUnit;

public class MinhaThread extends Thread {

    public MinhaThread() {

    }

    public MinhaThread(String name) {
        this.setName(name);
    }


    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " está rodando!");

        try {
            TimeUnit.SECONDS.sleep(5);            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " finalizada!");
    }
}