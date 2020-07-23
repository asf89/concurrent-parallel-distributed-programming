package school.cesar.sd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            RandomNumberGenerator printer = new RandomNumberGenerator(client);
            Thread thread = new Thread(printer);
            thread.start();
        }
    }
}