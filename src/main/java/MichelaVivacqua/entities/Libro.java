package MichelaVivacqua.entities;


import com.github.javafaker.Faker;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Libro extends ElementoBibliografico  {

    @Column
    private String autore;
    @Column
    private String genere;

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }


    public Libro(long isbn, String titolo, int annoPubblicazione, long numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore=autore;
        this.genere=genere;


    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }


}
