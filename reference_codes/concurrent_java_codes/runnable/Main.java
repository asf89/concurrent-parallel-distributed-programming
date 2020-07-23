package runnable;

public class Main {
    public static void main(String[] args) {
        MyRunnable runner = new MyRunnable();
        Thread tr = new Thread(runner);
        Thread tr2 = new Thread(new MyRunnable());

        //Roda a thread separadamente
        tr.start();

        //Rodando na Thread pai, o próprio Main
        tr2.run();
    }
}