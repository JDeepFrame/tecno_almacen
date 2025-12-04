/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author java
 */
@Entity
@Table(name = "alerta_stock", catalog = "inventario_electronica", schema = "")
@NamedQueries({
    @NamedQuery(name = "AlertaStock.findAll", query = "SELECT a FROM AlertaStock a"),
    @NamedQuery(name = "AlertaStock.findByIdAlerta", query = "SELECT a FROM AlertaStock a WHERE a.idAlerta = :idAlerta"),
    @NamedQuery(name = "AlertaStock.findByFechaAlerta", query = "SELECT a FROM AlertaStock a WHERE a.fechaAlerta = :fechaAlerta"),
    @NamedQuery(name = "AlertaStock.findByNivelStock", query = "SELECT a FROM AlertaStock a WHERE a.nivelStock = :nivelStock"),
    @NamedQuery(name = "AlertaStock.findByEstado", query = "SELECT a FROM AlertaStock a WHERE a.estado = :estado")})
public class AlertaStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alerta", nullable = false)
    private Integer idAlerta;
    @Basic(optional = false)
    @Column(name = "fecha_alerta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlerta;
    @Basic(optional = false)
    @Column(name = "nivel_stock", nullable = false)
    private int nivelStock;
    @Column(name = "estado", length = 9)
    private String estado;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idProducto;

    public AlertaStock() {
    }

    public AlertaStock(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public AlertaStock(Integer idAlerta, Date fechaAlerta, int nivelStock) {
        this.idAlerta = idAlerta;
        this.fechaAlerta = fechaAlerta;
        this.nivelStock = nivelStock;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    public int getNivelStock() {
        return nivelStock;
    }

    public void setNivelStock(int nivelStock) {
        this.nivelStock = nivelStock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertaStock)) {
            return false;
        }
        AlertaStock other = (AlertaStock) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AlertaStock[ idAlerta=" + idAlerta + " ]";
    }
    
}
