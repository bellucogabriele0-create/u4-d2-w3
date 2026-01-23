package gabrielebelluco.dao;

import gabrielebelluco.entities.Persona;
import gabrielebelluco.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void savePersona(Persona newPersona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newPersona);
        transaction.commit();
        System.out.println("la Persona " + newPersona.getPersonaId() + " è stato salvato ");

    }

    public Persona findById(String personaId) {
        Persona found = em.find(Persona.class, UUID.fromString(personaId));
        if (found == null) throw new NotFoundException(personaId);
        return found;
    }
}
