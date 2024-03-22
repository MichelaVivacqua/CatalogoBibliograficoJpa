package MichelaVivacqua.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="elemento_bibliografico")
@Inheritance (strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoBibliografico {
    @Id
    @Column
//    @GeneratedValue
    protected long isbn;
    @Column
    protected String titolo;
    @Column
    protected int annoPubblicazione;
    @Column
    protected long numeroPagine;
    @OneToMany(mappedBy = "isbn")
    private List<ElementoBibliografico> elementoBibliograficoList;
    public ElementoBibliografico(){}

    public ElementoBibliografico(long isbn, String titolo, int annoPubblicazione, long numeroPagine) {
        this.isbn = isbn;
        this.titolo=titolo;
        this.annoPubblicazione=annoPubblicazione;
        this.numeroPagine=numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoBibliografico{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public long getNumeroPagine() {
        return numeroPagine;
    }

}
