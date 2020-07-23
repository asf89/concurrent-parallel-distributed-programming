package school.cesar.sd.client;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class RequestRandomNumber implements Runnable {

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private int count;
    public RequestRandomNumber(Socket socket, int count) throws IOException {
        this.objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        this.objectInputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        this.count = count;
    }

    public void run() {
        try {
            this.objectOutputStream.writeInt(this.count);
            this.objectOutputStream.flush();
            for (int i=0;i<count;i++) {
                System.out.println(this.objectInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}