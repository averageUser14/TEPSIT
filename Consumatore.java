package produttoreConsumatore;

public class Consumatore implements Runnable{
	private Buffer coda;
	private int pari;
	private int dispari;
	
	public Consumatore(Buffer coda) {
		pari=0;
		dispari=0;
		this.coda = coda;
	}
	public void run() {
		while(true) {
			int num = coda.consuma();
			System.out.println("Consumato: " + num);
			System.out.println("Pari: " + contaPari(num) + " Dispari: " + contaDispari(num));
		}
	}
	
	public int contaPari(int num) {
		if(num%2==0) {
			pari++;
		}
		return pari;
	}
	public int contaDispari(int num) {
		if(num%2==1) {
			dispari++;
		}
		return dispari;
	}
}
