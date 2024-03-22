package MichelaVivacqua.entities;

import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "rivistaPerAnnoPubblicazione",
        query = "SELECT r FROM Rivista r WHERE r.annoPubblicazione = :annoPubblicazione"
)
public class Rivista extends ElementoBibliografico{

   @Enumerated (EnumType.STRING)
    @Column
   private TipoRivista tipoRivista;

   public Rivista (){}
    public Rivista(long isbn, String titolo, int annoPubblicazione, long numeroPagine, TipoRivista tipoRivista) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.tipoRivista=tipoRivista;
    }

    public TipoRivista getTipoRivista() {
        return tipoRivista;
    }


    @Override
    public String toString() {
        return "Rivista{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", tipoRivista=" + tipoRivista +
                '}';
    }
}
