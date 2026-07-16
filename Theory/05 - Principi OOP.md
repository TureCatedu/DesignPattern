### 1. Ereditarietà e Riuso del Codice

L'ereditarietà è un paradigma fondamentale dell'OOP che permette di evitare la proliferazione e la duplicazione del codice. Consente di definire una nuova classe (sottoclasse) basandosi su una esistente (superclasse), ereditandone attributi e metodi, senza dover modificare il codice originale funzionante.

* **Visibilità:** La sottoclasse eredita ciò che è `public` (visibile a tutti) e `protected` (visibile alle sottoclassi). Gli attributi e i metodi `private` della classe padre restano inaccessibili direttamente dalla sottoclasse.
* **In Java (keyword `extends`):** Una sottoclasse può aggiungere nuovi metodi e attributi, oppure ridefinire il comportamento dei metodi ereditati tramite l'operazione di **override**. Non può, tuttavia, eliminare i metodi o gli attributi ereditati. L'istruzione `super` permette alla sottoclasse di richiamare esplicitamente i metodi della superclasse.

### 2. I Record (in Java)

I `Record` sono una tipologia di classe speciale introdotta in Java, pensata specificamente per mantenere tracce di dati immutabili.

* **Caratteristiche:** Implementano in modo automatico e conciso il costruttore (che assegna tutti i campi) e i metodi *getter*.
* **Immutabilità:** Non possiedono metodi *setter*, in quanto i campi sono costanti (`final`).
* **Vincoli:** I Record sono `final`, quindi non possono essere estesi da altre classi (non supportano l'ereditarietà), ma possono implementare interfacce. Possono avere metodi statici e di istanza.

### 3. Interfacce

Le interfacce servono a definire un tipo e un "contratto" di comportamento, senza fornire l'implementazione pratica dei metodi.

* **Caratteristiche:** Contengono solo le firme (signature) di metodi pubblici e attributi statici/costanti. Non hanno costruttori e non possono essere istanziate.
* **In Java (keyword `implements`):** Le classi che implementano un'interfaccia sono obbligate a fornire il codice per tutti i metodi in essa dichiarati. Questo disaccoppia il codice: i "client" interagiscono con l'interfaccia senza preoccuparsi di come la classe specifica svolga il lavoro.

### 4. Classi Astratte

Una classe astratta (`abstract`) è una via di mezzo tra una classe concreta e un'interfaccia: è implementata solo parzialmente.

* **Caratteristiche:** Può contenere sia metodi normalmente implementati, sia metodi definiti come `abstract` (ovvero privi di corpo/implementazione). Non può essere istanziata direttamente.
* **Vincolo:** Costringe le sottoclassi concrete che la ereditano a implementare obbligatoriamente tutti i metodi astratti.

### 5. Compatibilità fra Tipi (Sottotipazione)

A prescindere che si erediti da una classe astratta, da un'interfaccia o da una classe concreta, **una sottoclasse è un sottotipo compatibile con la superclasse**.

* **Regola d'uso:** È possibile utilizzare un'istanza della sottoclasse ovunque sia richiesto il tipo della superclasse (es. `Persona p = new Studente();`). Non vale il contrario.
* **Tipi a Compile-time vs Run-time:** A tempo di compilazione, il tipo della variabile (es. `Persona`) decide *quali* metodi possono essere chiamati. A tempo di esecuzione (run-time), l'oggetto reale (es. `Studente`) determina il comportamento effettivo.
* **Cast:** Si può forzare una variabile superclasse in una variabile sottoclasse (es. `Studente s = (Studente) p;`), ma a run-time funzionerà solo se l'oggetto puntato è effettivamente di quel sottotipo, altrimenti genererà un errore (`ClassCastException`).

### 6. Polimorfismo e Late Binding

Il **Polimorfismo** è la capacità di metodi con lo stesso nome e la stessa firma (in classi diverse) di assumere comportamenti differenti in base all'oggetto che li invoca.

* **Late Binding (Collegamento tardivo):** Poiché una variabile (es. `Persona`) può puntare a istanze di sottoclassi diverse (es. `Studente` o `Lavoratore`), il compilatore non può sapere in anticipo quale versione di un metodo ridefinito (`override`) verrà eseguita. La decisione viene presa dinamicamente a run-time in base al tipo effettivo dell'oggetto istanziato.

### 7. Dispatch (Risoluzione dinamica del metodo)

Il *dispatch* è il meccanismo con cui il sistema, a run-time, decide quale implementazione del metodo eseguire:

1. Quando un metodo viene chiamato, il sistema controlla il tipo reale dell'oggetto a run-time.
2. Cerca l'implementazione del metodo in quella specifica classe.
3. Se non la trova, "risale" la gerarchia delle classi (verso le superclassi) finché non incontra la prima implementazione utile da eseguire.

### 8. Digressione: Diagrammi UML di Sequenza

*(Dettaglio integrativo dalle slide per contestualizzare le chiamate ai metodi)*:
Per rappresentare visivamente il late binding e l'interazione tra oggetti, si usano i Diagrammi di Sequenza UML. Il tempo scorre verticalmente verso il basso. Gli oggetti sono posti in alto e possiedono una "linea della vita" tratteggiata. Quando un oggetto è attivo (esegue un metodo), si disegna un rettangolo (barra di attivazione). Le chiamate ai metodi sono rappresentate da frecce orizzontali piene tra le barre di attivazione.