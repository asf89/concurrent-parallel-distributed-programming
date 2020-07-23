package school.cesar.ppcd.av1.ex2;

import static school.cesar.ppcd.av1.ex2.Util.nap;

public class FakeLongTask extends Thread implements Runnable {
	private boolean done = false;
	private Object mutexThread = new Object();
	private static final int FIVE_SECONDS = 5;
	
	FakeLongTask(Object mutexThread) {
		this.mutexThread = mutexThread;
	}

	public void run() {

		synchronized (mutexThread) {			
			
			nap(FIVE_SECONDS);
			done = true;
			mutexThread.notify();

		}	
		
	}

	public boolean isDone() {
		return done;
	}
}
