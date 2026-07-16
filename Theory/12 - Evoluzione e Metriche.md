**1. Manutenzione ed Evoluzione: Definizioni e Impatto Economico**

* **Definizioni:** Il processo di manutenzione del software consiste nell'introdurre modifiche a un prodotto dopo la sua consegna al cliente. Il termine "evoluzione" viene spesso usato come sinonimo, oppure per indicare una singola fase di questo processo (che può includere l'evoluzione vera e propria, il rilascio di patch o la definitiva rimozione del sistema).


* **Costi:** La manutenzione è la voce di spesa più impattante, rappresentando ben il 67-80% dei costi totali di un software. I costi si riducono se il team di sviluppo originario viene coinvolto direttamente in questa fase. Tuttavia, se gli sviluppatori non hanno responsabilità contrattuali sulla manutenzione futura, mancheranno degli incentivi per creare una progettazione facilmente modificabile.


* **Tipologie di modifica:** I cambiamenti si dividono in quattro categorie:


* *Correttivi (17%)*: rimozione di errori nel codice.


* *Adattativi (18%)*: aggiustamenti necessari per far funzionare il software in un nuovo ambiente.


* *Perfettivi (60%)*: l'aggiunta di nuove funzionalità o il miglioramento di quelle esistenti (è l'attività che assorbe più risorse).


* *Preventivi (5%)*: modifiche alla struttura interna per prevenire problemi futuri.




* Dato il forte impatto delle nuove funzionalità, è buona norma anticipare la necessità di cambiamenti già in fase di design (ad esempio tramite incapsulamento o parametrizzazione).



**2. Le Dinamiche di Evoluzione (Leggi di Lehman)**
Sulla base di studi empirici condotti a partire dal 1968 da Lehman e Belady su grandi sistemi sviluppati da grandi aziende, sono state formulate le seguenti leggi sui processi di cambiamento del software:

* **Cambiamento continuo (1974):** I sistemi devono essere adattati costantemente, pena la loro progressiva perdita di utilità e soddisfazione per l'utente.


* **Aumento della complessità (1974):** Durante l'evoluzione, la struttura del sistema degrada diventando più complessa, a meno che non si applichino sforzi specifici per preservarla o semplificarla.


* **Auto-regolazione (1974):** Nonostante l'evoluzione, attributi come le dimensioni complessive, gli intervalli tra una release e l'altra, e i difetti trovati tendono a rimanere statisticamente invarianti.


* **Stabilità organizzativa (1978):** Il tasso di sviluppo di un sistema è pressoché costante nel tempo, e risulta slegato dalle risorse umane o tecniche impiegate per lo sviluppo.


* **Conservazione di familiarità (1978):** L'incremento della crescita di un sistema tende, in media, a diminuire o rimanere costante nel tempo.


* **Continua crescita (1978):** Le funzionalità offerte da un sistema devono aumentare continuamente per mantenere inalterata la soddisfazione dell'utente.


* **Diminuzione della qualità (1994):** Senza una gestione e un adattamento rigorosi durante i cambiamenti, la qualità del software declinerà inesorabilmente.


* *Applicabilità:* Queste regole valgono specificamente per grandi organizzazioni e grandi progetti. Non è ancora chiaro come si adattino a piccole aziende, a prodotti di piccole dimensioni o a software che integrano molti componenti pre-pacchettizzati (COTS).



**3. Modelli e Tipi di Intervento per la Manutenzione**
La struttura del software degrada naturalmente man mano che si introducono modifiche. Per gestire questi interventi si usano diversi approcci organizzativi e tecnici:

* **Modelli operativi:**
* *Quick-fix:* Cambiamenti applicati in modo rapido e diretto a livello del codice sorgente.


* *Miglioramento iterativo:* Modifiche pianificate tramite un'analisi del sistema per mantenere il controllo sulla complessità preservando il design originario.


* *Riuso:* Definizione di requisiti per un sistema completamente nuovo, massimizzando il riuso del codice esistente.




* **Tipi di modifica sul codice:**
* *Re-factoring / Re-structuring:* Si modifica un codice con una struttura problematica per migliorarne l'organizzazione interna, lasciandone però inalterato il comportamento visibile dall'esterno.


* *Reverse engineering:* Consiste nell'analizzare a ritroso un sistema esistente per estrarre le informazioni che ne descrivono la struttura o il comportamento.


* *Re-engineering:* Si altera e si smonta un sistema per poi ricostituirlo sotto una forma diversa e più moderna.





**4. Misurare il Software: Le Metriche**
Per valutare la bontà del software e guidare la manutenzione, si utilizza un set di misure note come "metriche". Il loro obiettivo è monitorare il prodotto durante lo sviluppo, definire livelli accettabili e intervenire (rimediare) quando i valori non sono soddisfacenti. Si possono misurare direttamente solo gli attributi "interni" (come le righe di codice), mentre quelli "esterni" (come la qualità) si ricavano indirettamente.

* **Metriche Tradizionali:**
* *Complessità ciclomatica (cc):* Valuta la complessità di un algoritmo calcolando i suoi percorsi indipendenti tramite un grafo logico (cc = archi - nodi + 2). Questo numero indica l'esatta quantità di test necessari per valutare esaurientemente quel pezzo di codice (es. 1 per una sequenza, 2 per un if/then o un while).


* *Dimensione:* Si misura in LOC (Lines Of Code) oppure NCNB (linee di codice escludendo spazi vuoti e commenti).


* *Comment Percentage:* Definisce il rapporto percentuale dei commenti rispetto alle linee di codice (il valore raccomandato è intorno al 30%).




* **Metriche per Sistemi Orientati agli Oggetti (Suite CK - Chidamber & Kemerer):**
* *WMC (Weighted Methods per Class):* È la somma delle complessità dei metodi presenti in una classe. Un alto WMC significa che la classe è molto specifica, scarsamente riutilizzabile e richiederà un grande sforzo di manutenzione.


* *DIT (Depth of Inheritance Tree):* Misura la massima profondità dell'albero di ereditarietà partendo dalla classe radice (livello 0). Un valore alto indica maggiore possibilità di riuso, ma anche che la classe e il sistema sono molto complessi, e che il comportamento è difficile da capire a causa dei troppi metodi ereditati.


* *NOC (Number of Children):* Conta il numero di sottoclassi figlie. Maggiore è questo numero, maggiore è l'influenza della classe sul sistema generale e più ampio è il suo riuso.


* *CBO (Coupling Between Object Classes):* Indica quante altre classi interagiscono con la classe presa in esame. Valori elevati evidenziano troppa dipendenza esterna, rendendo il codice difficile da riusare, comprendere e correggere.


* *RFC (Response for a Class):* Rappresenta il numero totale di metodi che scattano quando si riceve un messaggio (i metodi interni della classe più quelli da essi invocati). Un RFC alto indica problemi di testabilità e comprensione dovuti a una forte complessità.


* *LCOM (Lack of Cohesion of Methods):* Valuta matematicamente la "mancanza di coesione", confrontando quanti metodi utilizzano i vari attributi (campi) di una classe. Una coesione elevata (che produce un valore LCOM basso) è l'obiettivo ideale: indica che la classe è semplice, obbedisce al principio della singola responsabilità ed è facilmente riutilizzabile.