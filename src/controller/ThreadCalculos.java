package controller;

import java.util.concurrent.Semaphore;

public class ThreadCalculos extends Thread {

	private int id;
	private static double res;
	private Semaphore semaforo;

	public ThreadCalculos(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			calc();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void calc() {
		res = 0.0d;
		if (id % 2 == 0) {
			for (double i = 1; i <= 10; i++) {
				res = res + id * i;
				System.out.println(res);
			}
		} else {
			for (double i = 1; i <= 10; i++) {
				res = res + id / i;
				System.out.println(res);
			}
		}
	}

}
