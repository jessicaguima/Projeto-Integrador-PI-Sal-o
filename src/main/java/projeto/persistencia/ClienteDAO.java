package projeto.persistencia;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    
    /* Método para cadastro */
    public void cadastrar (Cliente c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public Cliente buscarPorNome(String nome) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // Query para buscar cliente por nome (case insensitive)
        List<Cliente> clientes = em.createQuery(
            "SELECT c FROM Cliente c WHERE LOWER(c.nome) = LOWER(:nome)", 
            Cliente.class)
            .setParameter("nome", nome)
            .getResultList();
            
        return clientes.isEmpty() ? null : clientes.get(0);
    } finally {
        JPAUtil.closeEntityManager();
    }
}
}
