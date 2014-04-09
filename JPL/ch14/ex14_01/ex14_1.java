package ch14.ex14_01;


public class ex14_1 {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread(30);
		MyThread thread2 = new MyThread(50);
		thread1.start();
		thread2.start();
	}
}
