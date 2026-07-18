
### 1. Miglioramento del Codice e Astrazioni

* Separare le diverse operazioni in metodi distinti è una pratica fondamentale per favorire il riutilizzo del codice e mantenerne alta la qualità.


* È necessario costruire "astrazioni", ovvero strutturare metodi e classi in modo da nascondere i dettagli di implementazione.


* Il nome scelto per identificare queste astrazioni è cruciale, poiché deve descriverne chiaramente l'obiettivo.


* Occorre separare nettamente i metodi *Command* (che modificano e aggiornano lo stato del sistema) dai metodi *Query* (che si limitano a restituire informazioni tramite calcoli o accesso ai dati, senza fare alterazioni).


* Lo stato di un oggetto deve essere reso osservabile per permettere l'esecuzione dei test.



---

### 2. Responsabilità e Coesione (SRP)

* Il Principio di Singola Responsabilità (SRP) stabilisce che un metodo o una classe debba avere un unico e preciso compito.


* In termini pratici, deve esistere un solo motivo per dover modificare quella specifica porzione di codice.


* L'applicazione rigorosa del principio SRP garantisce un'elevata coesione, facilitando enormemente la comprensione globale, il riuso e l'ereditarietà.



---

### 3. I Test e la Qualità del Software (Correttezza)

* Un test è un programma che viene eseguito sotto specifiche condizioni (input) per accertare che il risultato ottenuto sia corretto e aderente ai requisiti.


* La stesura dei test incrementa la qualità del software, poiché documenta le condizioni esatte sotto cui il codice deve funzionare.


* I test agiscono come un sistema di protezione, difendendo la base di codice da modifiche indesiderate o accidentali.


* Per essere efficaci, i test devono essere totalmente indipendenti gli uni dagli altri e devono "autovalutarsi", confrontando automaticamente il risultato ottenuto con il valore atteso.



---

### 4. Metodologie di Sviluppo e Testing

* 
**TDD (Test-Driven Development):** È una tecnica di progettazione e programmazione che prevede l'implementazione del test ancor prima di scrivere il codice effettivo dell'applicazione.


* Il processo del TDD si basa sul ciclo iterativo *Red - Green - Refactor*.


* Fase RED (Test Fallito): Il test genera un errore, e per risolverlo si modificano o si implementano le classi necessarie.


* Fase GREEN (Test Superato): Non si ottengono più errori, quindi si procede a implementare ulteriori test per nuovi requisiti.


* Fase REFACTOR: Si migliora e si pulisce la struttura interna del codice (code base) assicurandosi che continui a superare i test.


* **BDD (Behaviour-Driven Development):** È un approccio incentrato sul comportamento e strutturato sul modello *Given-When-Then*: dato un contesto (Given), quando accade un evento (When), il sistema deve rispondere in un certo modo (Then).


* **Acrostico FIRST:** Definisce le caratteristiche che devono possedere i buoni test: *Fast* (veloci), *Isolated* (isolati), *Repeatable* (ripetibili), *Self-validating* (autovalutanti) e *Timely* (tempestivi).



---

### 5. I Princìpi Fondamentali dell'Ingegneria del Software

* **KISS (Keep It Simple, Stupid):** Produce e progetta componenti che siano il più semplici possibile, per renderli facili da capire e gestire.


* **DRY (Don't Repeat Yourself):** Scongiura le ripetizioni superflue nel codice.


* **YAGNI (You Ain't Gonna Need It):** Evita di progettare in anticipo funzionalità o componenti che non sono strettamente o attualmente necessari.


* **LoD (Law of Demeter):** Detta la regola del "non parlare con gli estranei"; un oggetto dovrebbe comunicare e interagire solo con oggetti strettamente correlati (amici) per limitare le dipendenze.



---

### 6. Compilazione ed Esecuzione in Java (Pratica)

* Per compilare una classe dal terminale/shell dei comandi, si utilizza l'istruzione `javac NomeClasse.java`, che (se non ci sono errori) genera il file eseguibile compilato.


* Per avviare ed eseguire il programma si usa invece il comando `java NomeClasse`.


* Affinché una classe possa essere eseguita, deve necessariamente contenere al suo interno un metodo d'ingresso, specificatamente: `public static void main(String[] args)`.


* Se la classe necessita di componenti esterni o librerie, questi devono essere dichiarati con l'istruzione `import` all'inizio del file sorgente.
