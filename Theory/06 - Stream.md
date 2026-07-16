Ecco la dispensa completamente ristrutturata per seguire fedelmente l'ordine logico e didattico delle dispense universitarie, con l'aggiunta del capitolo introduttivo dedicato alla definizione e alla filosofia degli stream.

---

# Dispensa Avanzata: Programmazione Funzionale e Java Stream API

## 1. Evoluzione del Linguaggio Java e dei suoi Paradigmi

Il linguaggio Java nasce storicamente come un linguaggio **imperativo e orientato agli oggetti**. Nel corso degli anni, l'evoluzione delle specifiche ha costantemente mirato a semplificare il lavoro dello sviluppatore, astraendo i costrutti ripetitivi e delegandoli alle librerie interne.

* **Java 1.1 (1997):** Introduzione delle **classi anonime** per permettere l'implementazione immediata di interfacce direttamente nel punto di istanziazione.
* **Java 5 (Settembre 2004):** Introduzione del **ciclo for avanzato** (*for-each*), eliminando la necessità di gestire esplicitamente indici di inizio e fine per scorrere array o liste. Vengono inoltre introdotti costrutti avanzati di concorrenza (`Lock`, `Executor`).
* **Java 7 (Luglio 2011):** Introduzione dell'**inferenza dei tipi** per l'istanziazione delle Collection tramite l'operatore diamante `<>`, riducendo la verbosità del codice.
* **Java 8 (Marzo 2014):** Svolta storica con l'integrazione di caratteristiche tipiche della **programmazione funzionale**. Introduzione delle **espressioni lambda**, delle **interfacce funzionali**, dei **metodi di default nelle interfacce** e delle **Stream API**. La programmazione funzionale si dimostra in genere più concisa, espressiva e facile da parallelizzare rispetto alla programmazione a oggetti pura.
* **Java 9 (Settembre 2017):** Introduzione di metodi statici di fabbrica nelle interfacce delle collection come `List.of()`, per la generazione rapida di liste non modificabili.
* **Java 16 & Java 18 (2021-2022):** Introduzione del metodo diretto `Stream.toList()` per ottimizzare la terminazione dei flussi e stabilizzazione dei costrutti di tipo `record` per la modellazione dei dati immutabili.

---

## 2. Stile Imperativo vs Stile Dichiarativo/Funzionale

L'approccio allo sviluppo del software in Java ha subito un cambio di paradigma radicale con il passaggio dallo stile imperativo a quello dichiarativo/funzionale.

### Stile Imperativo

Lo stile imperativo si focalizza sul **come** l'operazione deve essere eseguita. Il programmatore ha il controllo totale del flusso sintattico, ma questo comporta svantaggi in termini di leggibilità e manutenibilità.

* Uso estensivo di cicli esteriori per scorrere le strutture dati.
* Utilizzo di variabili flag booleane e costrutti di interruzione del flusso (`break`, `continue`).
* Alta verbosità: per comprendere l'intento logico di un blocco di codice è necessario analizzare approfonditamente tutti i dettagli implementativi interni al ciclo.

### Stile Dichiarativo e Funzionale

Lo stile dichiarativo sposta l'attenzione sul **cosa** si desidera ottenere, lasciando i dettagli implementativi dell'algoritmo alla libreria sottostante. Lo stile funzionale arricchisce quello dichiarativo introducendo le **funzioni di ordine superiore** (*higher-order functions*), ovvero metodi capaci di accettare altre funzioni come parametri, instanziarle al proprio interno o restituirle come valore di ritorno.

* Il codice risulta più conciso ed espressivo.
* Le funzioni/operazioni elementari sono slegate dallo stato della classe, rendendo intrinsecamente più semplice la parallelizzazione del codice.

### Confronto Pratico: Ricerca in una Lista

L'esempio che segue mostra la ricerca di una stringa all'interno di una lista di nomi nei due stili:

