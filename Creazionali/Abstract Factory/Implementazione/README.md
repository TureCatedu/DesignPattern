# Implementazione Java: Abstract Factory

## Scenario
Toolkit di componenti grafici (UI) multipiattaforma. L'interfaccia deve supportare **Windows** e **macOS**. Mescolare pulsanti Mac con checkbox Windows genererebbe errori visivi. L'Abstract Factory garantisce che venga usata l'intera famiglia stilistica corretta.

## Struttura Specifica (UML)
```mermaid
classDiagram
    class GUIFactory {
        <<interface>>
        +createButton() Button
        +createCheckbox() Checkbox
    }
    class WinFactory
    class MacFactory

    class Button {
        <<interface>>
        +paint() void
    }
    class WinButton
    class MacButton

    class Checkbox {
        <<interface>>
        +paint() void
    }
    class WinCheckbox
    class MacCheckbox

    class App {
        -button Button
        -checkbox Checkbox
        +App(factory GUIFactory)
    }

    GUIFactory <|.. WinFactory
    GUIFactory <|.. MacFactory
    Button <|.. WinButton
    Button <|.. MacButton
    Checkbox <|.. WinCheckbox
    Checkbox <|.. MacCheckbox

    WinFactory --> WinButton : "creates"
    WinFactory --> WinCheckbox : "creates"
    App --> GUIFactory
    App --> Button
    App --> Checkbox
```

## Spiegazione dell'Implementazione
1.  **Astrazioni:** Interfacce per `Button`, `Checkbox` e la fabbrica `GUIFactory`.
2.  **Specializzazione:** Implementazioni concrete (`WinButton`, `WinFactory`, ecc.).
3.  **Iniezione (Dependency Inversion):** Il `main` valuta il sistema operativo a runtime, istanzia l'unica Factory concreta necessaria e la passa al Client (`App`), che lavora solo con interfacce astratte.
