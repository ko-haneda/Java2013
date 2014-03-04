package ex14_08;

public class ex14_8 {

	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {
			public void run() {
				jareth.hug();
			}
		}, "Thread1").start();

		new Thread(new Runnable() {
			public void run() {
				cory.hug();
			}
		}, "Thread2").start();
	}
}