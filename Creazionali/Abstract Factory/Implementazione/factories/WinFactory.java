package factories;

import components.Button;
import components.Checkbox;
import components.WinButton;
import components.WinCheckbox;

/**
 * Concrete Factory 1: Produce componenti grafici compatibili con Windows.
 */
public class WinFactory implements GUIFactory {
    @Override
    public String toString() {
        return "Windows Factory";
    }

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}