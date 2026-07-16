### Panoramica sui Diagrammi UML

Il linguaggio UML (Unified Modeling Language) utilizza diverse tipologie di diagrammi per descrivere un sistema software sotto vari aspetti, dai requisiti iniziali fino all'implementazione dettagliata.

#### 1. Diagrammi dei Casi d'Uso

Questi diagrammi modellano il comportamento del sistema visto dall'esterno, senza scendere in dettagli implementativi interni.

* **Scopo:** Identificano gli obiettivi di alto livello e le funzionalità specifiche offerte dal software.


* **Elementi principali:** Mostrano le interazioni tra il sistema e gli *Attori* (che possono essere utenti umani o sistemi esterni).


* **Relazioni:** Tra i vari casi d'uso o attori possono esserci dinamiche di:
* *Generalizzazione:* Un elemento eredita le caratteristiche di un altro più generale.


* *Estensione:* Un caso d'uso base ne utilizza un altro solo in modo opzionale o incrementale.


* *Inclusione:* Un caso d'uso incorpora obbligatoriamente il comportamento di un altro.





#### 2. Diagrammi delle Attività

Rappresentano il flusso di controllo o procedurale del sistema, passo dopo passo, in modo simile a un diagramma di flusso.

* **Scopo:** Sono ideali per modellare la logica interna di un'operazione complessa, gestire processi paralleli e definire chi fa cosa.


* **Corsie (Swimlanes):** Il diagramma è spesso diviso in colonne (es. Cliente, Vendite, Magazzino) che indicano chiaramente le responsabilità di ciascun attore o modulo nelle varie fasi.


* **Simbologia principale:**
* *Cerchio pieno / Cerchio bordato:* Indicano rispettivamente lo stato iniziale e finale del flusso.


* *Rettangoli smussati:* Rappresentano i singoli passi di elaborazione o azioni.


* *Rombi:* Indicano diramazioni condizionali (bivi logici) o il ricongiungimento di flussi.


* *Barre spesse:* Segnano i punti di parallelizzazione (divisione in flussi paralleli) o sincronizzazione (unione di flussi).


* *Frecce tratteggiate:* Rappresentano il passaggio di dati in input o output tra le attività.





#### 3. Diagrammi degli Stati

Descrivono il ciclo di vita temporale di un singolo oggetto.

* **Scopo:** Specificano i diversi stati in cui un oggetto può trovarsi nel tempo e le *transizioni* che ne causano il passaggio da uno stato all'altro in risposta a specifici eventi o condizioni.


* **Stati Composti:** Uno stato può non essere semplice, ma contenere al suo interno dei sotto-stati. Questi si dividono in:


* *Sequenziali:* Solo un sotto-stato può essere attivo in un dato momento.


* *Concorrenti:* Più sotto-stati possono essere attivi simultaneamente.





#### 4. Diagrammi delle Classi

Mostrano la struttura statica del sistema, evidenziando le entità principali, le loro caratteristiche e le interconnessioni.

* **Individuare le classi (Analisi Grammaticale):** Partendo dai requisiti testuali, i *sostantivi* (o gli oggetti fisici menzionati) suggeriscono le Classi e gli Attributi, mentre i *verbi* indicano le Operazioni (metodi).


* **Progettazione:** È fondamentale raggruppare attributi e metodi seguendo i principi di alta coesione e singola responsabilità (KISS, SRP).


* **Dettaglio:** Le classi contengono il nome, la lista degli attributi (es. `- nome: String`) e la lista dei metodi (es. `+ getNome()`).


* **Tipi di Relazione:**
* *Associazione / Dipendenza:* Indicata da una linea semplice o da una freccia di dipendenza.


* *Ereditarietà:* Indicata da una freccia con la punta a triangolo vuoto.


* *Aggregazione (rombo vuoto):* Indica un legame "è parte di" debole (es. un Ordine aggrega dei Prodotti; se l'ordine viene cancellato, i prodotti restano a sistema).


* *Composizione (rombo pieno):* Indica un legame strutturale forte (es. un Ordine è composto da Stati; senza l'ordine, lo stato non ha motivo di esistere).





#### 5. Diagrammi di Collaborazione

Illustrano le interazioni dinamiche tra gli oggetti (istanze delle classi) durante l'esecuzione del software.

* **Scopo:** A differenza dei diagrammi delle classi (che sono statici), questi diagrammi si basano sulla struttura spaziale e associativa per mostrare il flusso di messaggi in uno scenario specifico.


* **Ordine Cronologico:** I messaggi (chiamate ai metodi) scambiati tra gli oggetti lungo le linee di associazione sono sempre contrassegnati da un *numero sequenziale*. Questo permette di leggere chiaramente l'ordine temporale esatto in cui avvengono le operazioni (es. `1: getNome()`, seguito da `2: getCosto()`).