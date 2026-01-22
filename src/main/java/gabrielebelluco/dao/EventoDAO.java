package gabrielebelluco.dao;

import gabrielebelluco.entities.Evento;
import gabrielebelluco.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    // (Data Access Object) questo serve per ospittare tutti i metodi comodi come salvare o leggere dei record, richiedono
    // l'uso dell'EntityManager con una certa complessità. il DAO quindi si occupa di nascondere la complessita fornendo a
    // chi ne avrà bisogno dei metodi semplici. inoltre lo dobbiamo importare nel mai con EventoDAO ed = new EventoDAO()
    //(G)##################################################################
    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public void save(Evento newEvento) {
        // questo è un metodo save che prende un evento e lo salva con nome newEvento
        //Per salvare un nuovo oggetto questo deve diventare menaged, e per
        // diventare menaged deve fare un persist e dopo questi due passaggi possiamo
        // fare il commit l'unico problema è che il commit non lo fa l'EntityManager ma
        // viene fatto dalla transazione.
        //(H)##################################################################
        // 1)dunque si va a creare una nuova transazione,
        EntityTransaction transaction = entityManager.getTransaction();
        // 2) la facciamo partire
        transaction.begin();
        //3) aggiungiamo il new Evento al PersistenceContext in quanto esso è nuovo e
        // non ancora Managed. Lo possiamo fare tramite metodo .persist()dell'EntityManager (a questo
        // punto l'oggetto non è ancora parte del DB però)
        entityManager.persist(newEvento);
        //4) successivamente facciamo il commit che vuol dire "luce verde" manda tutto al DB e lui si occuperà di fare l'inserzione
        transaction.commit();
        // 5) volendo poi si può fare il S.o.p
        System.out.println("l'Evento " + newEvento.getTitolo() + " lo hai salvato correttamente");


    }

    // (I)###################################################################################
    // successivamente al metodo save andiamo a fare il metodo findById per questo esiste già un metodo .find
    // che prevede due parametri la classe Entyti nel nostro ca so Evento e l'Id da passargli in cambio ci
    // darà l'oggetto se ce lo trova altrimenti ci tornerà null, quindi una best prac. sarebbe gestire le
    // eccezionicon un custom
    public Evento findById(long EventoId) {

        // che dato un'id ci darà un evento
        Evento found = entityManager.find(Evento.class, EventoId);
        // se non lo trova gestisce eccezione custom che andiamo a creare ora
        // (J)###################################################################################
        if (found == null) throw new NotFoundException(EventoId);
        // altrimenti ritorna l'evento cercato
        return found;
    }

    // public void findByIdAndDelete(long studentId) {
    // che dato un'id ci darà un evento e lo eliminerà

    // }
}
