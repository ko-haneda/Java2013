package ch14.ex14_02;

public class PrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();
	public PrintServer() {
		new Thread(this, "PrintServer").start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	public void run() {
		if(Thread.currentThread().getName().equals("PrintServer")){
			System.out.println(Thread.currentThread().getName() + ":実行中");
			System.out.println("");
			for (;;) {
				try {
					realPrint(requests.remove());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			//エラーを投げる。　エラーの種類を探す。
			System.out.print(Thread.currentThread().getName() + "からrun()を呼び出すことはできません。");
			System.out.println("run()を呼び出すことはPrintServer内からしか出来ません。");
			System.out.println("");
		}
		
	}

	private void realPrint(PrintJob job) {
	}
}