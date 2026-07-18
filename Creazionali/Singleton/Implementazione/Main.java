/*
* Client: simula un ambiente multi-thread in cui diverse parti
* dell'applicazione tentano di creare la connessione al database contemporaneamente.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Avvio dei thread...");
        System.out.println("Se vedi lo stesso valore di connessione per entrambi i thread, il Singleton ha funzionato.");
        System.out.println("Se vedi valori diversi, l'implementazione non è thread-safe.\n");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            // Tenta di inizializzare il singleton con il DB_FOO
            DatabaseConnection db = DatabaseConnection.getInstance("jdbc:postgresql://localhost/DB_FOO");
            db.query("SELECT * FROM users");
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            // Tenta di inizializzare il Singleton con il DB_BAR
            DatabaseConnection db = DatabaseConnection.getInstance("jdbc:postgresql://localhost/DB_BAR");
            db.query("SELECT * FROM orders");
        }
    }
}