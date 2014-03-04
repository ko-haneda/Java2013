package ex14_03;

public class ex14_3 {
	
	//できているようでできていない。　あとで見直し。
	public static void main(String[] args) {

		MyThread[] thread = new MyThread[5];

		for (int i = 0; i < 5; i++) {
			thread[i] = new MyThread();
			thread[i].start();
		}

	}
}
