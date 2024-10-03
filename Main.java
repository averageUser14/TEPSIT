package produttoreConsumatore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedere all'utente di inserire la dimensione del buffer T
        System.out.print("Inserisci la dimensione del buffer: ");
        int N = scanner.nextInt();

        // Chiedere all'utente di inserire il numero di produttori e consumatori N
        System.out.print("Inserisci il numero di produttori e consumatori: ");
        int T = scanner.nextInt();

        // Creare il buffer con dimensione T
        Buffer buffer = new Buffer(N);

        // Creare e avviare N produttori e N consumatori
        for (int i = 0; i < T; i++) {
            Produttore produttore = new Produttore(buffer);
            Consumatore consumatore = new Consumatore(buffer);

            // Avviare i thread del produttore e del consumatore
            new Thread(produttore).start();
            new Thread(consumatore).start();
        }
        scanner.close();
    }
}
