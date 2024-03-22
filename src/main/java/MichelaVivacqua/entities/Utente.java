package MichelaVivacqua.entities;

import java.time.LocalDate;

public class Utente {
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private Long numeroDiTessera;

    public Utente (){}

    public Utente (String nome, String cognome, LocalDate dataDiNascita, Long numeroDiTessera){
        this.nome=nome;
        this.cognome=cognome;
        this.dataDiNascita=dataDiNascita;
        this.numeroDiTessera=numeroDiTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Long getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(Long numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }
}
