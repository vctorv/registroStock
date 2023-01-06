/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Controller;

import cl.cerveceria.Controller.exceptions.NonexistentEntityException;
import cl.cerveceria.Model.Movimiento;
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
public class MovimientoJpaController implements Serializable {

    public MovimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public MovimientoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("cl.cerveceria_Evaluacion3");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimiento movimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoIdProducto = movimiento.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto = em.getReference(productoIdProducto.getClass(), productoIdProducto.getIdProducto());
                movimiento.setProductoIdProducto(productoIdProducto);
            }
            em.persist(movimiento);
            if (productoIdProducto != null) {
                productoIdProducto.getMovimientoList().add(movimiento);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimiento movimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movimiento persistentMovimiento = em.find(Movimiento.class, movimiento.getIdMovimiento());
            Producto productoIdProductoOld = persistentMovimiento.getProductoIdProducto();
            Producto productoIdProductoNew = movimiento.getProductoIdProducto();
            if (productoIdProductoNew != null) {
                productoIdProductoNew = em.getReference(productoIdProductoNew.getClass(), productoIdProductoNew.getIdProducto());
                movimiento.setProductoIdProducto(productoIdProductoNew);
            }
            movimiento = em.merge(movimiento);
            if (productoIdProductoOld != null && !productoIdProductoOld.equals(productoIdProductoNew)) {
                productoIdProductoOld.getMovimientoList().remove(movimiento);
                productoIdProductoOld = em.merge(productoIdProductoOld);
            }
            if (productoIdProductoNew != null && !productoIdProductoNew.equals(productoIdProductoOld)) {
                productoIdProductoNew.getMovimientoList().add(movimiento);
                productoIdProductoNew = em.merge(productoIdProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movimiento.getIdMovimiento();
                if (findMovimiento(id) == null) {
                    throw new NonexistentEntityException("The movimiento with id " + id + " no longer exists.");
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
            Movimiento movimiento;
            try {
                movimiento = em.getReference(Movimiento.class, id);
                movimiento.getIdMovimiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimiento with id " + id + " no longer exists.", enfe);
            }
            Producto productoIdProducto = movimiento.getProductoIdProducto();
            if (productoIdProducto != null) {
                productoIdProducto.getMovimientoList().remove(movimiento);
                productoIdProducto = em.merge(productoIdProducto);
            }
            em.remove(movimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimiento> findMovimientoEntities() {
        return findMovimientoEntities(true, -1, -1);
    }

    public List<Movimiento> findMovimientoEntities(int maxResults, int firstResult) {
        return findMovimientoEntities(false, maxResults, firstResult);
    }

    private List<Movimiento> findMovimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimiento.class));
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

    public Movimiento findMovimiento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimiento> rt = cq.from(Movimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
