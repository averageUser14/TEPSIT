package esPropedeuticoB;

public class GeneraNumeri {
	int valore;
	
	public GeneraNumeri() {
		valore =0;
	}
	
	public synchronized int numero() {
		int x = valore;
		valore++;
		return x;
	}
}
