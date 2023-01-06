/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Controller;

import cl.cerveceria.Controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cl.cerveceria.Model.Cliente;
import cl.cerveceria.Model.Producto;
import cl.cerveceria.Model.Venta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victor
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public VentaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("cl.cerveceria_Evaluacion3");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente clienteNumrutCliente = venta.getClienteNumrutCliente();
            if (clienteNumrutCliente != null) {
                clienteNumrutCliente = em.getReference(clienteNumrutCliente.getClass(), clienteNumrutCliente.getNumrutCliente());
                venta.setClienteNumrutCliente(clienteNumrutCliente);
            }
            Producto productoIdProducto = venta.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto = em.getReference(productoIdProducto.getClass(), productoIdProducto.getIdProducto());
                venta.setProductoIdProducto(productoIdProducto);
            }
            em.persist(venta);
            if (clienteNumrutCliente != null) {
                clienteNumrutCliente.getVentaList().add(venta);
                clienteNumrutCliente = em.merge(clienteNumrutCliente);
            }
            if (productoIdProducto != null) {
                productoIdProducto.getVentaList().add(venta);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVenta());
            Cliente clienteNumrutClienteOld = persistentVenta.getClienteNumrutCliente();
            Cliente clienteNumrutClienteNew = venta.getClienteNumrutCliente();
            Producto productoIdProductoOld = persistentVenta.getProductoIdProducto();
            Producto productoIdProductoNew = venta.getProductoIdProducto();
            if (clienteNumrutClienteNew != null) {
                clienteNumrutClienteNew = em.getReference(clienteNumrutClienteNew.getClass(), clienteNumrutClienteNew.getNumrutCliente());
                venta.setClienteNumrutCliente(clienteNumrutClienteNew);
            }
            if (productoIdProductoNew != null) {
                productoIdProductoNew = em.getReference(productoIdProductoNew.getClass(), productoIdProductoNew.getIdProducto());
                venta.setProductoIdProducto(productoIdProductoNew);
            }
            venta = em.merge(venta);
            if (clienteNumrutClienteOld != null && !clienteNumrutClienteOld.equals(clienteNumrutClienteNew)) {
                clienteNumrutClienteOld.getVentaList().remove(venta);
                clienteNumrutClienteOld = em.merge(clienteNumrutClienteOld);
            }
            if (clienteNumrutClienteNew != null && !clienteNumrutClienteNew.equals(clienteNumrutClienteOld)) {
                clienteNumrutClienteNew.getVentaList().add(venta);
                clienteNumrutClienteNew = em.merge(clienteNumrutClienteNew);
            }
            if (productoIdProductoOld != null && !productoIdProductoOld.equals(productoIdProductoNew)) {
                productoIdProductoOld.getVentaList().remove(venta);
                productoIdProductoOld = em.merge(productoIdProductoOld);
            }
            if (productoIdProductoNew != null && !productoIdProductoNew.equals(productoIdProductoOld)) {
                productoIdProductoNew.getVentaList().add(venta);
                productoIdProductoNew = em.merge(productoIdProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getIdVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente clienteNumrutCliente = venta.getClienteNumrutCliente();
            if (clienteNumrutCliente != null) {
                clienteNumrutCliente.getVentaList().remove(venta);
                clienteNumrutCliente = em.merge(clienteNumrutCliente);
            }
            Producto productoIdProducto = venta.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto.getVentaList().remove(venta);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
