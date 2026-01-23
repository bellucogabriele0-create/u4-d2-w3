package gabrielebelluco.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        // (J)###################################################################################
        super("il record con id: " + id + " non è stato trovato");
    }

    public NotFoundException(long id) { // questo è stato aggiunto per il locationDAO che mi richiede un long e non un id
        super("il record con id: " + id + " non è stato trovato");
    }
}
