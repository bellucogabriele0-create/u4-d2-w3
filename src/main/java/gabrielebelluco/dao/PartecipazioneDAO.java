package gabrielebelluco.dao;

import gabrielebelluco.entities.Partecipazione;
import gabrielebelluco.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void savePartecipazione(Partecipazione newPartecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newPartecipazione);
        transaction.commit();
        System.out.println("la partecipazione " + newPartecipazione.getPartecipazioneId() + " è stata salvata ");

    }

    public Partecipazione findById(String partecipazioneId) {
        Partecipazione found = em.find(Partecipazione.class, UUID.fromString(partecipazioneId));
        if (found == null) throw new NotFoundException(partecipazioneId);
        return found;
    }
}