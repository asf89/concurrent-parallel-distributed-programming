package school.cesar.threads.suspend.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        
        System.out.println(Thread.currentThread().getId() + ": Main thread iniciada");

        ReentrantLock lock = new ReentrantLock();

        MyThread minhaThread = new MyThread(lock);

        minhaThread.start();

        lock.lock();

        try {
            Long id = Thread.currentThread().getId();
            System.out.println(id + ": Main thread esperando pelo notify.");
            lock.wait();
            System.out.println(id + ": Main thread recebeu o notify.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
        System.out.println(Thread.currentThread().getId() + ": Main thread iniciada");
    }
}