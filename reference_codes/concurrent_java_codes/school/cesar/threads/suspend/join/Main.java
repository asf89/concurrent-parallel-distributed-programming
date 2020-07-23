package school.cesar.threads.suspend.join;

public class Main {
    public static void main(String[] args) {
        MinhaThread tr = new MinhaThread("Joaquim");

        System.out.println("Thread principal iniciou");

        tr.start();

        /* Para rodar a thread main (principal)
        tr.run();
        */

        try {
            tr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread principal terminou");
    }
    


}