package factories;

import components.Button;
import components.Checkbox;
import components.MacButton;
import components.MacCheckbox;

/**
 * Concrete Factory 2: Produce componenti grafici compatibili con macOS.
 */
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}