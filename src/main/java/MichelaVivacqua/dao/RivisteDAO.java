package MichelaVivacqua.dao;

import MichelaVivacqua.entities.Libro;
import MichelaVivacqua.entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RivisteDAO {
    private final EntityManager em;
    public RivisteDAO(EntityManager em){
        this.em=em;
    }
    public void save (Rivista rivista){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(rivista);
        transaction.commit();
        System.out.println("Rivista "+rivista.getTitolo()+" aggiunta al database");
    }

//    public Rivista findByIsbn(long isbn) {
//        Rivista rivista = em.find(Rivista.class, isbn);
//        return rivista;
//    }

    public Rivista findByIsbn(long isbn) {
        Rivista rivista = em.find(Rivista.class, isbn);
        if (rivista != null) {
            System.out.println("Rivista con isbn " + isbn + ":"  + rivista);
        } else {
            System.out.println("Nessuna rivista trovata con l'ISBN: " + isbn);
        }
        return rivista;
    }

    public void deleteByIsbn (long isbn) {
        Rivista found = this.findByIsbn(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Rivista con ISBN " + found.getIsbn() + " eliminata correttamente dal database!");

    }
}
