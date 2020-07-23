package contadoratomic;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PublicContador extends Thread {
    private AtomicInteger valor = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            int currentValue = valor.getAndIncrement();

            // Nome dado à thread
            String nome = Thread.currentThread().getName();

            System.out.println(nome + ": " + currentValue);

            try {
                TimeUnit.SECONDS.sleep(1);            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}