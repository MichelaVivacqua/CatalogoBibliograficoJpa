package MichelaVivacqua;

import MichelaVivacqua.dao.LibriDAO;
import MichelaVivacqua.dao.PrestitiDAO;
import MichelaVivacqua.dao.RivisteDAO;
import MichelaVivacqua.dao.UtentiDAO;
import MichelaVivacqua.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LibriDAO ld = new LibriDAO(em);
        Libro libro1= new Libro(123456789,"La mia autobiografia",1999,142,"michela vivacqua","commedia");
        Libro libro2= new Libro(12345678,"La mia disperazione",2024,1400,"michela vivacqua","dramma");
        Libro libro3= new Libro(12345689,"La mia vittoria, sono una backender",2024,135,"michela vivacqua","romantico");
//        ld.save(libro1);
//        ld.save(libro2);
//        ld.save(libro3);

        RivisteDAO rd = new RivisteDAO(em);
//        Rivista primarivista = new Rivista(1234567891,"Le mie avventure in backend",2024,234567, TipoRivista.MENSILE);
//        Rivista secondarivista = new Rivista(14567891,"Vi racconto i miei venerdì",2024,234, TipoRivista.MENSILE);
//        Rivista terzarivista = new Rivista(1567891,"Il mio amore per il backend",2024,567, TipoRivista.SEMESTRALE);
//        rd.save(primarivista);
//        rd.save(secondarivista);
//        rd.save(terzarivista);
//
//        ld.deleteByIsbn(12345678);
//        rd.deleteByIsbn(1567891);

        Libro libro12=ld.findByIsbn(12345689);
        Rivista rivista23=rd.findByIsbn(14567891);
//
//        ld.deleteByIsbn(12345689);
//        rd.deleteByIsbn(14567891);

        rd.rivistaPerAnnoPubblicazione(2024);
        ld.libroPerAnnoPubblicazione(1999);

        ld.libroPerAutore("michela vivacqua");

        rd.rivistaPerTitolo("avventure");
        ld.libroPerTitolo("mia");

        PrestitiDAO pd = new PrestitiDAO(em);
        UtentiDAO ud = new UtentiDAO(em);

//        Utente michela = new Utente("Michela","Vivacqua", LocalDate.parse("1999-07-04"));
//        Utente giancarlo = new Utente("Giancarlo","Giannone",LocalDate.parse("1997-01-09"));
//        Utente manuel = new Utente("Manuel","Vivacqua",LocalDate.parse("2005-03-29"));
//        ud.save(michela);
//        ud.save(giancarlo);
//        ud.save(manuel);
        Utente michela = ud.findById(1);
        Utente giancarlo = ud.findById(2);
        Utente manuel = ud.findById(52);

        // Utilizza l'utente recuperato per creare un prestito
        Prestito prestito1 = new Prestito(michela, rivista23, LocalDate.of(2024, 1, 1),  LocalDate.of(2024, 3, 1));
        Prestito prestito2 = new Prestito(giancarlo, libro12, LocalDate.of(2024, 1, 1),  LocalDate.of(2024, 2, 3));
//        Prestito prestito3 = new Prestito(manuel, rivista23, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 2));

//        System.out.println(prestito2);
//        pd.save(prestito1);
//        pd.save(prestito2);
//        pd.save(prestito3);

pd.PrestitiPerUtente(2);
pd.PrestitiScadutiNonRestituiti();

        em.close();
        emf.close();

    }
}
