
### 1. La Natura e le Caratteristiche del Software

Il software è un'entità intrinsecamente modificabile poiché non possiede parti fisiche o "atomi". Questa sua natura rende la **necessità di modifica** una costante ineludibile, specialmente quando un prodotto ha successo.
I cambiamenti sono solitamente necessari per tre motivi:

* **Adattamento a una nuova realtà:** Cambiano i contesti di utilizzo o le esigenze degli utenti.


* **Estensione:** Aggiunta di nuove funzionalità richieste dal successo del prodotto.


* **Sopravvivenza hardware/software:** Il software deve essere adattato per funzionare su piattaforme e hardware differenti rispetto a quelli per cui era stato originariamente concepito.



*Nota sull'era dell'Intelligenza Artificiale:* Saper sviluppare e ingegnerizzare il software è essenziale anche con l'uso dell'AI generativa. L'AI tende a riusare algoritmi esistenti e genera codice che può contenere difetti o problemi di sicurezza; serve quindi competenza umana per fare debugging, diagnosticare problemi e fornire prompt precisi.

### 2. I Cinque Criteri di Qualità del Software

Per valutare la bontà di un sistema software, l'Ingegneria del Software utilizza cinque criteri operativi:

1. **Correttezza:** Il software aderisce allo scopo per cui è stato creato ed è strettamente conforme alle specifiche (fa quello che il cliente ha richiesto).


2. **Efficienza:** Non spreca risorse di sistema.


3. **Manutenibilità:** Risulta facile introdurre nuove modifiche al codice.


4. **Dependability (Affidabilità e Sicurezza):** Garantisce la difesa dei dati, del sistema stesso e delle persone, funzionando in modo affidabile (senza guasti) con un'alta probabilità.


5. **Usabilità:** Fornisce all'utente condizioni d'uso efficaci e pratiche.



### 3. Principi di Buona Progettazione (Object-Oriented)

Per garantire le qualità appena citate, si applicano due paradigmi fondamentali:

* Programmare per interfacce e non per implementazioni:
Questa pratica riduce la propagazione dei cambiamenti (se devo modificare qualcosa, non "rompo" il resto del sistema) e facilita enormemente l'implementazione dei test, favorendo manutenibilità, correttezza e dependability.
*Esempio in Java:* Invece di vincolare il codice alla classe specifica `ArrayList`, si utilizza l'interfaccia generale `List` (che definisce solo i metodi, come `add()` e `get()`). `ArrayList` è solo una delle tante classi che implementano quell'interfaccia.


* Paradigma "Command and Query":
Consiste nel dividere i metodi in due tipologie distinte, assegnando a ciascuno una singola responsabilità:


* **Command (Modificatori):** Eseguono un'azione che cambia lo stato interno del sistema, ma non restituiscono alcun valore.


* **Query:** Restituiscono un risultato ma non modificano in alcun modo lo stato del sistema. Questo permette di chiamarli quante volte si desidera senza effetti collaterali.


### 4. Il Nemico della Qualità: Lo "Spaghetti Code"

Il codice di scarsa qualità è spesso vittima dell'antipattern noto come *Spaghetti Code*.  Si tratta di un codice figlio dell'inesperienza e dell'assenza di progettazione , caratterizzato da:

* **Natura Monolitica:** Un unico grande blocco (flusso) di codice fa troppe cose contemporaneamente. Non essendo strutturato ad oggetti, è impossibile testarne la correttezza a blocchi o riutilizzarlo.


* **Metodi pessimi:** Funzioni lunghissime, scritte senza parametri in ingresso e che abusano di variabili globali.


* **Flusso e interazioni rigide:** Il flusso di esecuzione è dettato dalla struttura interna e non da chi chiama il metodo. Le interazioni fra gli oggetti sono ridotte al minimo.


* **Nessun approccio ad oggetti (OOP):** Segue uno stile puramente procedurale. Non sfrutta i vantaggi dell'ereditarietà e del polimorfismo, e gli oggetti non mantengono il loro stato tra una chiamata e l'altra.


**La Soluzione:**
Per correggere lo Spaghetti Code, bisogna separare le responsabilità (refactoring). Ad esempio, anziché avere un unico enorme metodo che legge un file, estrae i massimi, controlla i duplicati e fa le somme, si progetta una classe con attributi di stato (es. `totale`, `massimo`) e piccoli metodi distinti per ogni azione (`leggiFile()`, `calcolaSomma()`, `getSomma()`). Le buone metriche confermano questo approccio: in un software ben ingegnerizzato, i metodi sono molto brevi (spesso intorno alle 3 o 4 linee di codice ciascuno).