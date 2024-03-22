package MichelaVivacqua.dao;

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
}
