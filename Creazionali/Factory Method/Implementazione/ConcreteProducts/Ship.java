package ConcreteProducts;

import Products.*;

/**
 * Prodotto Concreto: fornisce un'implementazione specifica per il trasporto via mare.
 */
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Consegna via mare in un container su una nave cargo.");
    }
}