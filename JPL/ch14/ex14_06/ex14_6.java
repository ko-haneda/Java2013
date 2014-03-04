package ex14_06;

public class ex14_6 {
	
	//できていない。　あとで見直し
	public static void main(String[] args) {

		MyThread[] thread = new MyThread[2];

		for (int i = 0; i < 2; i++) {
			thread[i] = new MyThread();
			try {
				thread[i].sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread[i].start();
		}

	}
}