package school.cesar.ppcd.av1.ex2;

import java.util.concurrent.TimeUnit;

public class Util {
	public static void nap(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
