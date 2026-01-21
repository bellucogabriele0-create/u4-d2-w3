package gabrielebelluco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    // dopo aver aggiunto le dependencies in pom.xml e le properties in persistence.xml
    // aggiungiamo nel main una entity manager factory
    // cioè un oggetto che creerà gli entity manager che mi permetteranno di interagire con DB
    // senza di essi non si collega al DB come un app normale senza DB. aggiungendo questo:
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d2w3");
    // una volta inserito se si avvia il risultato sarà un'errore perchè il server non esiste,
    // quindi ora si va a crearlo in pgAdmin Databases>tasto destro> create> database> u4d2w3 > save.
    //a questo punto andiamo a creare le entities

    // una volta create le entities, con i vari metodi e i due costruttori torniamo qua in main
    // e  andiamo ad aggiungere un punto di mezzo tra il file modificato e il file in modifica
    // grazie alle entityManager dentro il main
    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager(); // questo è l'oggetto che gestisce tutte le
        // interazioni con il DB è buona prassi chiudere le risorse come scanner, entitymanager e EntityManagerFactory
        // e sarebbe opportuno aggiungere un metodo save() che serve per i controlli da fare aggiunga dati a questo
        // evento, che faccia il persist faccia il commit facci un S.o.p di avvenuto successo, mi
        // gestisca le eccezioni ovvero il DAO per fare ciò creeremo la cartella DAO con il file EventoDAO
        entityManager.close();
        emf.close();
    }
}
