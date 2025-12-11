package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import models.JpaUtil;
import models.Producto;

public class ProductoDAO {

    public void guardar(Producto p) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (p.getIdProducto() == null) {
                em.persist(p);
            } else {
                // merge devuelve la entidad gestionada; opcionalmente reasignar
                em.merge(p);
            }
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    // eliminar por id — si lo usas en algún sitio
    public void eliminar(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producto p = em.find(Producto.class, id);
            if (p != null) em.remove(p);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    // eliminar por entidad — útil cuando vienes del TableModel
    public void eliminar(Producto p) {
        if (p == null || p.getIdProducto() == null) return;
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producto managed = em.find(Producto.class, p.getIdProducto());
            if (managed != null) em.remove(managed);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public List<Producto> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }
}
