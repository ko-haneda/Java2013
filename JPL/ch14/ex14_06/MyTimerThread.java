package ch14.ex14_06;

public class MyTimerThread extends Thread {

	public synchronized void run() {
		while(true){
			try {
				wait(100);
				notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}