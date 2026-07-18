# Abstract Factory

## Descrizione
L'**Abstract Factory** è un design pattern creazionale che fornisce un'interfaccia per creare famiglie di oggetti correlati o dipendenti, senza specificare le loro classi concrete. Consente a un sistema di essere indipendente dalle modalità di creazione, composizione e rappresentazione dei suoi prodotti.

## Motivazione (Uso e Scenario)
Quando un'applicazione deve supportare molteplici varianti di look-and-feel o configurazioni di prodotto, è fondamentale evitare che il codice client sia costellato di blocchi condizionali legati a varianti specifiche. Il pattern centralizza la creazione di queste famiglie di prodotti correlati.

## Struttura Generale (UML concettuale)

``` mermaid
classDiagram
    class AbstractFactory {
        <<interface>>
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }

    class ConcreteFactory1 {
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }

    class ConcreteFactory2 {
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }

    class AbstractProductA {
        <<interface>>
    }
    class ConcreteProductA1
    class ConcreteProductA2

    class AbstractProductB {
        <<interface>>
    }
    class ConcreteProductB1
    class ConcreteProductB2

    class Client {
        -productA AbstractProductA
        -productB AbstractProductB
        +Client(factory AbstractFactory)
    }

    AbstractFactory <|.. ConcreteFactory1
    AbstractFactory <|.. ConcreteFactory2

    AbstractProductA <|.. ConcreteProductA1
    AbstractProductA <|.. ConcreteProductA2

    AbstractProductB <|.. ConcreteProductB1
    AbstractProductB <|.. ConcreteProductB2

    ConcreteFactory1 --> ConcreteProductA1 : "creates"
    ConcreteFactory1 --> ConcreteProductB1 : "creates"
    
    Client --> AbstractFactory
    Client --> AbstractProductA
    Client --> AbstractProductB
```

### Descrizione dei Componenti UML Generali
*   **AbstractFactory:** Definisce un set di metodi per la creazione dei prodotti astratti.
*   **ConcreteFactory:** Implementa le operazioni per istanziare oggetti concreti di una specifica famiglia.
*   **AbstractProduct:** Interfacce o classi astratte che definiscono le operazioni per una tipologia di prodotto.
*   **ConcreteProduct:** Classi specifiche che implementano le interfacce dei prodotti astratti.
*   **Client:** Utilizza unicamente le interfacce esposte, garantendo il totale disaccoppiamento dalle implementazioni concrete.

## Conseguenze
*   **Vantaggi:** Isolamento delle classi concrete, consistenza tra prodotti della stessa famiglia, Single Responsibility Principle e Open/Closed Principle.
*   **Svantaggi:** Aggiungere un nuovo *tipo* di prodotto alla famiglia richiede modifiche all'interfaccia `AbstractFactory` e a tutte le sue implementazioni.