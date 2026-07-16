**Principi di "Progettare per Preservare"**
L'obiettivo di una buona progettazione software è creare sistemi flessibili, facilmente manutenibili e riutilizzabili nel tempo, mitigando i problemi derivanti dalle dipendenze del codice. Ecco come affrontare le principali criticità attraverso l'uso dei Design Pattern:

**1. Creazione degli Oggetti (Disaccoppiamento dall'Implementazione)**

* **Il problema:** Istanziare esplicitamente la classe di un oggetto lega il codice a una specifica implementazione piuttosto che a un'interfaccia generale, complicando le modifiche future.


* **La soluzione:** È sempre preferibile delegare la creazione degli oggetti in modo indiretto, favorendo la flessibilità.


* **Pattern utili:** Factory Method, Prototype.



**2. Gestione di Operazioni e Algoritmi**

* **Richieste rigide:** Le dipendenze da operazioni specifiche vincolano il sistema a un unico modo di soddisfare una richiesta. Evitando di inserire queste richieste direttamente nel codice, è possibile modificare a tempo di compilazione (compile-time) o di esecuzione (run-time) il modo in cui verranno gestite.


* *Pattern:* Chain of Responsibility, Command.




* **Algoritmi mutabili:** Gli algoritmi vengono frequentemente ottimizzati, estesi o rimpiazzati durante il ciclo di vita del software. Se gli oggetti dipendono strettamente da essi, saranno costretti a cambiare a loro volta; per questo gli algoritmi soggetti a modifiche devono essere isolati.


* *Pattern:* Builder, Iterator, Strategy/State, Template Method, Visitor.





**3. Indipendenza dalle Piattaforme e Incapsulamento**

* **Hardware e Software:** Legare l'architettura ad API specifiche di una piattaforma hardware o software rende estremamente difficile il porting verso altri sistemi, o persino l'aggiornamento sulla piattaforma stessa. Il design deve limitare al massimo queste dipendenze.


* *Pattern:* Factory, Bridge.




* **Rappresentazione interna:** Le classi "client" non dovrebbero sapere come un oggetto viene implementato, conservato o rappresentato internamente. Nascondere queste informazioni evita che le classi client subiscano cambiamenti a cascata se la struttura dell'oggetto muta.


* *Pattern:* Factory, Bridge, Memento, Proxy.





**4. Riduzione dell'Accoppiamento Globale**

* **Il problema dei monoliti:** Uno stretto accoppiamento (tight coupling) tra le classi genera sistemi monolitici: diventa impossibile modificare, comprendere o riutilizzare una singola classe senza dover toccare anche tutte le altre.


* **La soluzione:** Progettare con un "lasco accoppiamento" (loose coupling) incrementa drasticamente la probabilità che le classi possano essere riutilizzate individualmente e rende il sistema molto più semplice da capire ed estendere.


* **Pattern utili:** Factory, Bridge, Chain of Responsibility, Command, Façade, Mediator, Observer.



**5. Estensione delle Funzionalità: Composizione vs Ereditarietà**

* **Limiti dell'Ereditarietà (White Box Reuse):** Estendere le funzionalità usando le sottoclassi richiede una comprensione profonda della superclasse. Inoltre, l'override di un metodo può costringere a fare l'override di un altro, portando a una proliferazione incontrollata del numero di classi.


* **Vantaggi della Composizione (Black Box Reuse):** È di gran lunga preferibile limitare i livelli gerarchici e usare la composizione di oggetti al posto dell'ereditarietà. Molti design pattern permettono di personalizzare le funzionalità creando una sola sottoclasse e componendo le sue istanze con altri oggetti.


* **Pattern utili:** Bridge, Chain of Responsibility, Composite, Decorator, Observer, Strategy.



**6. Gestione di Classi non Modificabili**

* **Il problema:** In alcuni scenari è impossibile modificare una classe (ad esempio perché il codice sorgente non è disponibile) oppure farlo richiederebbe un numero spropositato di cambiamenti in tutto il sistema.


* **La soluzione:** Si usano pattern che permettono di adattare o "avvolgere" le classi esistenti per estenderne il comportamento dall'esterno in modo sicuro.


* **Pattern utili:** Adapter, Decorator, Visitor.