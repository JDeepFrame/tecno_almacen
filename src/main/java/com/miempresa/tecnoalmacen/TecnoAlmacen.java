package com.miempresa.tecnoalmacen;

import theme.TemaFlatLaf;
import views.VentanaPrincipal;

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
    }
}
