package school.cesar.sd.server;
import java.util.Random;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RandomNumberGenerator implements Runnable {
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Random random;
    public RandomNumberGenerator(Socket socket) throws IOException {
        this.socket = socket;
        //https://docs.oracle.com/javase/7/docs/api/java/io/ObjectInputStream.html#ObjectInputStream%28java.io.InputStream%29
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
        this.random = new Random();
    }


    public void run() {
        try {
            while (true) {
                int count = objectInputStream.readInt();
                for (int i=0;i<count;i++) {
                    this.objectOutputStream.writeInt(this.random.nextInt());
                    this.objectOutputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}