package produttoreConsumatore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Inserisci il numero di consumatori da creare: ");
        int C = scanner.nextInt();

        Buffer buffer = new Buffer(5);
        Produttore produttore = new Produttore(buffer);
        for (int i = 0; i < C; i++) {
            Consumatore consumatore = new Consumatore(buffer);
            // Avvio i thread del consumatore
            new Thread(consumatore).start();
        }
        new Thread(produttore).start();

        scanner.close();
    }
}
