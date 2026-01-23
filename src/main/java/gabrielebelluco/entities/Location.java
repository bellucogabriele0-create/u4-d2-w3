package gabrielebelluco.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_Id")
    private UUID locationId;
    @Column(nullable = false)
    private String nome;
    private String citta;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getLocationId() {
        return locationId;
    }


    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
