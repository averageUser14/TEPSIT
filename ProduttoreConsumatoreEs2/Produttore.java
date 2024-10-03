package produttoreConsumatore;
import java.util.Random;
public class Produttore implements Runnable {
	private Buffer coda;
	private Random random;
	
	public Produttore(Buffer coda){
		this.coda = coda;
		this.random = new Random();
	}
	
	
	public void run(){
		while(true) {
			try {
				int R = random.nextInt(2048)-1024;
				coda.aggiungi(R);
				int delay;
				if(R%2==0) {
					delay =(R/100)*50;
				}else {
					delay =(200);
				}
				Thread.sleep(delay);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
