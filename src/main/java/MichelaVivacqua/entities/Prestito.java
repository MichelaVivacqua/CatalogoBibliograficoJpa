package MichelaVivacqua.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@NamedQuery(
        name = "PrestitiPerUtente",
        query = "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL"
)
@NamedQuery(
        name = "PrestitiScadutiNonRestituiti",
        query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva < CURRENT_DATE AND dataRestituzioneEffettiva<dataRestituzionePrevista"
)
public class Prestito {
@ManyToOne
@JoinColumn(name="utente_id")
@Id

   private Utente utente;
    @ManyToOne
    @JoinColumn(name="isbn_id")
    private ElementoBibliografico elementoPrestato;
    @Column
    private LocalDate dataInizioPrestito;
    @Column
    private LocalDate dataRestituzionePrevista;
    @Column
    private LocalDate dataRestituzioneEffettiva;



    public Prestito() {
    }

    public Prestito(Utente utente, ElementoBibliografico elementoPrestato, LocalDate dataInizioPrestito,  LocalDate dataRestituzioneEffettiva) {
        this.utente=utente;
        this.elementoPrestato=elementoPrestato;
        this.dataInizioPrestito=dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
//        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva=dataRestituzioneEffettiva;

    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoBibliografico getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoBibliografico elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}