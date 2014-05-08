package ch14.ex14_08;

/* ①（教科書の場合）
 *   ノートPC　　:10回に1回の頻度でデッドロック
 *   デスクトップ :発生しない
 * ②（yieldの追加）
 *   ノートPC　　:20回に1回の頻度でデッドロック
 *   デスクトップ :発生しない
 */

public class ex14_08 {
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {
			public void run() { jareth.hug();}
		}, "Thread1").start();

		new Thread(new Runnable() {
			public void run() {	cory.hug();	}
		}, "Thread2").start();
	}
}