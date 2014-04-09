package ch14.ex14_03;

public class MyThread extends Thread {
	private static int sum = 0;
	
	public static synchronized void add() {
		sum++;
		System.out.println(Thread.currentThread().getName() + " " + sum);
	}
	
	public void run() {
		for (int i = 0; i < 10000; i++) {
			add();
		}
	}
}
