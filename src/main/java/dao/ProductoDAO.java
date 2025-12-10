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
                em.merge(p);
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producto p = em.find(Producto.class, id);
            if (p != null) em.remove(p);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public List<Producto> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
    
}