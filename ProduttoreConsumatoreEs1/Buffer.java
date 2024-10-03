package produttoreConsumatore;
import java.util.LinkedList;
public class Buffer {
	LinkedList<Integer> coda;
	private int sizeBuffer;
	
	public Buffer(int sizeBuffer) {
		coda=new LinkedList<>();
		this.sizeBuffer=sizeBuffer;
	}
	public boolean isEmpty(){
		return coda.isEmpty();
	}
	public boolean isFull(){
		return coda.size() >= sizeBuffer;
		
	}
	public synchronized void aggiungi(int num) {
		while(isFull()) {
			try {
				wait();
			}catch(InterruptedException e) {
			}
		}
		//coda non piena
		coda.addFirst(num);
		notifyAll();
	}
	public synchronized int consuma() {
		while(isEmpty()) {
			try {
				wait();
			}catch(InterruptedException e) {
			}
		}
		//coda piena 
		int num = coda.removeLast();
		notifyAll();
		return num;
	}
	
}
