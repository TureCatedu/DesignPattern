package components;

/**
 * Concrete Product A1: Implementazione del pulsante in stile Windows.
 */
public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering di un pulsante in stile Windows.");
    }
}