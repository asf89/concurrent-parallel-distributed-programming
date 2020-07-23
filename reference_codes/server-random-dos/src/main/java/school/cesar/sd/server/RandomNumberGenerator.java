package school.cesar.sd.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class RandomNumberGenerator implements Runnable {
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Random random;
    public RandomNumberGenerator(Socket socket) throws IOException {
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.random = new Random();
    }


    public void run() {
        try {
            while (true) {
                int count = dataInputStream.readInt();
                for (int i=0;i<count;i++) {
                    this.dataOutputStream.writeInt(this.random.nextInt());
                    this.dataOutputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}