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

    public Partecipazione(String persona, String evento) {
        this.persona = persona;
        this.evento = persona;
    }


}
