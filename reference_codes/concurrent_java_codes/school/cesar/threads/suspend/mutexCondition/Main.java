package school.cesar.threads.suspend.mutexCondition;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": Main thread iniciada");

        Object mutex = new Object();

        MutexCondition tr = new MutexCondition(mutex);

        tr.start();

        synchronized(mutex) {

            while (tr.getCondition()) {
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

        System.out.println(Thread.currentThread().getName() + ": main thread encerrada.");
    }
}