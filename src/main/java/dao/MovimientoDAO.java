package dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import models.JpaUtil;
import models.MovimientoInventario;

public class MovimientoDAO {
    
    public List<MovimientoInventario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT m FROM MovimientoInventario m", MovimientoInventario.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void guardar(MovimientoInventario m) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(MovimientoInventario m) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            m = em.merge(m);
            em.remove(m);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}