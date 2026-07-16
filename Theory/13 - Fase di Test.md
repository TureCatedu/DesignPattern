### 1. Concetti Fondamentali: Verifica, Validazione e Testing

Il software con difetti rappresenta un problema di grande entità, poiché gli errori in questo ambito sono estremamente comuni. Riconosciamo l'esistenza di un difetto quando il programma mostra comportamenti anomali rispetto alle sue "specifiche", ovvero i documenti che definiscono cosa il programma dovrebbe effettivamente fare. Queste anomalie comunicano una falla nel sistema e non devono mai essere ignorate.

* **Obiettivo della V&V (Verifica e Validazione):** Assicurare che il sistema soddisfi appieno i bisogni dell'utente finale. Il processo va applicato in ogni fase dello sviluppo per scovare difetti e valutarne l'usabilità operativa.


* **Verifica:** Risponde alla domanda "Stiamo costruendo il prodotto nel modo giusto?", accertandosi che il codice sia strettamente conforme alle specifiche.


* **Validazione (Convalida):** Risponde alla domanda "Stiamo costruendo il prodotto giusto?", verificando che il software faccia esattamente ciò che l'utente ha richiesto.


* **Testing vs Debugging:** Il testing ha lo scopo di rivelare la presenza di difetti, e ha successo solo quando ne scova almeno uno, ma non può mai provarne la totale assenza. Il debugging è invece il processo investigativo di localizzazione e correzione degli errori trovati, tramite la formulazione di ipotesi sul comportamento del codice.

---

### 2. Le Categorie dei Difetti

Sebbene a volte sia difficile distinguere nettamente tra errori di codice e di progetto, i difetti si raggruppano in base alle fasi in cui si originano:

* **Difetti di specifiche:** Emergono quando la descrizione iniziale del prodotto è ambigua, imprecisa o contraddittoria.


* **Difetti di progettazione:** Riguardano componenti e interazioni scorrette, causati da algoritmi malposti (es. divisione per zero), strutture dati errate (es. campi mancanti) o interfacce di moduli inconsistenti.


* **Difetti di codice:** Derivano da errori di implementazione pratica, come conversioni di tipo errate, overflow, variabili non inizializzate o un cattivo uso delle priorità aritmetiche.


* **Difetti di test:** Anche i piani o i casi di test utilizzati per scovare i bug possono, a loro volta, contenere dei difetti.

---

### 3. I Principi del Test

Per effettuare i controlli si definiscono dei **dati di test** (gli input forniti al sistema) e si creano dei **casi di test** (test case), che uniscono i dati di input all'output atteso se il sistema rispetta le specifiche. Gli input comprendono non solo i parametri, ma anche file esterni, eccezioni e lo stato ambientale necessario per l'esecuzione. Più casi di test formano una **test suite**.

* **Il limite dei test esaustivi:** Dimostrare l'assenza totale di difetti richiederebbe un test esaustivo, che però è matematicamente impraticabile. Per esempio, testare una funzione con due numeri interi richiederebbe $2^{32} \times 2^{32}$ input possibili, ovvero circa $1.8 \times 10^{19}$ cicli; se ognuno impiegasse $10^{-9}$ secondi, ci vorrebbero circa 600 anni per finire il test.

* **Priorità:** Si deve dare priorità ai test sulle capacità globali del software rispetto ai singoli componenti, alle funzionalità storiche rispetto a quelle nuove, e alle situazioni tipiche di utilizzo rispetto ai casi limite.


* **La regola del raggruppamento:** La probabilità di trovare nuovi difetti in un componente è direttamente proporzionale al numero di errori già trovati al suo interno. Questo perché i bug tendono ad apparire in "gruppi", spesso a causa di un'elevata complessità strutturale dovuta a una cattiva progettazione.


* **Requisiti:** I test devono includere input sia validi che non validi e devono essere ripetibili nel tempo, effettuando test di regressione sulle nuove versioni per prevenire il ripresentarsi di vecchi errori.

---

### 4. Le Strategie e le Classi di Equivalenza

Per massimizzare l'efficacia, si combinano solitamente due grandi approcci:

* **White-box (Glass-box o strutturale):** Il test si focalizza sulla struttura e sulla logica del software, richiedendo un accesso diretto al codice sorgente o allo pseudo-codice.


* **Black-box:** Il sistema è trattato come una "scatola nera" in cui si ignorano struttura e codice. Si progetta la suite di test unicamente partendo dalle specifiche, ed è un approccio attuabile fin dalle prime fasi di sviluppo.


Per aggirare l'impossibilità dei test esaustivi nell'approccio black-box, si utilizza il **partizionamento in classi equivalenti**. Questo metodo permette di coprire enormi domini di input con pochi valori selezionati:

* Si raggruppano input e risultati attesi in "classi" in base a logiche simili.


* Si assume che testare un solo valore della classe equivalga a testarli tutti in quella specifica categoria.


* Devono essere scelti casi sia per categorie valide che non valide (input inaspettati).


* Ad esempio, per una funzione che accetta numeri da 4 a 20, le partizioni sarebbero: numeri minori di 4, numeri tra 4 e 20, e numeri maggiori di 20. Si testeranno i confini validi e non validi come 3, 4, 12, 20, e 21.



---

### 5. Analisi del Flusso e Test Sotto Stress

* **Test del Percorso:** L'obiettivo è assicurare che tutti i percorsi logici all'interno di un programma siano eseguiti almeno una volta. Lo si rappresenta graficamente con un "grafo di flusso" (i nodi sono le condizioni, gli archi sono il flusso logico).


* **Complessità ciclomatica (cc):** Tramite la formula matematica $cc = \text{archi} - \text{nodi} + 2$ si definisce l'esatto numero di test necessari affinché tutte le condizioni siano verificate (anche se non esaurisce le combinazioni di tutti i percorsi).


* **Stress Test:** Si esegue il sistema forzandolo oltre il carico massimo previsto, per indagare sulle perdite inaccettabili di dati o servizi e verificare che l'applicazione non crolli in maniera catastrofica. È particolarmente rilevante nei sistemi distribuiti soggetti alle fluttuazioni di rete.

---

### 6. Copertura del Codice e Condizioni di Stop

Quando bisogna smettere di effettuare i test? Ci si basa su due metriche principali:

* **Bug Trend:** Misura la frequenza con cui si scoprono nuovi bug. Quando questo numero tende a zero, ci si ferma, perché significa che non ci sono più difetti apparenti oppure che i costi di ricerca sono diventati drammaticamente alti e insostenibili.


* **Code Coverage (Copertura del codice):** È la percentuale del codice sorgente che viene attivamente eseguita da una test suite. Aiuta a capire se nei test manca qualcosa. Si divide il codice in unità (es. condizioni, costrutti), si fissa un target e ci si ferma quando lo si raggiunge. Raggiungere il 100% non certifica la totale assenza di difetti, ma le parti critiche del software dovrebbero sempre esigere una copertura molto più elevata della media.

La copertura può essere declinata in più livelli di dettaglio per assicurare affidabilità:

* **Copertura di funzioni, costrutti e archi:** Misurano la percentuale di funzioni chiamate, comandi eseguiti e archi attraversati nel grafo di controllo.

* **Copertura di rami e condizioni:** Valutano quanti rami condizionali (come i blocchi if/else) sono stati attivati e accertano che ogni espressione booleana sia stata testata sia come vera (true) che come falsa (false).

* **Copertura di decisioni:** È una garanzia avanzata in cui si combina la copertura di funzioni con quella di rami, verificando ogni punto d'entrata/uscita e tutte le valutazioni possibili di variabili booleane.