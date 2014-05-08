package ch14.ex14_06;

public class ex14_06 {

	public static void main(String[] args) {

		MyTimerThread timer = new MyTimerThread();
		MyThread[] thread = new MyThread[2];

		thread[0] = new MyThread(15, "□□□□□□□□□□□", timer);
		thread[1] = new MyThread(7,  "■■■■■■■■■■■", timer);
		timer.start();
		thread[0].start();
		thread[1].start();

	}
}