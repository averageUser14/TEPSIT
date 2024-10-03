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
				int num = random.nextInt(1024);
				coda.aggiungi(num);
				int delay = random.nextInt(901) + 100;
				Thread.sleep(delay);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
