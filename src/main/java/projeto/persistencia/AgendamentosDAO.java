package projeto.persistencia;

import jakarta.persistence.EntityManager;
import java.util.List;

public class AgendamentosDAO {
    
    /* Método para cadastro */
    public void cadastrar(Agendamentos a) {
        if (a.getCliente().getId() == 0 || a.getServico().getId() == 0) {
            throw new IllegalArgumentException("Cliente e Serviço devem já estar cadastrados no banco.");
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Atrela o cliente e serviço ao agendamento (evitando entidades detached)
            a.setCliente(em.merge(a.getCliente()));
            a.setServico(em.merge(a.getServico()));

            em.persist(a);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Agendamentos> listarAgendamentosCompletos() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String jpql = "SELECT a FROM Agendamentos a " +
                     "JOIN FETCH a.cliente c " +
                     "JOIN FETCH a.servico s " +
                     "ORDER BY a.data DESC, a.hora DESC";
        
        return em.createQuery(jpql, Agendamentos.class).getResultList();
    } finally {
        JPAUtil.closeEntityManager();
    }
}
    
   
}
