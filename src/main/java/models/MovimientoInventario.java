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
@Table(name = "movimiento_inventario", catalog = "inventario_electronica", schema = "")
@NamedQueries({
    @NamedQuery(name = "MovimientoInventario.findAll", query = "SELECT m FROM MovimientoInventario m"),
    @NamedQuery(name = "MovimientoInventario.findByIdMovimiento", query = "SELECT m FROM MovimientoInventario m WHERE m.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "MovimientoInventario.findByTipoMovimiento", query = "SELECT m FROM MovimientoInventario m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "MovimientoInventario.findByCantidad", query = "SELECT m FROM MovimientoInventario m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MovimientoInventario.findByFecha", query = "SELECT m FROM MovimientoInventario m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MovimientoInventario.findByObservacion", query = "SELECT m FROM MovimientoInventario m WHERE m.observacion = :observacion")})
public class MovimientoInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento", nullable = false)
    private Integer idMovimiento;
    @Basic(optional = false)
    @Column(name = "tipo_movimiento", nullable = false, length = 7)
    private String tipoMovimiento;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "observacion", length = 255)
    private String observacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public MovimientoInventario() {
    }

    public MovimientoInventario(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public MovimientoInventario(Integer idMovimiento, String tipoMovimiento, int cantidad, Date fecha) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoInventario)) {
            return false;
        }
        MovimientoInventario other = (MovimientoInventario) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MovimientoInventario[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
