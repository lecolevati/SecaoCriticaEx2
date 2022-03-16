package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCalculos;

public class Principal {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int i = 2 ; i < 4 ; i++) {
			Thread t = new ThreadCalculos(i, semaforo);
			t.start();
		}
		
	}

}
