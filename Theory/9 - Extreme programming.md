### 1. Il Manifesto Agile (2001)

Lo sviluppo Agile si fonda su un cambio di mentalità rispetto ai metodi tradizionali: il focus si sposta dall'ordine rigido delle attività all'auto-organizzazione, alla collaborazione e all'adattabilità. I quattro valori fondamentali privilegiano:

* Gli individui e le interazioni rispetto ai processi e agli strumenti.

* Il software funzionante rispetto alla documentazione esaustiva.

* La collaborazione con il cliente rispetto alla negoziazione contrattuale.

* La pronta risposta al cambiamento rispetto al seguire un piano prestabilito.

L'agilità si traduce nell'accogliere positivamente i cambiamenti anche in fasi avanzate, rilasciare software frequentemente e mantenere un'alta eccellenza tecnica con team motivati.

---

### 2. Extreme Programming (XP): Concetti Base

L'Extreme Programming (XP), ideato da Kent Beck nel 1999, è una metodologia Agile altamente adattativa, ideale per progetti con requisiti instabili, tempi brevi o alti rischi.
I principi chiave includono:

* Sviluppo e consegna in piccoli incrementi di funzionalità (cicli di sole 2 settimane) con team da 2 a 12 persone.

* Ricerca rapida di feedback, accettazione dei cambiamenti e assunzione della massima semplicità nel design.

* Documentazione ridotta al minimo a favore della comunicazione verbale diretta.

---

### 3. Le 12 Pratiche Fondamentali dell'XP

L'XP si basa su 12 pratiche operative , che possono essere raggruppate in quattro macro-aree logiche:

#### A. Pianificazione e Gestione dei Requisiti

* **Gioco di Pianificazione (Planning Game):** Gli sviluppatori stimano i tempi, mentre i clienti definiscono le priorità; si pianifica in modo grossolano l'intera release e nel dettaglio solo l'iterazione corrente (circa 3 settimane), affrontando prima i task più rischiosi.

* **Story Cards:** Requisiti descritti dagli utenti sotto forma di brevi storie (2-3 frasi) scritte su cartoncini (circa 12x7 cm), che fungono da casi d'uso leggeri, testabili e stimabili. Vengono organizzate visivamente su una "Story Board".

* **Piccole Release:** Rilasci continui e contenuti (circa 2 settimane di sviluppo) per ottenere feedback rapidi, ridurre i rischi e guadagnare la fiducia del cliente.

* **Cliente in Sede:** Un rappresentante del cliente lavora col team per scrivere test funzionali, stabilire priorità e rispondere ai dubbi in tempo reale.

#### B. Progettazione (Design)

* **Metafora:** L'architettura del sistema viene descritta tramite una metafora semplice e condivisa (es. "L'interfaccia è una scrivania") per facilitare la comunicazione con il cliente.

* **Design Semplice:** Si implementa solo ciò che serve sul momento ("paga quanto usi"), creando il minor numero di classi e metodi possibili senza ripetizioni, purché passino i test.

* **CRC Cards (Class, Responsibility, Collaboration):** Cartoncini usati per documentare in modo rapido il design orientato agli oggetti, fornendo una visione d'insieme del sistema.

#### C. Sviluppo e Scrittura del Codice

* **Pair Programming:** Si programma a coppie su un'unica postazione. Il *driver* usa la tastiera e pensa all'implementazione; il *navigator* revisiona il lavoro in tempo reale e pensa ai test e alla semplicità. I ruoli e i partner si scambiano frequentemente per diffondere la conoscenza.

* **Refactoring:** Miglioramento continuo della struttura del codice per rimuovere duplicazioni e semplificarlo, senza alterarne il comportamento.

* **Standard di Codifica:** Regole uniformi e condivise (es. indentazione, nomi delle classi) per rendere il codice facilmente leggibile da tutti, evitando complessità inutili o riformattazioni.

* **Possesso Collettivo del Codice:** Chiunque nel team può modificare qualsiasi parte del codice del sistema, in quanto tutti sono responsabili dell'intero progetto.


#### D. Test e Benessere del Team

* **Testing Continuo:** I test sostituiscono di fatto i documenti di specifica (sono "specifiche eseguibili"). Si dividono in:

    * *Unit test:* Scritti dai programmatori (spesso prima del codice stesso, pratica del TDD) per supportare il design e proteggere il sistema durante il refactoring.

    * *Test Funzionali:* Scritti dall'utente ed eseguiti in modo automatizzato almeno ogni giorno.

* **Integrazione Continua:** Il nuovo codice viene integrato e testato nel sistema ogni poche ore (massimo un giorno). Se l'integrazione fallisce i test e non può essere riparata, il codice viene scartato.

* **Settimana di 40 Ore:** Il sovraccarico di lavoro causa errori gravi; mantenere la settimana lavorativa entro le 40 ore assicura che gli sviluppatori rimangano "freschi" e lucidi.

---

### 4. L'Evoluzione nel Tempo

L'Extreme Programming è una metodologia nata nel 1999 che pone l'accento sulle persone e sul codice piuttosto che sull'eccessiva documentazione. Con il tempo, i suoi principi (seppur non del tutto nuovi) si sono evoluti supportando nuovi strumenti e dinamiche: dai forum come StackOverflow (2008), al Mob Programming (2014, programmazione in gruppo), fino alla programmazione a coppie in remoto tramite Live Share (2020) o supportata dalle intelligenze artificiali come ChatGPT (2023).