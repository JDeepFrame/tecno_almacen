/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author java
 */
@Entity
@Table(name = "producto", catalog = "inventario_electronica", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByPrecioUnitario", query = "SELECT p FROM Producto p WHERE p.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Producto.findByStockActual", query = "SELECT p FROM Producto p WHERE p.stockActual = :stockActual"),
    @NamedQuery(name = "Producto.findByStockMinimo", query = "SELECT p FROM Producto p WHERE p.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;
    @Basic(optional = false)
    @Column(name = "stock_actual", nullable = false)
    private int stockActual;
    @Basic(optional = false)
    @Column(name = "stock_minimo", nullable = false)
    private int stockMinimo;
    @Column(name = "estado", length = 8)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<AlertaStock> alertaStockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<DetalleOrden> detalleOrdenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<MovimientoInventario> movimientoInventarioList;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, BigDecimal precioUnitario, int stockActual, int stockMinimo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<AlertaStock> getAlertaStockList() {
        return alertaStockList;
    }

    public void setAlertaStockList(List<AlertaStock> alertaStockList) {
        this.alertaStockList = alertaStockList;
    }

    public List<DetalleOrden> getDetalleOrdenList() {
        return detalleOrdenList;
    }

    public void setDetalleOrdenList(List<DetalleOrden> detalleOrdenList) {
        this.detalleOrdenList = detalleOrdenList;
    }

    public List<MovimientoInventario> getMovimientoInventarioList() {
        return movimientoInventarioList;
    }

    public void setMovimientoInventarioList(List<MovimientoInventario> movimientoInventarioList) {
        this.movimientoInventarioList = movimientoInventarioList;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
