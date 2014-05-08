package ch14.ex14_09;

public class MyThread extends Thread{

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}

	//２秒で終了
	public synchronized void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}