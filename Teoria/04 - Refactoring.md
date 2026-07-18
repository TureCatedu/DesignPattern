## 1. Cos'è il Refactoring

Il refactoring è un processo di modifica del codice sorgente che **migliora la struttura interna di un sistema software senza alterarne il comportamento esterno**. In altre parole, i requisiti funzionali (ciò che il programma fa) rimangono identici, ma il codice viene riorganizzato a piccoli passi per renderlo più pulito ed efficiente.

L'obiettivo principale è evitare di accumulare "debito tecnico" (il deterioramento della progettazione che avviene fisiologicamente quando si aggiungono continue modifiche a un software).

**I vantaggi principali:**

* Facilità nell'incorporare nuovi requisiti in futuro.
* Diminuzione delle dimensioni complessive del codice (eliminazione delle duplicazioni).
* Miglioramento netto della manutenibilità a lungo termine.
* Maggiore facilità nella comprensione logica e nella ricerca di difetti (bug).

---

## 2. Sintomi di un Cattivo Codice: I "Code Smells"

Per capire quando e dove è necessario applicare il refactoring, si va alla ricerca di "cattivi odori" (Code Smells), ovvero indicatori di una cattiva progettazione:

* **Codice duplicato:** Lo stesso blocco logico ripetuto in più punti.
* **Metodi troppo lunghi:** O metodi che richiedono troppi commenti per essere compresi.
* **Classi enormi:** Classi con troppe righe di codice o che gestiscono troppe istanze/responsabilità.
* **Liste di parametri infinite:** Un singolo metodo che richiede troppi argomenti in ingresso.
* **Cambiamenti divergenti:** Quando per aggiungere una singola funzionalità si è costretti a modificare tante parti diverse e slegate del sistema.

---

## 3. La Regola d'Oro: Il Testing

Non si può fare refactoring alla cieca. Prima di modificare il codice, è obbligatorio avere una suite di test funzionante. Dopo aver applicato una tecnica di refactoring, **bisogna assicurarsi che i test precedentemente scritti siano ancora superati (Green)**. Se un test fallisce, significa che il refactoring ha alterato il comportamento esterno e compromesso il sistema; bisogna fermarsi e correggere subito.

---

## 4. Le 5 Tecniche di Refactoring

### 1. Estrai Metodo (Extract Method)

Consiste nel prendere un frammento di codice che svolge un'operazione specifica e raggrupparlo in un nuovo metodo separato, assegnandogli un nome molto esplicativo.

* **Quando si usa:** Per eliminare codice duplicato, accorciare metodi troppo lunghi, migliorare la leggibilità e facilitare l'overriding.
* **Come si applica:** Si crea il nuovo metodo. Le variabili locali del vecchio blocco diventano i *parametri* del nuovo metodo. Le variabili esclusive del frammento diventano variabili locali del nuovo metodo. Se il frammento modifica una variabile che serve al metodo originale, il nuovo metodo deve agire come una *query* (restituendo il valore aggiornato). Infine, si sostituisce il vecchio blocco di codice con la chiamata al nuovo metodo.

### 2. Sostituisci Temp con Query (Replace Temp with Query)

Evita l'utilizzo di variabili temporanee usate solo per conservare il risultato di un'espressione matematica o logica. Si crea invece un metodo (query) che calcola e restituisce quel risultato. Spesso questa tecnica si applica *prima* di "Estrai Metodo".

* **Quando si usa:** Per snellire i metodi ed evitare che una variabile rimanga confinata e nascosta nel contesto locale di un singolo blocco.
* **Come si applica:** Si etichetta la variabile temporanea come `final` per assicurarsi che venga assegnata una sola volta. Si crea un metodo che restituisce la stessa espressione. Si sostituiscono tutte le chiamate a quella variabile con l'invocazione del nuovo metodo.

### 3. Dividi Variabile Temp (Split Temporary Variable)

Risolve il problema delle variabili temporanee che vengono assegnate più volte per scopi diversi (escludendo variabili usate nei cicli o come accumulatori). Una singola variabile deve avere una **sola responsabilità**.

* **Quando si usa:** Quando riutilizzare la stessa variabile per calcoli diversi crea confusione in chi legge il codice.
* **Come si applica:** Si cambia il nome della variabile temporanea alla sua prima assegnazione e la si dichiara `final` (così il compilatore segnalerà come errore eventuali riassegnazioni successive). Si sostituiscono i riferimenti fino alla seconda assegnazione. Dalla seconda assegnazione in poi, si dichiara una *nuova* variabile temporanea con un nome appropriato, ripetendo il processo.

### 4. Sposta Metodo (Move Method)

Si applica quando un metodo utilizza molte più caratteristiche (attributi e metodi) di un'altra classe rispetto a quella in cui è stato originariamente definito.

* **Quando si usa:** Per ridurre l'accoppiamento tra due classi e chiarire la suddivisione delle responsabilità.
* **Come si applica:** Si analizzano gli attributi usati (spostando eventualmente anche quelli). Ci si assicura che il metodo non sia usato da superclassi o sottoclassi. Si crea fisicamente il nuovo metodo nella classe target. Nel vecchio metodo si inserisce un richiamo (delega) al nuovo metodo appena creato, oppure lo si elimina del tutto aggiornando i vecchi riferimenti.

### 5. Estrai Classe (Extract Class)

Si applica quando una singola classe è diventata monolitica e svolge il lavoro che dovrebbe essere diviso tra due o più classi distinte.

* **Quando si usa:** Quando una classe è enorme, poco manutenibile e gestisce sotto-insiemi di dati che cambiano contemporaneamente per motivi legati tra loro.
* **Come si applica:** Si identificano le diverse responsabilità. Si crea una nuova classe specifica per una di esse. Si instaura una dipendenza tra le due (creando un'istanza della nuova classe all'interno della vecchia). Si spostano gradualmente attributi e metodi, partendo sempre dai metodi di livello più basso, e si aggiornano i riferimenti.