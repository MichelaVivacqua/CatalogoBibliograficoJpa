package MichelaVivacqua.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Prestito {
    private Utente utente;
    private ElementoBibliografico elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;
    @ManyToOne
    @JoinColumn(name="elementoBibliografico_id")
    private ElementoBibliografico elementoBibliografico;

    @OneToMany (mappedBy = "prestito")
    private List<Prestito> prestitoList;

    public Prestito() {
    }

    public Prestito(Utente utente, ElementoBibliografico elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente=utente;
        this.elementoPrestato=elementoPrestato;
        this.dataInizioPrestito=dataInizioPrestito;
        this.dataRestituzionePrevista=dataRestituzionePrevista;
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
}