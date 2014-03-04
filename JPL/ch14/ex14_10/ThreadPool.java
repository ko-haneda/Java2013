package ex14_10;

import java.util.*;

public class ThreadPool {
	private boolean online = false;
	private LinkedList<Runnable> queue;
	private int queueSize;
	private Thread[] threads;

	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		this.queueSize = queueSize;
		this.queue = new LinkedList<Runnable>();
		this.threads = new Thread[numberOfThreads];
	}

	public void start() {
		if (online) throw new IllegalStateException();
		online = true;
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					while (true) {
						Runnable r;
						synchronized (ThreadPool.this) {
							while (queue.isEmpty()) {
								try {
									ThreadPool.this.wait();
									if (!online)	return;
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							r = queue.remove();
							ThreadPool.this.notifyAll();
						}
						r.run();
					}
				}
			});
			threads[i].start();
		}
	}
	
	public void stop() {
		if (!online) 	throw new IllegalStateException();
		online = false;
		for (Thread thread : threads) {
			while (thread.isAlive()) {
				synchronized (this) {
					notifyAll();
				}
			}
		}
	}

	public synchronized void dispatch(Runnable runnable) {
		System.out.println("dispatch1");
		if (runnable == null) 	throw new NullPointerException();
		if (!online) 			throw new IllegalStateException();
		while (queue.size() > queueSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		queue.add(runnable);
		System.out.println("dispatch2");
		System.out.println(queue.size());
		notifyAll();
	}
}