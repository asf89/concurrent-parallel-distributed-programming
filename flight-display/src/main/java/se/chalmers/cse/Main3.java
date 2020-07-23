package se.chalmers.cse;
import java.util.concurrent.*;

public class Main3 {

   private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) {

        for (int i = 0; i < 200; i++) {
            d.addRow("AAAAAAAAAA " + i);
            d.addRow("BBBBBBBBBB " + i);
            nap(500);
        }

    // Add a sequence of addRow operations with short random naps.
    

   }

    private static void deleteProc(HighLevelDisplay d) {

        for (int i = 0; i < 200; i++) {
            d.deleteRow(0);
            nap(1500);
        }
	
	// Add a sequence of deletions of row 0 with short random naps.
    }

    public static void main(String [] args) {
	final HighLevelDisplay d = new JDisplay2();

	new Thread () {
	    public void run() {
		addProc(d);
	    }
	}.start();


	new Thread () {
	    public void run() {
		deleteProc(d);
	    }
	}.start();

    }
}