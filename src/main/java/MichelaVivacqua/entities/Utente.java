package MichelaVivacqua.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private LocalDate dataDiNascita;
    @Id
    @Column
    @GeneratedValue
    private Long numeroDiTessera;
@OneToMany(mappedBy = "utente")
private List<Prestito> prestitoList;

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
