package produttoreConsumatore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci la dimensione del buffer: ");
        int N = scanner.nextInt();
        //T non viene usata verranno creati solo un thread consumatore e uno produttore
        System.out.print("Inserisci il numero di thread da creare: ");
        int T = scanner.nextInt();

        Buffer buffer = new Buffer(N);

        Produttore produttore = new Produttore(buffer);
        Consumatore consumatore = new Consumatore(buffer);

        new Thread(produttore).start();
        new Thread(consumatore).start();

        scanner.close();
    }
}
