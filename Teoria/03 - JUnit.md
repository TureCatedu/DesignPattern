### **1. Cos'è JUnit**

JUnit è il framework di riferimento per eseguire test su classi e metodi nelle applicazioni Java. La sua funzione principale è fornire un motore di esecuzione per i test e un set di API (interfacce di programmazione) necessarie per scriverli. Attualmente, la versione più recente e utilizzata è JUnit 6.

---

### **2. Le Annotazioni in JUnit**

Il funzionamento di JUnit si basa fortemente sulle annotazioni Java: metadati associati a elementi del codice (come i metodi) che forniscono informazioni aggiuntive al compilatore e dettano il flusso di esecuzione dei test.

Ecco le annotazioni fondamentali:

* **`@Test`:** Identifica esplicitamente un metodo come metodo di test.
* **`@BeforeEach`:** Indica un metodo che deve essere eseguito *prima di ogni singolo test* presente nella classe (utile per inizializzare dati ripetitivi).
* **`@BeforeAll`:** Indica un metodo che viene eseguito *una sola volta in assoluto*, prima che parta l'intera suite di test.
* **`@ParameterizedTest`:** Identifica un test che deve essere eseguito più volte, ma con parametri di input differenti, evitando di dover scrivere e testare i valori rigidamente nel codice.
* **`@CsvSource`:** Si usa in combinazione con i test parametrizzati. Permette di passare i valori di input come se fossero righe di un file CSV (es. `"1, 1, 2"`), fornendo una serie di record con un numero costante di valori.

---

### **3. Le Asserzioni (Assertions)**

Le asserzioni sono il cuore del test: servono a verificare che il comportamento effettivo del codice corrisponda al valore o al comportamento atteso in maniera standardizzata. JUnit fornisce questi strumenti tramite i metodi della classe `Assertions`.

Le asserzioni più comuni sono:

* **`assertEquals(expected, actual)`:** Verifica che il valore calcolato dal codice sia esattamente uguale al valore atteso.
* **`assertTrue(condition)`:** Verifica che una specifica condizione logica restituisca il valore *true*.
* **`assertNull(object)`:** Verifica che l'oggetto passato come parametro sia nullo.

---

### **4. La Copertura del Codice (Code Coverage)**

La copertura del codice è una metrica (espressa in percentuale) che indica quante linee del tuo codice sorgente sono state effettivamente eseguite durante i test.

* **Obiettivo:** Raggiungere il 100% di copertura significa che i test hanno attraversato ogni singola riga di codice dell'applicazione.
* **Strumenti visivi:** Strumenti integrati (come quelli presenti in IDE tipo VSCode) tracciano l'esecuzione fornendo un feedback visivo, permettendo allo sviluppatore di vedere esattamente quali righe sono state "coperte" dai test e quali sono state ignorate.

---

### **5. Apache Maven e la Gestione del Progetto**

Maven è uno strumento fondamentale per la gestione dei progetti Java e per l'automazione della *build* (costruzione del software). Il suo scopo è standardizzare la compilazione, la gestione delle dipendenze, i test, il packaging e il rilascio del software.

**Struttura Standard di Maven:**
Maven impone una gerarchia di cartelle convenzionale e predeterminata, divisa logicamente:

* La cartella **`src/main/java`** contiene il codice sorgente eseguibile dell'applicazione.
* La cartella **`src/test/java`** contiene esclusivamente il codice relativo ai test (separandolo dal codice in produzione).

**Il File POM e le Dipendenze:**
Il cuore di un progetto Maven è il file **`pom.xml`** (Project Object Model). Questo file XML racchiude la descrizione del progetto, le configurazioni, i plugin e, soprattutto, le **dipendenze** (le librerie esterne necessarie, come JUnit stesso).
Le librerie non vanno scaricate a mano: vengono dichiarate nel POM, cercate da Maven nell'apposito *Maven Central Repository*, e scaricate e gestite in totale autonomia.

**Comandi Principali di Maven:**
L'esecuzione di un comando (fase) in Maven esegue automaticamente anche tutte le fasi che lo precedono logicamente.

| Comando | Azione Eseguita |
| --- | --- |
| **`mvn archetype:generate`** | Crea la struttura iniziale di un nuovo progetto. |
| **`mvn compile`** | Compila il codice sorgente dell'applicazione. |
| **`mvn test`** | Esegue i test di unità scritti nel progetto. |
| **`mvn package`** | Impacchetta il codice compilato in un formato distribuibile (es. un file `.jar`). |
| **`mvn verify`** | Esegue i controlli di qualità e verifica che il pacchetto sia valido. |