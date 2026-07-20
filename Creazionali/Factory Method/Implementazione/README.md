# Implementazione Java: Factory Method

## Scenario
Software per la gestione della **Logistica**. Inizialmente supporta solo trasporti su strada (camion). Viene richiesta l'integrazione del trasporto navale. Il Factory Method delega la creazione del mezzo di trasporto alla logistica specifica (Via terra o Via mare).

## Struttura Specifica (UML delle Classi)
```mermaid
classDiagram
    class Logistics {
        <<abstract>>
        +planDelivery() void
        +createTransport()* Transport
    }
    class RoadLogistics
    class SeaLogistics

    class Transport {
        <<interface>>
        +deliver() void
    }
    class Truck
    class Ship

    Logistics <|-- RoadLogistics
    Logistics <|-- SeaLogistics
    Transport <|.. Truck
    Transport <|.. Ship
    RoadLogistics --> Truck : "creates"
    SeaLogistics --> Ship : "creates"
    Logistics --> Transport : "uses"
```

## Diagramma di Sequenza
Questo diagramma illustra il flusso di esecuzione quando si avvia una spedizione navale: la classe base delega la creazione alla sottoclasse e poi usa il prodotto.
```mermaid
sequenceDiagram
    participant Main as App (main)
    participant Creator as SeaLogistics
    participant Product as Ship

    Main->>Creator: istanzia SeaLogistics()
    Main->>Creator: planDelivery()
    
    activate Creator
    Creator->>Creator: createTransport()
    activate Creator
    Creator->>Product: new Ship()
    Product-->>Creator: return istanza Ship
    deactivate Creator
    
    Creator->>Product: deliver()
    Product-->>Creator: stampa su console
    Creator-->>Main: stampa su console
    deactivate Creator
```

## Spiegazione dell'Implementazione
1.  **Product:** Interfaccia `Transport` con metodo `deliver()`.
2.  **Creator:** Classe base `Logistics` che implementa `planDelivery()` usando il metodo astratto `createTransport()`.
3.  **Sottoclassi:** `RoadLogistics` restituisce un `Truck`, `SeaLogistics` restituisce un `Ship`. A runtime, si usa il polimorfismo per eseguire la logica corretta.
