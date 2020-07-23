package fundamentos;

public class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("A thread rodou completamente");
    }
}