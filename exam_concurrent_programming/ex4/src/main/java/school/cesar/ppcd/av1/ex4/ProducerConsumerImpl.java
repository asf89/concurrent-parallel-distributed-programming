package school.cesar.ppcd.av1.ex4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerImpl implements ProducerConsumer {

	private static ArrayBlockingQueue<SomeRequest> buffer = new ArrayBlockingQueue<SomeRequest>(2);
	

	public synchronized void produce(SomeRequest request) {		
		

		while (buffer.size() != 2) {

			try {
				buffer.put(request);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			System.out.println("Added to buffer. Buffer size: " + buffer.size());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
				
		
	}

	public synchronized SomeRequest consume() {

		SomeRequest value = new SomeRequest();

		
		while (buffer.size() != 0) {

			try {
				value = buffer.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Removed from buffer. Buffer size: " + buffer.size());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}		
		
		return value;
	}

}
