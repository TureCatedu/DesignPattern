import Creator.Logistics;
import ConcreteCreator.*;

/**
 * Il Client: esegue la logica passando attraverso le classi astratte.
 */
public class Main {
    private static Logistics logistics;

    public static void main(String[] args) {
        configure("sea"); // Cambia tra "road" e "sea" per testare
        runBusinessLogic();
    }

    /**
     * L'applicazione sceglie un creatore concreto in base alla configurazione o all'ambiente.
     */
    static void configure(String type) {
        if (type.equalsIgnoreCase("sea")) {
            logistics = new SeaLogistics();
        } else {
            logistics = new RoadLogistics();
        }
    }

    /**
     * Tutta la logica client funziona con il creatore astratto (Logistics).
     */
    static void runBusinessLogic() {
        logistics.planDelivery();
    }
}