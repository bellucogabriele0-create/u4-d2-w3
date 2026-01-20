package gabrielebelluco.entities;

import jakarta.persistence.Entity;

//qua andiamo a creare le entities con i rispettivi @Annotazione come:
// @Entity: marchiamo quella classe come "speciale" cioè una tabella che deve essere mappata come tabella
//         perchè non tutte le classi diventeranno tabelle
// @Table: per specificare il nome della tabella omettibile, se omessa prenderà il nome della classe
// @Column: serve per specificare e customizzare gli attributi aggiungere vincoli
// @Id: per identificare la chiave primaria
// @Enumerated: Indica come deve essere mappato un campo corrispondente a una proprietà Enum
// quindi prima di iniziare andiamo a aggiungere in persistence.xml le entities
@Entity
public class Evento {

}
