package gabrielebelluco.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "partecipazione_Id")
    private UUID partecipazioneId;
    private String persona;
    private String evento;
    private String stato;

    public Partecipazione() {

    }

    public Partecipazione(String persona, String evento) {
        this.persona = persona;
        this.evento = persona;
    }

    public UUID getPartecipazioneId() {
        return partecipazioneId;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    
    @Override
    public String toString() {
        return "Partecipazione{" +
                "partecipazioneId=" + partecipazioneId +
                ", persona='" + persona + '\'' +
                ", evento='" + evento + '\'' +
                ", stato='" + stato + '\'' +
                '}';
    }
}
