package school.cesar.threads.suspend.mutex;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": Main thread iniciada");

        Object mutex = new Object();

        MutexThread tr = new MutexThread(mutex);

        tr.start();

        synchronized(mutex) {
            try {
                String id = Thread.currentThread().getName();
                System.out.println(id + ": Main thread esperando pelo notify.");
                mutex.wait();
                System.out.println(id + ": Main thread recebeu o notify.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}