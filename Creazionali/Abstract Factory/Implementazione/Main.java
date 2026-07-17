import components.Button;
import components.Checkbox;
import factories.GUIFactory;
import factories.MacFactory;
import factories.WinFactory;

/**
 * Client: Utilizza esclusivamente le interfacce dichiarate dall'Abstract Factory
 * e dai prodotti astratti, rimanendo disaccoppiato dalle implementazioni concrete.
 */
public class Main {
    private final Button button;
    private final Checkbox checkbox;

    // Il client accetta qualsiasi factory che implementi l'interfaccia astratta
    public Main(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        
        // Simulazione di una logica di configurazione a runtime (es. basata sul sistema operativo)
        String osName = System.getProperty("os.name").toLowerCase();
        
        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WinFactory();
        }

        // Il codice client funziona immutato a prescindere dalla factory passata
        Main main = new Main(factory);
        main.render();
    }
}