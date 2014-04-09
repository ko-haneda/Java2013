package ch14.ex14_06;

public class MyThread extends Thread {
	private long start = 0;
	private long current = 0;
	private long exeTime = 0;

	private synchronized void showMessage(String message, long interval) {
		while (true) {
			long last = System.currentTimeMillis();
			System.out.println(last);
			System.out.println(current);
			while (current - last < interval)
				try {
					wait();
				} catch (InterruptedException e) {
					return;
				}
			System.out.println(message);
		}
	}

	private void showTime(final long interval) {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				return;
			}
			synchronized (this) {
				current = System.currentTimeMillis();
				exeTime = current - start;
				System.out.println(Thread.currentThread().getName() + "\t"
						+ exeTime / 1000 + " sec");
				notifyAll();
			}
		}
	}

	public void run() {
		start = current = System.currentTimeMillis();
		exeTime = current - start;
		showMessage("aaaa", 15000);
//		showMessage("bbbb", 7000);
		showTime(1000);
	}

}
