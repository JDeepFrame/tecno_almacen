package com.miempresa.tecnoalmacen;

import theme.TemaFlatLaf;
import views.VentanaPrincipal;
//IMPORTS PARA PRUEBA DE CONECTIVIDAD JPA(EclipseLink)-BB.DD.
import models.Producto;
import models.JpaUtil;
import jakarta.persistence.EntityManager;
//FIN DE IMPORTS NECESARIOS PARA PRUEBA DE CONECTIVIDAD

public class TecnoAlmacen {

    //Vistas (views)
    private final VentanaPrincipal ventanaPrincipal;

    //Método constructor
    public TecnoAlmacen() {
        //Inicializa vistas
        this.ventanaPrincipal = new VentanaPrincipal();

        //Hace visible la ventana principal
        this.ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        //Aplica el tema antes de cargar interfaces
        TemaFlatLaf.aplicarTema();

        //Inicia todo
        java.awt.EventQueue.invokeLater(() -> new TecnoAlmacen());
        
        
        
        
        //PRUEBA PARA VERIFICAR QUE CONEXION FUNCIONE DE VERDAD (Se puede eliminar dsps...)
        EntityManager em = JpaUtil.getEntityManager();

        System.out.println("Consultando productos...");
        var lista = em.createQuery("SELECT p FROM Producto p", Producto.class)
                      .getResultList();

        lista.forEach(p ->
            System.out.println(p.getIdProducto() + " - " + p.getNombre())
        );

        em.close();
        JpaUtil.shutdown();
        //FIN DE CÓDIGO PARA LA PRUEBA DE CONECTIVIDAD
    }
}
