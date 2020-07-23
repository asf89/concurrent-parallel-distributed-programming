package school.cesar.sd.client;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class RequestRandomNumber implements Runnable {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private int count;
    public RequestRandomNumber(Socket socket, int count) throws IOException {
        this.dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        this.count = count;
    }

    public void run() {
        try {
            this.dataOutputStream.writeInt(this.count);
            this.dataOutputStream.flush();
            for (int i=0;i<count;i++) {
                System.out.println(this.dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}