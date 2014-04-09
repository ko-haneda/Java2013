package ch14.ex14_01;

public class MyThread extends Thread{
	private int delay;

	public MyThread() {
		delay = 10;
	}

	MyThread(int delay) {
		this.delay = delay;
	}

	public void run() {
		try {
			for (int i = 0; i < 10000; i++) {
				System.out.print(Thread.currentThread().getName() + "  ");
				if(i % 100 == 0)	System.out.println();
			}
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			return ;
		}
	}
}
