package ConcreteCreator;

import ConcreteProducts.*;
import Creator.*;
import Products.*;

/**
 * Concrete Creator: sovrascrive il factory method per creare un Truck.
 */
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}