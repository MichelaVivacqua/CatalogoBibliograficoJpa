package MichelaVivacqua.dao;

import MichelaVivacqua.entities.Libro;
import MichelaVivacqua.entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Rivista> rivistaPerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Rivista> query = em.createNamedQuery("rivistaPerAnnoPubblicazione", Rivista.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        List<Rivista> riviste = query.getResultList();

        if (!riviste.isEmpty()) {
            System.out.println("Riviste pubblicate nell'anno " + annoPubblicazione + ":");
            for (Rivista rivista : riviste) {
                System.out.println(rivista);
            }
        } else {
            System.out.println("Nessuna rivista trovata pubblicata nell'anno " + annoPubblicazione);
        }

        return riviste;
    }

}
