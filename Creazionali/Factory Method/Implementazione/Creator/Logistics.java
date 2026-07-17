package Creator;

import Products.*;

/**
 * Creator: la classe astratta che definisce il Factory Method.
 * Contiene anche la logica di business che si affida agli oggetti creati.
 */
public abstract class Logistics {
    
    // La logica di business principale usa i prodotti creati dal factory method
    public void planDelivery() {
        System.out.println("Logistics: Sto pianificando la consegna...");
        Transport transport = createTransport();
        transport.deliver();
    }

    // Il Factory Method astratto
    public abstract Transport createTransport();
}