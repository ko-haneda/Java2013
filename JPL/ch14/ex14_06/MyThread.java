package ch14.ex14_06;

public class MyThread extends Thread {
	private int count = 0;
	private long seconds;	//何秒待つか。
	private String message;
	private MyTimerThread timer;
	
	MyThread(long seconds, String message, MyTimerThread timer){
		this.seconds = seconds;
		this.message = message;
		this.timer   = timer;
	}
	
	public void run() {
		synchronized (timer) {
			while(true){
				try {
					timer.wait();
					count++;
					if(count % seconds == 0){
						System.out.println(message + " " + String.format("%1$3d", count) + "秒　" + message);
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

}