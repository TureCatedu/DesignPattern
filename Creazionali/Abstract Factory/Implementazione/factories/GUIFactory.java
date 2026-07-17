package factories;

import components.Button;
import components.Checkbox;

/**
 * Abstract Factory: Dichiarazione dei metodi di creazione per i prodotti astratti.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}