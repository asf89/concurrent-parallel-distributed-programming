package school.cesar.ppcd.av1.ex1.server;

public class Counter {

    private static int currentValue = 0;

    public synchronized int getAndIncrement() {
        int actualValue = currentValue;
        currentValue++;
        return actualValue;
    }
    

}