```java
// Implementazione in Stile Imperativo
public void trovaImperativo(List<String> listaNomi) {
    boolean trovato = false; // Flag di stato
    for (String nome : listaNomi) {
        if (nome.equals("Nobi")) {
            trovato = true;
            break; // Interruzione esplicita
        }
    }
    if (trovato) System.out.println("Nobi trovato");
    else System.out.println("Nobi non trovato");
}

// Implementazione in Stile Dichiarativo
public void trovaDichiarativo(List<String> listaNomi) {
    // I dettagli dell'iterazione sono delegati al metodo contains() della libreria
    if (listaNomi.contains("Nobi")) System.out.println("Nobi trovato");
    else System.out.println("Nobi non trovato");
}

```

---

## 3. Classi Anonime vs Espressioni Lambda

Prima di Java 8, l'unico modo per passare un comportamento come parametro a un metodo era incapsularlo in un'istanza di una **classe anonima** che implementasse un'apposita interfaccia. Le espressioni lambda hanno eliminato il codice standard e ripetitivo (*boilerplate*) focalizzandosi unicamente sul comportamento logico.

### Esempio Comparativo

Si consideri un'interfaccia dotata di un unico metodo:

```java
public interface Hello {
    void greetings(String s);
}

```

Ecco come si implementa il comportamento tramite **classe anonima** (approccio pre-Java 8) e tramite **espressione lambda** (Java 8+):

```java
// 1. Approccio con Classe Anonima (Verboso)
Sera srAnonima = new Sera(new Hello() {
    @Override
    public void greetings(String s) {
        System.out.println("Ciao, " + s);
    }
});

// 2. Approccio con Espressione Lambda (Conciso)
Sera srLambda = new Sera(s2 -> System.out.println("Ciao, " + s2));

```

### Proprietà delle Espressioni Lambda

1. **Sintassi Anonima:** È una funzione priva di nome dotata di una lista di parametri (a sinistra del segno freccia `->`) e di un corpo di esecuzione (a destra). È simile a un metodo: possiede parametri, un corpo e un tipo di ritorno.
2. **Parentesi Opzionali e Corpo:** Se la funzione non ha parametri o ne ha più di uno, i parametri vanno racchiusi tra parentesi tonde `()`. Se il corpo contiene più di un'istruzione, occorre racchiuderlo tra parentesi graffe `{}` e inserire esplicitamente l'istruzione `return`.
* *Zero parametri:* `() -> System.out.println("Buongiorno")`
* *Più istruzioni:* `(x, y) -> { System.out.println("x: " + x); return x + y; }`


