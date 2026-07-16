### 1. Introduzione ai Processi Software

Un processo software è l'insieme delle attività necessarie per sviluppare un prodotto software e definisce come queste attività sono interconnesse tra loro. Le fasi fondamentali, comuni a molti processi, sono: analisi dei requisiti, progettazione, implementazione, convalida (testing) e manutenzione. Poiché il software è intrinsecamente flessibile, la manutenzione si traduce spesso in un'evoluzione continua per adattarsi ai cambiamenti dei requisiti o dell'ambiente (es. business, hardware) affinché rimanga utile nel tempo.

### 2. Le Fasi Fondamentali dello Sviluppo

**A. Analisi dei Requisiti**
Questa fase serve a definire i servizi richiesti al software e i suoi vincoli, producendo le "specifiche".

* **Definizioni chiave:** Un *requisito* è una singola caratteristica (spesso granulare) del software, mentre la *specifica* ne è la descrizione rigorosa. Un insieme di requisiti correlati che soddisfa un obiettivo dell'utente è detto *feature*.


* **Tipologie:** I requisiti si dividono in *funzionali* (cosa deve fare il sistema) e *non-funzionali* (come lo fa, includendo parametri come prestazioni, efficienza, affidabilità e manutenibilità).


* **Passi operativi:** Studio di fattibilità, analisi vera e propria, stesura delle specifiche e convalida finale dei requisiti.



**B. Progettazione (Design)**
In questa fase si stabilisce l'architettura del software necessaria a realizzare le specifiche.

* Le attività includono: suddivisione dei requisiti, identificazione dei sottosistemi e delle loro responsabilità, e progettazione di interfacce, componenti, strutture dati e algoritmi.


* Il risultato è una serie di documenti che descrivono vari modelli del sistema (es. modello degli oggetti, di sequenza, strutturale, transizione stati, data-flow).



**C. Implementazione (Codifica)**
Consiste nella traduzione dei modelli di progetto in codice per creare un programma eseguibile.

* Progettazione e implementazione sono fasi strettamente correlate che si alternano frequentemente.


* Include la rimozione dei bug (errori): i programmatori testano il codice, localizzano l'errore, lo correggono prima nel modello di design e poi nel codice, per infine ritestare il programma.



**D. Convalida (Verifica & Validazione) e Testing**
Questa fase dimostra che il software è conforme alle specifiche e soddisfa le aspettative del cliente, elaborando dati reali. I test si suddividono in:

* **Unit test (di componente):** Test di singole funzioni o oggetti in modo indipendente.


* **Test di sistema:** Test dell'intero prodotto per valutarne le proprietà emergenti.


* **Alpha test (di accettazione):** Condotto dagli sviluppatori usando i dati del cliente. Genera la versione *Alfa*, che è integrata ma presenta ancora difetti e parti mancanti.


* **Beta test:** Condotto da un gruppo di clienti sul prodotto quasi completo. Genera la versione *Beta*, che possiede tutte le feature previste ma può ancora contenere bug, prima di arrivare alla versione *Gold* (finale).



---

### 3. I Modelli di Processo (Approcci allo Sviluppo)

**Il Modello a Cascata (Waterfall - 1970)**
È un processo statico e sequenziale in cui si passa alla fase successiva solo dopo aver completato interamente la precedente (si specifica tutto, poi si produce, poi si testa).

* *Vantaggi:* Crea forte consistenza tra gli artefatti, produce ampia documentazione e garantisce alta qualità del codice. È ideale per team numerosi e per sistemi grandi, critici e con requisiti stabili fin dall'inizio.


* *Svantaggi:* Tempi lunghi per ottenere il prodotto finito, interazione col cliente limitata solo all'inizio e forte rigidità (è difficile introdurre cambiamenti richiesti in corso d'opera).



**Il Processo Evolutivo**
In questo approccio, le attività di specifica, sviluppo e validazione sono concorrenti e si accavallano. Presenta due varianti:

* *Sviluppo per Esplorazione:* Sviluppatori e clienti lavorano insieme; partendo da specifiche iniziali, il sistema evolve per trasformazioni successive aggiungendo nuove caratteristiche.


* *Build and Fix:* Approccio caotico quasi privo di documentazione e design. Si costruisce e si modifica rapidamente una prima versione finché il cliente non è soddisfatto, producendo spesso codice di bassa qualità.


* *Applicabilità:* Poiché tende a generare sistemi difficili da capire, da modificare e con tempi incerti, questo processo è adatto solo per prototipi, sistemi piccoli o singole parti di sistemi complessi (come le interfacce utente).



**Altri Approcci**

* **Sviluppo Incrementale:** Si sviluppano prima le funzionalità prioritarie (di base), per poi aggiungere iterativamente nuovo codice per le funzionalità secondarie, fino al completamento.


* **CBSE (Component-Based):** Sfrutta il riuso di componenti già esistenti sul mercato (COTS). Richiede di analizzare i componenti disponibili, adattare i requisiti ad essi, progettare tenendo conto del riuso e infine integrare il tutto.



**Il Modello a Spirale (Boehm - 1988)**
È un processo di tipo agile che si focalizza sul rilascio di tanti sottoprodotti funzionali. Ogni ciclo (o loop) della spirale rappresenta una fase e produce codice testato e integrato, garantendo tempi brevi per la prima versione e forte interazione col cliente. Ogni ciclo si divide in quattro settori:

1. **Obiettivi:** Identificazione degli scopi e delle alternative per la fase corrente.


2. **Valutazione Rischi:** Analisi degli imprevisti (valutandone probabilità di accadimento e gravità dell'impatto) e azioni per ridurli.


3. **Sviluppo e Convalida:** Creazione di una parte del sistema basandosi sui modelli precedenti.


4. **Pianificazione:** Revisione del lavoro svolto e organizzazione della fase successiva della spirale.