package MichelaVivacqua.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
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
