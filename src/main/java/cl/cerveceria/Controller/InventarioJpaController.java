/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Controller;

import cl.cerveceria.Controller.exceptions.NonexistentEntityException;
import cl.cerveceria.Controller.exceptions.PreexistingEntityException;
import cl.cerveceria.Model.Inventario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cl.cerveceria.Model.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victor
 */
public class InventarioJpaController implements Serializable {

    public InventarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public InventarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("cl.cerveceria_Evaluacion3");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inventario inventario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoIdProducto = inventario.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto = em.getReference(productoIdProducto.getClass(), productoIdProducto.getIdProducto());
                inventario.setProductoIdProducto(productoIdProducto);
            }
            em.persist(inventario);
            if (productoIdProducto != null) {
                productoIdProducto.getInventarioList().add(inventario);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInventario(inventario.getIdinventario()) != null) {
                throw new PreexistingEntityException("Inventario " + inventario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inventario inventario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inventario persistentInventario = em.find(Inventario.class, inventario.getIdinventario());
            Producto productoIdProductoOld = persistentInventario.getProductoIdProducto();
            Producto productoIdProductoNew = inventario.getProductoIdProducto();
            if (productoIdProductoNew != null) {
                productoIdProductoNew = em.getReference(productoIdProductoNew.getClass(), productoIdProductoNew.getIdProducto());
                inventario.setProductoIdProducto(productoIdProductoNew);
            }
            inventario = em.merge(inventario);
            if (productoIdProductoOld != null && !productoIdProductoOld.equals(productoIdProductoNew)) {
                productoIdProductoOld.getInventarioList().remove(inventario);
                productoIdProductoOld = em.merge(productoIdProductoOld);
            }
            if (productoIdProductoNew != null && !productoIdProductoNew.equals(productoIdProductoOld)) {
                productoIdProductoNew.getInventarioList().add(inventario);
                productoIdProductoNew = em.merge(productoIdProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inventario.getIdinventario();
                if (findInventario(id) == null) {
                    throw new NonexistentEntityException("The inventario with id " + id + " no longer exists.");
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
            Inventario inventario;
            try {
                inventario = em.getReference(Inventario.class, id);
                inventario.getIdinventario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inventario with id " + id + " no longer exists.", enfe);
            }
            Producto productoIdProducto = inventario.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto.getInventarioList().remove(inventario);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.remove(inventario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inventario> findInventarioEntities() {
        return findInventarioEntities(true, -1, -1);
    }

    public List<Inventario> findInventarioEntities(int maxResults, int firstResult) {
        return findInventarioEntities(false, maxResults, firstResult);
    }

    private List<Inventario> findInventarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inventario.class));
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

    public Inventario findInventario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inventario.class, id);
        } finally {
            em.close();
        }
    }

    public int getInventarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inventario> rt = cq.from(Inventario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
