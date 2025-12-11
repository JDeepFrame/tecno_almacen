package dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import models.JpaUtil;
import models.Proveedor;

public class ProveedorDAO {
    public List<Proveedor> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void guardar(Proveedor p) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Proveedor p) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            p = em.merge(p);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
