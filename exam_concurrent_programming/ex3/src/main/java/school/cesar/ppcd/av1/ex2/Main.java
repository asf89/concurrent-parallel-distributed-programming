package school.cesar.ppcd.av1.ex2;

public class Main {
	public static void main(String[] args) {
		
		Object mutexThread = new Object();
		FakeLongTask fakeLongTask = new FakeLongTask(mutexThread);		
		Thread threadFakeLongTask = new Thread(fakeLongTask);

		threadFakeLongTask.start();

		synchronized (mutexThread) {

			while (!fakeLongTask.isDone()) {
				
				try {
					System.out.println("waiting for the notify...");
					mutexThread.wait();
					System.out.println("notify received.");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}

			
			System.out.println("done!");

		}
		
	}
}
