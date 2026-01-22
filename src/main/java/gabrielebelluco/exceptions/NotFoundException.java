package gabrielebelluco.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        // (J)###################################################################################
        super("il record con id: " + id + " non è stato trovato");
    }
}
