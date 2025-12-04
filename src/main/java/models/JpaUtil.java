package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {

    private static EntityManagerFactory emf;

    // Constructor privado para evitar instancias
    private JpaUtil() {}

    // Singleton para el EntityManagerFactory
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            synchronized (JpaUtil.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory("TecnoAlmacenPU");
                }
            }
        }
        return emf;
    }

    // Método práctico para obtener un EntityManager nuevo
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    // Cerrar la fábrica al apagar el programa
    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
