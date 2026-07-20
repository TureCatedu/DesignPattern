# Implementazione Java: Abstract Factory

## Scenario
Toolkit di componenti grafici (UI) multipiattaforma. L'interfaccia deve supportare **Windows** e **macOS**. Mescolare pulsanti Mac con checkbox Windows genererebbe errori visivi. L'Abstract Factory garantisce che venga usata l'intera famiglia stilistica corretta.

## Struttura Specifica (UML delle Classi)
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
        +render() void
    }

    GUIFactory <|.. WinFactory
    GUIFactory <|.. MacFactory
    Button <|.. WinButton
    Button <|.. MacButton
    Checkbox <|.. WinCheckbox
    Checkbox <|.. MacCheckbox

    WinFactory --> WinButton : "creates"
    WinFactory --> WinCheckbox : "creates"
    MacFactory --> MacButton : "creates"
    MacFactory --> MacCheckbox : "creates"
    App --> GUIFactory
    App --> Button
    App --> Checkbox
```

## Diagramma di Sequenza
Questo diagramma mostra come il Client (`App`) interagisce con la Factory per istanziare i prodotti astratti a runtime (es. ambiente macOS).
```mermaid
sequenceDiagram
    participant Main as main()
    participant Factory as MacFactory
    participant App as App (Client)
    participant Button as MacButton
    participant Checkbox as MacCheckbox

    Main->>Factory: istanzia MacFactory()
    Main->>App: istanzia App(factory)
    
    activate App
    App->>Factory: createButton()
    Factory-->>App: return MacButton
    App->>Factory: createCheckbox()
    Factory-->>App: return MacCheckbox
    deactivate App

    Main->>App: render()
    activate App
    App->>Button: paint()
    App->>Checkbox: paint()
    deactivate App
```

## Spiegazione dell'Implementazione
1.  **Astrazioni:** Interfacce per `Button`, `Checkbox` e la fabbrica `GUIFactory`.
2.  **Specializzazione:** Implementazioni concrete (`WinButton`, `WinFactory`, ecc.).
3.  **Iniezione (Dependency Inversion):** Il `main` valuta il sistema operativo a runtime, istanzia l'unica Factory concreta necessaria e la passa al Client (`App`), che lavora solo con interfacce astratte.
