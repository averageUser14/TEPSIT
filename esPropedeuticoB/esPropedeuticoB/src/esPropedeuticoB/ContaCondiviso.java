package esPropedeuticoB;

public class ContaCondiviso implements Runnable {
	GeneraNumeri valori;
	int max = Integer.MAX_VALUE;
	
	public ContaCondiviso(GeneraNumeri generatore) {
		this.valori = generatore;
	}
	
	public void setLimit(int lim) {
		max = lim; 
	}
	
	public void run() {
		int i = valori.numero();
		while(i<=max) {
			System.out.println(i);
			i = valori.numero();
		}
	}
}
