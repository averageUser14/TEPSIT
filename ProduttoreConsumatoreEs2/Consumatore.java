package produttoreConsumatore;

public class Consumatore implements Runnable{
	private Buffer coda;
	private int media;
	private int negativi;
	private int []arr;
	private int tot;
	private int indexArr;
	
	public Consumatore(Buffer coda) {
		media=0;
		negativi=0;
		this.coda = coda;
		arr=new int[5];
		tot=0;
		indexArr=0;
	}
	public void run() {
		while(true) {
			int num = coda.consuma();
			System.out.println("Consumato: " + num);
			System.out.println(" Negativi: " + contaNegativi(num)+" Media ultimi 5 positivi: " + positivi(num));
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
			}
		}
		
	}
	
	public int positivi(int num){
		if(num>=0 && indexArr<5) {
//			se il nuovo numero nel buffer e' positivo e l'indice 
//			dell'array e' <5 aggiungo elemento all'array
//			problema: io faccio la media anche se non sono stati caricati 5 valori positivi nel buffer
			arr[indexArr]=num;
			indexArr++;
			contaMedia();
		}
		if(num>=0 && indexArr>=5) {
//			se il nuovo numero nel buffer e' positivo e l'indice 
//			dell'array e' >4 sostituisco il valore dell'array meno recente
			indexArr=0;
			arr[indexArr]=num;
			indexArr++;
			contaMedia();
		}
		return media;
	}
	public int contaMedia() {
		reset();
			for(int i=0;i<5;i++) {
				tot=tot+arr[i];
			}
			media=tot/5;
		
		return media;
	}
	public int contaNegativi(int num) {
		if(num<0) {
			negativi++;
		}
		return negativi;
	}
	private void reset() {
		media=0;
		tot=0;
	}
}
