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
@Table(name = "venta", catalog = "Ccu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByCantidadVenta", query = "SELECT v FROM Venta v WHERE v.cantidadVenta = :cantidadVenta"),
    @NamedQuery(name = "Venta.findByTotalPrecioVenta", query = "SELECT v FROM Venta v WHERE v.totalPrecioVenta = :totalPrecioVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;
    @Basic(optional = false)
    @Column(name = "fecha_venta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @Column(name = "cantidad_venta", nullable = false)
    private int cantidadVenta;
    @Basic(optional = false)
    @Column(name = "total_precio_venta", nullable = false)
    private int totalPrecioVenta;
    @JoinColumn(name = "cliente_numrut_cliente", referencedColumnName = "numrut_cliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente clienteNumrutCliente;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto productoIdProducto;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, Date fechaVenta, int cantidadVenta, int totalPrecioVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cantidadVenta = cantidadVenta;
        this.totalPrecioVenta = totalPrecioVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public int getTotalPrecioVenta() {
        return totalPrecioVenta;
    }

    public void setTotalPrecioVenta(int totalPrecioVenta) {
        this.totalPrecioVenta = totalPrecioVenta;
    }

    public Cliente getClienteNumrutCliente() {
        return clienteNumrutCliente;
    }

    public void setClienteNumrutCliente(Cliente clienteNumrutCliente) {
        this.clienteNumrutCliente = clienteNumrutCliente;
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
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.cerveceria.Model.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
