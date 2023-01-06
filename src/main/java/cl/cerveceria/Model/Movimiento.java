/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "movimiento", catalog = "Ccu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByIdMovimiento", query = "SELECT m FROM Movimiento m WHERE m.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "Movimiento.findByFechaMovimiento", query = "SELECT m FROM Movimiento m WHERE m.fechaMovimiento = :fechaMovimiento"),
    @NamedQuery(name = "Movimiento.findByTipoMovimiento", query = "SELECT m FROM Movimiento m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "Movimiento.findByCantidadMovimiento", query = "SELECT m FROM Movimiento m WHERE m.cantidadMovimiento = :cantidadMovimiento")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento", nullable = false)
    private Integer idMovimiento;
    @Basic(optional = false)
    @Column(name = "fecha_movimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @Column(name = "tipo_movimiento", nullable = false, length = 45)
    private String tipoMovimiento;
    @Basic(optional = false)
    @Column(name = "cantidad_movimiento", nullable = false)
    private int cantidadMovimiento;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto productoIdProducto;

    public Movimiento() {
    }

    public Movimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(Integer idMovimiento, Date fechaMovimiento, String tipoMovimiento, int cantidadMovimiento) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidadMovimiento() {
        return cantidadMovimiento;
    }

    public void setCantidadMovimiento(int cantidadMovimiento) {
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public Producto getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(Producto productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
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
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.cerveceria.Model.Movimiento[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
