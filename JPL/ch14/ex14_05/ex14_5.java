package ex14_05;

public class ex14_5 {
	
	public static void main(String[] args) {

		MyThread[] thread = new MyThread[5];

		for (int i = 0; i < 5; i++) {
			thread[i] = new MyThread();
			thread[i].start();
		}

	}
}