package components;

/**
 * Concrete Product A2: Implementazione del pulsante in stile macOS.
 */
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering di un pulsante in stile macOS.");
    }
}