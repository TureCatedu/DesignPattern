package ConcreteCreator;

import ConcreteProducts.*;
import Creator.*;
import Products.*;

/**
 * Concrete Creator: sovrascrive il factory method per creare una Ship.
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}