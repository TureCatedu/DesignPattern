package components;

/**
 * Concrete Product B1: Implementazione della checkbox in stile Windows.
 */
public class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering di una checkbox in stile Windows.");
    }
}