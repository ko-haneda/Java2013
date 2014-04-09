package ch14.ex14_04;

public class MyThread extends Thread {
	private static int sum;
	private static final Object lock = new Object();

	static {
		sum = 0;
	}
	
	public static void add() {
		synchronized(lock){
			int buf = get();
			sum = buf + 1;
			System.out.print(Thread.currentThread().getName() + " " + sum + "  ");
		}
	}

	// 同期指定したメソッド
	public static int get() {
		synchronized(lock){
			return sum;
		}
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			add();
			if(i % 10 == 0)	System.out.println();
		}
	}

}
