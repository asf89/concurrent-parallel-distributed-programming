package school.cesar.sd.client;
import java.net.Socket;
public class Main {
    public static void main(String[] args) throws Exception {
        int count = 3;
        Socket s = new Socket("127.0.0.1", 8888);
        Runnable request = new RequestRandomNumber(s, count);
        Thread t1 = new Thread(request);
        t1.start();
        t1.join();
    }
}