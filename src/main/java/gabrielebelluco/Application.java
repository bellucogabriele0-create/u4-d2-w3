package gabrielebelluco;

import gabrielebelluco.dao.EventoDAO;
import gabrielebelluco.entities.Evento;
import gabrielebelluco.entities.tipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    // (A)
    // dopo aver aggiunto le dependencies in pom.xml e le properties in persistence.xml
    // (B)
    // aggiungiamo nel main una entity manager factory
    // cioè un oggetto che creerà gli entity manager che mi permetteranno di interagire con DB
    // senza di essi non si collega al DB come un app normale senza DB. aggiungendo questo:
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d2w3");
    // una volta inserito se si avvia il risultato sarà un'errore perchè il server non esiste,
    // quindi ora si va a crearlo in pgAdmin
    // (C)
    // Databases>tasto destro> create> database> u4d2w3 > save.
    //a questo punto andiamo a creare le entities (E)
    // dopo averlo aggiunto aggiungiamo anche ed.save(marragheddon) per salvare l'evento

    //(F)
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
        ed.save(marragheddon);
        //(G)
        // a questo punto però abbiamo il factory nel main e noi lo dobbiamo implementare anche nel DAO
        // e nell'oggetto DAO creato qua andiamo ad aggiungere nel parametro la entityManager
        entityManager.close();
        emf.close();
    }
}
