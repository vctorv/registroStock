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
@Table(name = "cliente", catalog = "Ccu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNumrutCliente", query = "SELECT c FROM Cliente c WHERE c.numrutCliente = :numrutCliente"),
    @NamedQuery(name = "Cliente.findByDvrutCliente", query = "SELECT c FROM Cliente c WHERE c.dvrutCliente = :dvrutCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByAppaternoCliente", query = "SELECT c FROM Cliente c WHERE c.appaternoCliente = :appaternoCliente"),
    @NamedQuery(name = "Cliente.findByApmaternoCliente", query = "SELECT c FROM Cliente c WHERE c.apmaternoCliente = :apmaternoCliente"),
    @NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Cliente.findByComunaCliente", query = "SELECT c FROM Cliente c WHERE c.comunaCliente = :comunaCliente"),
    @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Cliente.findByNombreEmpresa", query = "SELECT c FROM Cliente c WHERE c.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Cliente.findByTipoEmpresa", query = "SELECT c FROM Cliente c WHERE c.tipoEmpresa = :tipoEmpresa")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numrut_cliente", nullable = false)
    private Integer numrutCliente;
    @Basic(optional = false)
    @Column(name = "dvrut_cliente", nullable = false, length = 1)
    private String dvrutCliente;
    @Basic(optional = false)
    @Column(name = "nombre_cliente", nullable = false, length = 25)
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "appaterno_cliente", nullable = false, length = 15)
    private String appaternoCliente;
    @Basic(optional = false)
    @Column(name = "apmaterno_cliente", nullable = false, length = 15)
    private String apmaternoCliente;
    @Basic(optional = false)
    @Column(name = "direccion_cliente", nullable = false, length = 60)
    private String direccionCliente;
    @Basic(optional = false)
    @Column(name = "comuna_cliente", nullable = false, length = 30)
    private String comunaCliente;
    @Basic(optional = false)
    @Column(name = "telefono_cliente", nullable = false)
    private int telefonoCliente;
    @Basic(optional = false)
    @Column(name = "email_cliente", nullable = false, length = 50)
    private String emailCliente;
    @Basic(optional = false)
    @Column(name = "nombre_empresa", nullable = false, length = 50)
    private String nombreEmpresa;
    @Basic(optional = false)
    @Column(name = "tipo_empresa", nullable = false, length = 20)
    private String tipoEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteNumrutCliente")
    private List<Venta> ventaList;

    public Cliente() {
    }

    public Cliente(Integer numrutCliente) {
        this.numrutCliente = numrutCliente;
    }

    public Cliente(Integer numrutCliente, String dvrutCliente, String nombreCliente, String appaternoCliente, String apmaternoCliente, String direccionCliente, String comunaCliente, int telefonoCliente, String emailCliente, String nombreEmpresa, String tipoEmpresa) {
        this.numrutCliente = numrutCliente;
        this.dvrutCliente = dvrutCliente;
        this.nombreCliente = nombreCliente;
        this.appaternoCliente = appaternoCliente;
        this.apmaternoCliente = apmaternoCliente;
        this.direccionCliente = direccionCliente;
        this.comunaCliente = comunaCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Integer getNumrutCliente() {
        return numrutCliente;
    }

    public void setNumrutCliente(Integer numrutCliente) {
        this.numrutCliente = numrutCliente;
    }

    public String getDvrutCliente() {
        return dvrutCliente;
    }

    public void setDvrutCliente(String dvrutCliente) {
        this.dvrutCliente = dvrutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAppaternoCliente() {
        return appaternoCliente;
    }

    public void setAppaternoCliente(String appaternoCliente) {
        this.appaternoCliente = appaternoCliente;
    }

    public String getApmaternoCliente() {
        return apmaternoCliente;
    }

    public void setApmaternoCliente(String apmaternoCliente) {
        this.apmaternoCliente = apmaternoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getComunaCliente() {
        return comunaCliente;
    }

    public void setComunaCliente(String comunaCliente) {
        this.comunaCliente = comunaCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numrutCliente != null ? numrutCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.numrutCliente == null && other.numrutCliente != null) || (this.numrutCliente != null && !this.numrutCliente.equals(other.numrutCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.cerveceria.Model.Cliente[ numrutCliente=" + numrutCliente + " ]";
    }
    
}
