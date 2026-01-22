package gabrielebelluco;

import gabrielebelluco.dao.EventoDAO;
import gabrielebelluco.entities.Evento;
import gabrielebelluco.entities.tipoEvento;
import gabrielebelluco.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    // (A)##################################################################
    // dopo aver aggiunto le dependencies in pom.xml e le properties in persistence.xml
    // (B)##################################################################
    // aggiungiamo nel main una entity manager factory
    // cioè un oggetto che creerà gli entity manager che mi permetteranno di interagire con DB
    // senza di essi non si collega al DB come un app normale senza DB. aggiungendo questo:
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d3w3");
    // una volta inserito se si avvia il risultato sarà un'errore perchè il server non esiste,
    // quindi ora si va a crearlo in pgAdmin
    // (C)##################################################################
    // Databases>tasto destro> create> database> u4d2w3 > save.
    //a questo punto andiamo a creare le entities (E)##################################################################
    // dopo averlo aggiunto aggiungiamo anche ed.save(marragheddon) per salvare l'evento

    //(F)##################################################################
    // una volta create le entities, con i vari metodi e i due costruttori torniamo qua in main
    // e  andiamo ad aggiungere un punto di mezzo tra il file modificato e il file in modifica
    // grazie alle entityManager dentro il main
    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager(); // questo è l'oggetto che gestisce tutte le
        // interazioni con il DB è buona prassi chiudere le risorse come scanner, entitymanager e EntityManagerFactory
        // e sarebbe opportuno aggiungere un metodo save() che serve per i controlli da fare aggiunga dati a questo
        // evento, che faccia il persist faccia il commit facci un S.o.p di avvenuto successo, mi
        // gestisca le eccezioni ovvero il DAO per fare ciò creeremo la cartella DAO con il file EventoDAO
        EventoDAO ed = new EventoDAO(entityManager);//(G.2) parametro la entityManager
        Evento marragheddon = new Evento("marragheddon", "bello", tipoEvento.PUBBLICO);
        Evento redValley = new Evento("red valley", "non perderlo", tipoEvento.PRIVATO);
        Evento namless = new Evento("namless", "questo brutto ", tipoEvento.PUBBLICO);
        Evento milanoconcerto = new Evento("milanoconcerto", "questo pessimo ", tipoEvento.PUBBLICO);
        //ed.save(marragheddon); // questi una volta utilizzati correttamente sarebbe meglio eliminarli/commentarli per
        //ed.save(namless);     // evitare che vengano salvati elementi doppi nella tabella
        //ed.save(redValley);
        ed.save(milanoconcerto);
        //(G)##################################################################
        // a questo punto però abbiamo il factory nel main e noi lo dobbiamo implementare anche nel DAO
        // e nell'oggetto DAO creato qua andiamo ad aggiungere nel parametro la entityManager
        //(J.2)##################################################################
        // successivamente alla creazione del findById in EventoDAO lo richiamiamo qua nel main che ci
        // dovrebbe tornare MarragheddonFromDB in un try catch per evitare errori semplicemente con:
        try {
            Evento MarragheddonFromDB = ed.findById(4);
            System.out.println(MarragheddonFromDB);
        } catch (NotFoundException exception) {
            System.out.println(exception.getMessage());
            // successivamente possiamo impostare anche la findByIdAndDelete in EventoDAO
            //(K)##################################################################

        }
        //(L)##################################################################
        // qua iplementiamo il findByIdAndDelete in un try catch in modo da evitare errori
        try {
            ed.findByIdAndDelete(4);
        } catch (NotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        entityManager.close();
        emf.close();
    }
}
//(u4-d3-w3)##################################################################
// in questa lezione vedremo che:
// 1) I "serial" sono per id di progetti piccoli o medi invece per id di codice più grande si usa UUID che crea codice alfanumerico
// 2) useremo le @Generetedvalue che permette di definire una strategia di generazione, che indica a Hibernate in che
// modo gestire la valorizzazione della chiave univoca dell'entità essa suporta le seguenti modalità di gestione:
// @Identity: l'Id viene gestito tramite auto-increment
// @Sequence: vengono utilizzate delle sequenze custom
// @Table: viene utilizzata una tabela per simulare l'utilizzo delle sequenze in database non compatibili con esse
// @Auto: hibernate sceglie in base al DB sottostante una delle precendetnti strategie
// 3) mapping delle relazioni: Esistono varie tipologie di relazioni, definite dal numero
// di elementi presenti ad ogni capo della relazione stessa :
// One-to-One: questa è un tipo di relazione di cui ogni entità in un lato della relazione associata a una sola entità nell'altro lato: per esempio
// Persona e passaporto un passaporto apartiene a una sola persona e una persona ha un solo passaporto ma ci potrebbe essere il caso in cui una persona
// ha più passaporti quindi bisogna guardarla da entrambe le parti Auto ↔ Numero di Telaio / Carta d’identità ↔ Cittadino / Contatore elettrico ↔ Abitazione
// esistono due tipi principali Embedded che non useremo e le altre che useremo unidirezionali e bidirezionali, il concetto di
// unidirezionali partendo da:
// Persone e Passport che sono due entità quindi due tabelle e qui si aprirà un bivio, non solo per le one to one ma, per tutte c'è questo conceto. quindi,
// tornando all'esempio del passaporto e persona, una volta create le due tabelle io nella cartella passaporto voglio anche la chiave esterna per
// definire la chiave esterna io dovrò andare amettere un riferimento ALL'ALTRA entità cioè un'attributo del tipo dell'altra entità (Private Person person[se
// metessimo solo questo ci darebbe un'errore ma dovremmo mettere anche un'annotazione @OneToOne e già questi due stabilirà il filo conduttore delle due
// tabelle e già a livello di tabelle mi creerà una chiave esterna{una cosa molto importante è che se io leggo i dati di un passaporto tramite un semplice
// getter riesco a prendere i dati della persona per questo è di tipo Person perchè grazie i getter riusciamo ad accedere ai dati dall'altra parte }])
// il concetto di bidirezionalità:a livello di tabelle NON cambia nulla sono identiche sia a livello direzionale che bidirezionale ma cambia solo lato di Java
//quindi NON E' CHE se la faccio bidirezionale mi esce una colonna extra bensì dovremmo aggiungere (private Passport passport nella tabella Person[mentre per
// quanto riguarda il OnetoOne risce a capire quale tra le due ha il collegamento virtuale grazie al "parametro"{@OneToOne(mappedBy = "person")}]) questo è
// molto utile per Java e JPA perchè serve per fare in modo che se devo recuperare i dati dell passport di una persona con il getter dentro Person riesco a
// recuperare anche il passport di quella persona, dunque se volessimo questo "plus"possiamo utilizzare la bidirezionalità Person ↔ Passport e Passport ↔
// Person ma solo Passport avrà la colonna FK [@JoinColumn è per la personalizzazione della colonna utile anche per capire meglio dove sta la colonna]
//
// One-to-many
// many-to-many
// Uno degli errori più classici è quello di fare il ragionamento solo da un lato ma bisogna vedere entrambi i lati se hanno relazioni nella one to one (a-b e b-a)
