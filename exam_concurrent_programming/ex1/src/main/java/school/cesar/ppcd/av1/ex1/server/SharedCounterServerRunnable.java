package school.cesar.ppcd.av1.ex1.server;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SharedCounterServerRunnable implements Runnable {
	private Socket client;
	private DataInputStream input;
	private DataOutputStream output;
	private Counter counter = new Counter();

	public SharedCounterServerRunnable(Socket client) throws IOException {
		this.client = client;
		this.input = new DataInputStream(client.getInputStream());
		this.output = new DataOutputStream(client.getOutputStream());
	}

	public void run() {		

		while (true) {			

			synchronized (counter) {

				int value = counter.getAndIncrement();
				System.out.println(value);	

				try {
					this.output.writeInt(value);
				} catch (IOException e) {
					e.printStackTrace();
				}				
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}								

			}

		}

	}

}
