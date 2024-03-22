package MichelaVivacqua.dao;

import MichelaVivacqua.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibriDAO {

    private final EntityManager em;

    public LibriDAO(EntityManager em) {this.em = em;}

    public void save(Libro libro) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(libro);
        transaction.commit();
        System.out.println("Libro " + libro.getTitolo() + " aggiunto correttamente al database!");
    }

//    public Libro findByIsbn(long isbn) {
//        Libro libro = em.find(Libro.class, isbn);
//        return libro;
//    }

    public Libro findByIsbn(long isbn) {
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            System.out.println("Libro con isbn " + isbn + ":"  + libro);
        } else {
            System.out.println("Nessun libro trovato con l'ISBN: " + isbn);
        }
        return libro;
    }
    public void deleteByIsbn (long isbn) {
        Libro found = this.findByIsbn(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Libro con ISBN " + found.getIsbn() + " eliminato correttamente dal database!");

    }


}



