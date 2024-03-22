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


}



