package ConcreteProducts;

import Products.*;
/**
 * Prodotto Concreto: fornisce un'implementazione specifica per il trasporto via terra.
 */
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Consegna via terra in un container su un camion.");
    }
}