package esPropedeuticoA;

import java.util.Scanner;

public class Main {
	
	public static void conta(int T, int N){
		Thread[] thread = new Thread[T];
		GeneraNumeri generatore = new GeneraNumeri();
		
		for (int i=0; i<thread.length; i++) {
			ContaCondiviso c = new ContaCondiviso(generatore);
			c.setLimit(N);
			thread[i] = new Thread(c);
		}
		for(int i =0; i<thread.length; i++) {
			thread[i].start();
		}
	}


	public static void main(String[] args) {
		int T, N;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numero massimo da contare");
		N = scanner.nextInt();
		System.out.println("Numero thread da creare");
		T = scanner.nextInt();
		
		conta(T, N);
		
		scanner.close();
	}

}