3. **Inferenza dei Tipi:** Il compilatore Java deduce autonomamente il tipo dei parametri in ingresso analizzando la firma del metodo definito nell'interfaccia di destinazione.
4. **Purezza e Stato:** Nei linguaggi funzionali puri una lambda è una funzione pura (il risultato dipende solo dagli input, senza effetti collaterali o stato). In Java, una lambda può accedere a variabili esterne purché siano finali o *effectively final* (variabili non modificate dopo l'inizializzazione).

---

## 4. Interfacce Funzionali Principali

Un'interfaccia si definisce **interfaccia funzionale** se dichiara **un solo metodo astratto**. Per garantire questa proprietà a livello di compilazione, viene utilizzata l'annotazione `@FunctionalInterface`, la quale impedisce l'aggiunta di ulteriori metodi astratti in future revisioni del codice. Le espressioni lambda in Java istanziano oggetti che implementano queste specifiche interfacce.

### `Predicate<T>`

Rappresenta una funzione che accetta un argomento di tipo `T` e restituisce un valore booleano. Il suo metodo astratto è `test(T t)`. Viene utilizzata principalmente nelle operazioni di filtraggio (`filter`).

```java
Predicate<Integer> positive = x -> x >= 0; // Controlla se il valore è positivo

```

### `Function<T, R>`

Rappresenta una funzione di trasformazione che accetta un parametro di tipo `T` e restituisce un risultato di tipo `R`. Il suo metodo astratto è `apply(T t)`. Trova applicazione naturale nelle operazioni di mappatura (`map`).

```java
Function<String, Integer> stringLength = x -> x.length(); // String in input, Integer in output

```

### `Supplier<T>`

Rappresenta una funzione fornitrice di dati. Non accetta parametri in ingresso e restituisce un valore di tipo `T` tramite il metodo astratto `get()`. Non conserva il dato staticamente, bensì detiene il codice algoritmico per generarlo su richiesta.

```java
Supplier<String> sup = () -> "ciao ciao";

```

### Riferimenti a Metodi (*Method References*)

Introdotta in Java 8, la sintassi con il doppio due punti (`::`) consente di passare il riferimento a un metodo esistente come se fosse un'espressione lambda, riducendo ulteriormente la sintassi standard.

* `Integer::sum` equivale a `(accum, v) -> accum + v`.
* `Persona::getEta` equivale a `p -> p.getEta()`.

---

## 5. Introduzione alle Java Stream API

Le **Stream API** rappresentano un potente strumento dichiarativo introdotto in Java 8 per l'elaborazione di sequenze di elementi (provenienti da Collection, array o canali di I/O).

### Che cos'è uno Stream?

Uno Stream **non è una struttura dati**: non memorizza gli elementi né modifica la sorgente da cui attinge. Si tratta invece di una "conduttura" (*pipeline*) di dati attraverso cui gli elementi scorrono per essere trasformati o computati.

### Architettura e Pipeline di Elaborazione

Una pipeline di stream è composta rigorosamente da tre parti:

1. **Una Sorgente (Source):** Genera il flusso di elementi (es. `lista.stream()`).
2. **Zero o più Operazioni Intermedie (Intermediate Operations):** Trasformano lo stream in un altro stream (es. `filter`, `map`). Sono caratterizzate da una **valutazione lazy** (pigra): non eseguono alcuna elaborazione effettiva finché non viene invocata l'operazione finale. Esse si limitano a memorizzare la ricetta dell'operazione.
3. **Un'Operazione Terminale (Terminal Operation):** Esegue l'effettiva computazione scorrendo gli elementi ed esegue la chiusura della pipeline. Restituisce un risultato finale (un valore primitivo, una collezione, un oggetto `Optional`) o produce un effetto collaterale (`forEach`). Una volta eseguita l'operazione terminale, lo stream è "consumato" e non può più essere riutilizzato.

---

## 6. Iterazione Esterna vs Iterazione Interna

La differenza fondamentale tra il modello classico orientato agli oggetti e il paradigma a stream risiede nella gestione del ciclo di scansione dei dati.

* **Iterazione Esterna:** Nel ciclo *for-each* classico o nell'uso degli `Iterator`, l'iterazione è definita ed eseguita **all'esterno** della struttura dati. Il codice utente deve richiedere esplicitamente ogni elemento e processarlo in sequenza strutturata. Questo vincola l'ordine di esecuzione, richiede la gestione esplicita dello stato ed osta l'ottimizzazione automatica da parte della JVM.
* **Iterazione Interna:** Con le Stream API, l'iterazione è **interna** alla libreria. Il programmatore definisce unicamente l'azione logica da compiere su ogni singolo elemento tramite espressioni lambda. La libreria è così libera di ottimizzare la scansione, ritardando l'esecuzione (*laziness*) o ripartendo il carico di lavoro su più core parallelamente.

---

## 7. Tabella Completa delle Operazioni degli Stream

La seguente tabella riassume in modo esaustivo le operazioni, i metodi e i costruttori dell'ecosistema Stream trattati nelle dispense, classificandoli in base al loro comportamento e alla loro natura valutativa.

| Nome Metodo / Operazione | Tipo di Operazione | Funzionamento Tecnico | Esempio Implementativo |
| --- | --- | --- | --- |
| **`stream()`** | Sorgente / Generazione Stream | Metodo di default dell'interfaccia `Collection`. Restituisce uno `Stream<T>` sequenziale basato sulla collection su cui è invocato. | `nomi.stream()` |
| **`parallelStream()`** | Sorgente / Generazione Stream | Metodo di default di `Collection`. Restituisce possibilmente uno stream parallelo per consentire l'esecuzione concorrente senza gestione manuale di thread. | `nomi.parallelStream()` |
| **`iterate(T seed, UnaryOperator<T> f)`** | Sorgente / Generazione Stream | Metodo statico che crea uno stream infinito e ordinato applicando iterativamente la funzione `f` a partire dal valore `seed`. È un'operazione sequenziale. | `Stream.iterate(2, n -> n * 2).limit(10)` |
| **`generate(Supplier<T> s)`** | Sorgente / Generazione Stream | Metodo statico che produce uno stream infinito di valori disordinati estratti da un'interfaccia funzionale di tipo `Supplier`. Non applica funzioni a cascata. | `Stream.generate(Math::random).limit(5)` |
| **`of(T... values)`** | Sorgente / Generazione Stream | Metodo statico di `Stream` utilizzato per costruire un'istanza di Stream a partire da elementi esplicitamente specificati come varargs. | `Stream.of(2, 5, 10, -1)` |
| **`rangeClosed(int start, int end)`** | Sorgente / Generazione Stream | Metodo statico di `IntStream` che genera una sequenza ordinata di interi nell'intervallo specificato con incremento pari a 1, estremi inclusi. | `IntStream.rangeClosed(1, 6)` |
| **`filter(Predicate<T> p)`** | Operazione Intermedia Stateless | Valutazione *lazy*. Prende in ingresso un predicato (funzione che restituisce un `boolean`) e ritorna un nuovo `Stream` con i soli elementi che lo soddisfano. | `.filter(s -> s.length() == 5)` |
| **`map(Function<T, R> mapper)`** | Operazione Intermedia Stateless | Valutazione *lazy*. Applica la funzione `mapper` a ciascun elemento dello stream, inserendo i singoli risultati in un nuovo stream in uscita. | `.map(Persona::getEta)` |
| **`mapToInt(ToIntFunction<T> mapper)`** | Operazione Intermedia Stateless | Variante di `map` che esegue la funzione passata sugli elementi dello stream sorgente e restituisce un tipo primitivo `IntStream` per evitare l'overhead di boxing. | `.mapToInt(x -> x.length())` |
| **`mapToObj(IntFunction<U> mapper)`** | Operazione Intermedia Stateless | Operazione applicabile a `IntStream` che mappa i valori primitivi interi in uno stream di oggetti (`Stream<U>`). | `.mapToObj(i -> lista.get(i))` |
| **`boxed()`** | Operazione Intermedia Stateless | Converte un `IntStream` primitivo in uno `Stream<Integer>` di oggetti (operazione di *autoboxing*). | `IntStream.rangeClosed(1, 10).boxed()` |
| **`peek(Consumer<T> action)`** | Operazione Intermedia Stateless | Utilizzato principalmente per attività di debug. Consente di visionare gli elementi del flusso passo-passo (eseguendo un `Consumer`) senza consumare o alterare lo stream. | `.peek(x -> System.out.println("after map: " + x))` |
| **`limit(long maxSize)`** | Operazione Intermedia Stateful / Short-circuiting | Interrompe l'elaborazione del flusso o tronca lo stream non appena questo raggiunge la lunghezza massima specificata da `maxSize`. | `.limit(3)` |
| **`sorted(Comparator<T> c)`** | Operazione Intermedia Stateful | Restituisce uno stream con gli elementi ordinati in base al `Comparator` fornito. Richiede la conoscenza dell'intero stream (effetto barriera) per operare. | `.sorted(Comparator.comparing(Persona::nome))` |
| **`distinct()`** | Operazione Intermedia Stateful | Ritorna uno stream privato dei duplicati (basato su `equals`). Deve necessariamente confrontare gli elementi tra loro mantenendo uno stato interno. | `.distinct()` |
| **`count()`** | Operazione Terminale Eager | Forza l'esecuzione delle operazioni della pipeline. Restituisce un valore di tipo `long` pari al numero di elementi rimasti nello stream. | `.count();` |
| **`reduce(T id, BinaryOperator<T> acc)`** | Operazione Terminale Eager | Riduce l'insieme di elementi dello stream a un singolo valore usando un valore identità iniziale e un accumulatore binario (es. somma). | `.reduce(0, (accum, v) -> accum + v);` |
| **`reduce(BinaryOperator<T> acc)`** | Operazione Terminale Eager | Configurazione di riduzione senza valore di identità iniziale. Restituisce un oggetto di tipo `Optional<T>` che risulta vuoto se lo stream è privo di elementi. | `.reduce(Integer::sum)` |
| **`collect(Collector<T, A, R> c)`** | Operazione Terminale Eager | Raggruppa o trasforma gli elementi del flusso accumulandoli all'interno di un contenitore (come una `List` o un `Set`) tramite un oggetto `Collector`. | `.collect(Collectors.toList());` |
| **`forEach(Consumer<T> action)`** | Operazione Terminale Eager | Esegue un'azione (un `Consumer`) su ciascun elemento. Attenzione: su flussi paralleli non garantisce il rispetto dell'ordine degli elementi. | `.forEach(System.out::println);` |
| **`sum()`** | Operazione Terminale Eager | Operazione specifica dei flussi numerici (es. `IntStream`) che calcola e restituisce la somma aritmetica degli elementi del flusso. | `IntStream.rangeClosed(1, 5).sum();` |
| **`max(Comparator<T> c)`** | Operazione Terminale Eager | Individua l'elemento massimo in base al `Comparator` passato. Opera in modo analogo alla `reduce` e restituisce un `Optional<T>`. | `.max(Comparator.comparing(Persona::getEta));` |
| **`findAny()`** | Operazione Terminale Short-circuiting | Restituisce un `Optional` contenente un elemento qualsiasi dello stream. Interrompe l'analisi del flusso non appena trova una corrispondenza (*short-circuiting*). | `.findAny();` |

---

## 8. Programmazione Parallela e Performance delle Collection

Le operazioni intermedie come `map()` e `filter()` sono astrattamente **stateless** (prive di stato interno): l'elaborazione di un elemento non influenza e non dipende da quella degli altri elementi del flusso. Questa caratteristica, unita all'immutabilità dello stream sorgente, facilita la parallelizzazione del calcolo tramite il metodo `parallelStream()`.

Tuttavia, se la lambda passata aggiorna uno stato globale esterno (o una variabile non thread-safe) durante l'esecuzione, l'operazione perde il requisito di *stateless*, introducendo gravi problemi di corsa critica (*race condition*).

Le prestazioni complessive di un'architettura a stream paralleli dipendono strettamente da quattro fattori concorrenti:

1. **Numero di elementi** presenti nello stream.
2. **Operazioni complessive** da svolgere nella pipeline.
3. **Hardware** a disposizione (es. numero di core della CPU).
4. **Tipo di Collection** sottostante su cui il flusso viene originato.

### Caratteristiche di Accesso e Comportamento Temporale delle Collection

Il comportamento dei flussi paralleli varia considerevolmente a seconda della struttura dati d'origine a causa dei tempi di accesso ai singoli elementi e della facilità con cui la struttura può essere suddivisa (tramite `Spliterator`):

| Struttura Dati | Accesso in Lettura (`get`) | Operazione `add` | Operazione `contains` | Impatto con `parallelStream()` |
| --- | --- | --- | --- | --- |
| **`ArrayList`** | Costante $O(1)$ | Costante (array espandibile del 50%) | Lineare $O(n)$ | **Ottimo:** Gli elementi sono contigui in memoria; la scomposizione del carico di lavoro (*splitting*) tra i core è immediata, esatta e perfettamente bilanciata. |
| **`Vector`** | Costante $O(1)$ | Costante (analogo ad `ArrayList`) | Lineare $O(n)$ | **Buono:** Prestazioni paragonabili ad `ArrayList`, sebbene sia intrinsecamente sincronizzato (`synchronized`), introducendo un piccolo overhead di blocco. |
| **`LinkedList`** | Lineare $O(n)$ | Costante $O(1)$ | Lineare $O(n)$ | **Scarso:** Poiché ogni nodo ha riferimenti sequenziali al successivo, lo splitting è inefficiente. Le prestazioni faticano a migliorare (o peggiorano) anche su CPU multi-core. |
| **`TreeSet`** | Non supportato direttamente tramite indice | Logaritmico $O(\log n)$ | Logaritmico $O(\log n)$ | **Buono:** La struttura ad albero permette una scomposizione binaria discretamente efficiente sulle computazioni parallele su grandi moli di dati. |

---

## 9. Esempio Applicativo Completo: Elaborazione Dati Aziendali

Il seguente blocco di codice mostra un esempio reale e integrato basato sugli esempi delle dispense per la gestione e l'elaborazione finanziaria di un team aziendale, sfruttando record, mappature, ordinamenti e riduzioni funzionali.

```java
import java.util.*;
import java.util.stream.*;

public class GestioneTeam {

    // Definizione dei Record per la modellazione dei dati immutabili (Java 16+)
    public record Persona(String nome, int eta, String ruolo) {}
    public record BustaPaga(Persona dipendente, int totale) {}

    private final List<Persona> team = List.of(
        new Persona("K Gray", 29, "CTO"),
        new Persona("L Rose", 25, "Programmer"),
        new Persona("Al White", 25, "Programmer"),
        new Persona("Joe Black", 26, "Programmer"),
        new Persona("Jill Purple", 26, "Tester"),
        new Persona("Bill Green", 20, "Analyst")
    );

    // Mappatura dei costi orari/mensili per ruolo aziendale
    private final Map<String, Integer> roleCost = Map.of(
        "Programmer", 50,
        "CTO", 65,
        "Tester", 56,
        "Analyst", 54
    );

    private List<BustaPaga> buste;

    // 1. Generazione delle buste paga, ordinamento alfabetico per nome dipendente e raccolta in lista
    public void generaListaPagamenti() {
        this.buste = team.stream()
            .map(pers -> new BustaPaga(
                pers, 
                roleCost.getOrDefault(pers.ruolo(), 50) * 25 // Calcolo costo (stateless)
            ))
            .sorted(Comparator.comparing(busta -> busta.dipendente().nome())) // Ordinamento (stateful)
            .collect(Collectors.toList()); // Operazione terminale eager
    }

    // 2. Calcolo del bilancio complessivo aziendale tramite map-reduce
    public int calcolaSommaTotaleBuste() {
        return buste.stream()
            .map(BustaPaga::totale)                 // Estrazione importo (stateless)
            .reduce(0, Integer::sum);              // Somma algebrica (terminale eager)
    }

    // 3. Stampa dei dettagli aziendali filtrati per ruolo con l'ausilio di peek per il debug
    public void stampaRuoliEPersone() {
        roleCost.keySet().stream()
            .sorted()
            .peek(role -> System.out.print("\nRuolo: " + role + " -> Iscritti: ")) // Debug intermedio (stateless)
            .forEach(role -> team.stream()
                .filter(pers -> pers.ruolo().equals(role))
                .sorted(Comparator.comparing(Persona::nome))
                .forEach(pers -> System.out.print(pers.nome() + "; "))
            );
    }
}

```