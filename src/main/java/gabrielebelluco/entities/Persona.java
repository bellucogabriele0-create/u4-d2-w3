package gabrielebelluco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "persona")
public class Persona {
    // (M)###############################################################################################################
// questo è il primo file che ho creato perchè per comodità delle altre fk quindi gli metto la Entity poi la
// Table con name custom e all'interno andiamo a iniziare con l'id e il GeneratedValue che di default è AUTO
//poi costruttori, i vari getter e setter e il toString rimuovendo il set sull'ID
    @Id
    @GeneratedValue
    @Column(name = "persona_Id")
    private UUID personaId;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String sesso;
    private String listaPartecipazioni;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public UUID getPersonaId() {
        return personaId;
    }

    public String getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(String listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "personaId=" + personaId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso='" + sesso + '\'' +
                ", listaPartecipazioni='" + listaPartecipazioni + '\'' +
                '}';
    }
}
