package gabrielebelluco;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    // dopo aver aggiunto le dependencies in pom.xml e le properties in persistence.xml
    // aggiungiamo nel main una entity manager factory
    // cioè un oggetto che creerà gli entity manager che mi permetteranno di interagire con DB
    // senza di essi non si collega al DB come un app normale senza DB. aggiungendo questo:
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d2w3");
    // una volta inserito se si avvia il risultato sarà un'errore perchè il server non esiste,
    // quindi ora si va a crearlo in pgAdmin Databases>tasto destro> create> database> u4-d1-w3 > save.


    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
}
