package gabrielebelluco.dao;

import gabrielebelluco.entities.Location;
import gabrielebelluco.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLocation(Location newLocation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newLocation);
        transaction.commit();
        System.out.println("la Location " + newLocation.getLocationId() + " è stata salvata ");


    }

    public Location findById(String locationId) {
        Location found = em.find(Location.class, UUID.fromString(locationId));
        if (found == null) throw new NotFoundException(locationId);
        return found;
    }
}