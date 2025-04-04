package projeto.persistencia;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ServicosDAO {
    
    /* Método para cadastro */
    public void cadastrar (Servicos s) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Servicos> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {            
            String jpql = "SELECT s FROM Servicos s ORDER BY s.tipo";
            return em.createQuery(jpql, Servicos.class).getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
