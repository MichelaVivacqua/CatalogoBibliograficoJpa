package MichelaVivacqua;

import MichelaVivacqua.dao.LibriDAO;
import MichelaVivacqua.dao.RivisteDAO;
import MichelaVivacqua.entities.Libro;
import MichelaVivacqua.entities.Rivista;
import MichelaVivacqua.entities.TipoRivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LibriDAO ld = new LibriDAO(em);
//        Libro libro1= new Libro(123456789,"La mia autobiografia",1999,142,"michela vivacqua","commedia");
//        Libro libro2= new Libro(12345678,"La mia disperazione",2024,1400,"michela vivacqua","dramma");
//        Libro libro3= new Libro(12345689,"La mia vittoria, sono una backender",2024,135,"michela vivacqua","romantico");
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

//        ld.findByIsbn(12345689);
//        rd.findByIsbn(14567891);
//
//        ld.deleteByIsbn(12345689);
//        rd.deleteByIsbn(14567891);

        em.close();
        emf.close();

    }
}
