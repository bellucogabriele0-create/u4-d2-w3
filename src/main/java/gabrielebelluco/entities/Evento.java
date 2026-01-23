package gabrielebelluco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

// (D)##################################################################
// qua andiamo a creare le entities con i rispettivi @Annotazione come:
// @Entity: marchiamo quella classe come "speciale" cioè una tabella che deve essere mappata come tabella
//         perchè non tutte le classi diventeranno tabelle
// @Table: per specificare il nome della tabella omettibile, se omessa prenderà il nome della classe
// @Column: serve per specificare e customizzare gli attributi aggiungere vincoli
// @Id: per identificare la chiave primaria
// @Enumerated: Indica come deve essere mappato un campo corrispondente a una proprietà Enum
// (E)##################################################################
// quindi prima di iniziare andiamo a aggiungere in persistence.xml le entities
@Entity
//questa è obbligatoria. ci serve per definire che dovrà essere mappata in una specifica tabella nel DB, Hibernate se ne occuperà in automati. se è già presente proverà a modificarla secondo quanto trovato in questa classe se usiamo l'impostazione <property name="hibernate.hbm2ddl.auto" value="update"/> in Persistence.xml
@Table(name = "evento") // non obbligatorio ma buona prassi
public class Evento {
    @Id //obbligatoria. Dichiaro che questo attributo dovrà corrispondere alla colonna PRIMARY KEY della tabella Evento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Annotazione OPZIONALE però molto consigliata. auto crea i bigserial
    private long id;
    @Column(name = "titolo", nullable = false) // possiamo aggiungere anche la lunghezza con length= 30
    private String titolo;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;
    @Column(name = "tipoEvento", nullable = false)
    @Enumerated(EnumType.STRING) // gli enum vengono convertiti in smallint ma a noi serve la stringa
    private tipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;

    }

    public Evento() { // avere un costruttore vuoto è obbligatorio per tutte le entities avere un costruttore vuoto!
        // Viene usato da Jpa per costruire degli oggetti quando leggeremo delle righe dalle tabelle
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public long getId() {
        return id;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "dataEvento=" + dataEvento +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                '}';
    }
}
