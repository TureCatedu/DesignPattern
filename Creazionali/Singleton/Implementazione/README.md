# Implementazione Java: Singleton

## Scenario
Implementazione di una **Connessione al Database**. Aprire una connessione è un'operazione costosa; per questo motivo, ci assicuriamo che in tutta l'applicazione (anche in presenza di più thread) venga creata una e una sola istanza della classe `DatabaseConnection`.

## Struttura Specifica (UML delle Classi)
```mermaid
classDiagram
    class DatabaseConnection {
        -static volatile instance : DatabaseConnection
        -connectionString : String
        -DatabaseConnection(connectionString: String)
        +static getInstance(connectionString: String) DatabaseConnection
        +query(sql: String) void
    }

    class App {
        +main(args: String[]) void
    }

    App --> DatabaseConnection : "getInstance()"
```

## Diagramma di Sequenza
Il diagramma mostra cosa succede quando due Thread tentano di ottenere contemporaneamente l'istanza del database, illustrando il comportamento del Double-Checked Locking.
```mermaid
sequenceDiagram
    participant Thread1
    participant Thread2
    participant SingletonClass as DatabaseConnection (Classe)
    participant Instance as DatabaseConnection (Istanza)

    Thread1->>SingletonClass: getInstance("FOO_DB")
    Thread2->>SingletonClass: getInstance("BAR_DB")
    
    activate SingletonClass
    Note over SingletonClass: Primo controllo (instance == null)
    SingletonClass->>SingletonClass: Thread 1 acquisisce il lock (synchronized)
    
    Note over SingletonClass: Secondo controllo (instance == null)
    SingletonClass->>Instance: new DatabaseConnection("FOO_DB")
    Instance-->>SingletonClass: return istanza
    SingletonClass-->>Thread1: return istanza (FOO_DB)
    deactivate SingletonClass

    activate SingletonClass
    SingletonClass->>SingletonClass: Thread 2 acquisisce il lock (synchronized)
    Note over SingletonClass: Secondo controllo (instance != null)
    SingletonClass-->>Thread2: return istanza (FOO_DB)
    deactivate SingletonClass

    Thread1->>Instance: query("SELECT *")
    Thread2->>Instance: query("SELECT *")
```

## Spiegazione dell'Implementazione (Thread-Safe)
L'implementazione in Java, specialmente in contesti multi-thread, richiede alcune accortezze particolari, adottando la tecnica del **Double-Checked Locking** (blocco a doppio controllo):
1.  **Variabile `volatile`:** L'istanza statica privata `instance` viene dichiarata `volatile`.
2.  **Costruttore privato:** Il costruttore è privato per inibire l'istanziazione diretta.
3.  **Metodo `getInstance()`:** Esegue i due controlli per evitare la sovrascrittura in multithreading come mostrato nel diagramma di sequenza.
