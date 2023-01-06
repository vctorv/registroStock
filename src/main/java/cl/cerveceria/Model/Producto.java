/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "producto", catalog = "Ccu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByTipoProducto", query = "SELECT p FROM Producto p WHERE p.tipoProducto = :tipoProducto"),
    @NamedQuery(name = "Producto.findByFormato", query = "SELECT p FROM Producto p WHERE p.formato = :formato"),
    @NamedQuery(name = "Producto.findByGradoEtilico", query = "SELECT p FROM Producto p WHERE p.gradoEtilico = :gradoEtilico"),
    @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo"),
    @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "nombre_producto", nullable = false, length = 30)
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "tipo_producto", nullable = false, length = 20)
    private String tipoProducto;
    @Basic(optional = false)
    @Column(name = "formato", nullable = false, length = 20)
    private String formato;
    @Basic(optional = false)
    @Column(name = "grado_etilico", nullable = false)
    private float gradoEtilico;
    @Basic(optional = false)
    @Column(name = "costo", nullable = false)
    private int costo;
    @Basic(optional = false)
    @Column(name = "precio_venta", nullable = false)
    private int precioVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdProducto")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdProducto")
    private List<Movimiento> movimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdProducto")
    private List<Inventario> inventarioList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, String tipoProducto, String formato, float gradoEtilico, int costo, int precioVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.formato = formato;
        this.gradoEtilico = gradoEtilico;
        this.costo = costo;
        this.precioVenta = precioVenta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public float getGradoEtilico() {
        return gradoEtilico;
    }

    public void setGradoEtilico(float gradoEtilico) {
        this.gradoEtilico = gradoEtilico;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
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
        return "cl.cerveceria.Model.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
