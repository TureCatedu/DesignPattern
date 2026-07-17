/**
 * Classe Singleton che simula la connessione a un database.
 * Utilizza la tecnica del Double-Checked Locking per essere Thread-Safe.
 */
public class Singleton {
    // La keyword 'volatile' assicura che i thread gestiscano correttamente 
    // l'istanza durante l'inizializzazione in ambienti multi-thread.
    private static volatile Singleton instance;
    
    private String connectionString;

    // Il costruttore privato impedisce l'uso dell'operatore 'new' da parte del client
    private Singleton(String connectionString) {
        // Simulazione di un'operazione lenta di connessione
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.connectionString = connectionString;
    }

    /**
     * Metodo statico che controlla l'accesso all'istanza del Singleton.
     */
    public static Singleton getInstance(String connectionString) {
        // Primo controllo (senza lock) per migliorare le prestazioni
        if (instance == null) {
            // Lock sulla classe, solo il primo thread entra qui
            synchronized (Singleton.class) {
                // Secondo controllo (con lock) per sicurezza: un altro thread
                // potrebbe aver inizializzato l'istanza mentre questo attendeva il lock
                if (instance == null) {
                    instance = new Singleton(connectionString);
                }
            }
        }
        return instance;
    }

    // Un metodo di logica di business tipico di questa classe
    public void query(String sql) {
        System.out.println("Esecuzione query: '" + sql + "' sul database connesso a: " + this.connectionString);
    }
}
