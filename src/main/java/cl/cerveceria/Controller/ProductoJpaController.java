/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cerveceria.Controller;

import cl.cerveceria.Controller.exceptions.IllegalOrphanException;
import cl.cerveceria.Controller.exceptions.NonexistentEntityException;
import cl.cerveceria.Controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cl.cerveceria.Model.Venta;
import java.util.ArrayList;
import java.util.List;
import cl.cerveceria.Model.Movimiento;
import cl.cerveceria.Model.Inventario;
import cl.cerveceria.Model.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victor
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ProductoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("cl.cerveceria_Evaluacion3");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) throws PreexistingEntityException, Exception {
        if (producto.getVentaList() == null) {
            producto.setVentaList(new ArrayList<Venta>());
        }
        if (producto.getMovimientoList() == null) {
            producto.setMovimientoList(new ArrayList<Movimiento>());
        }
        if (producto.getInventarioList() == null) {
            producto.setInventarioList(new ArrayList<Inventario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : producto.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            producto.setVentaList(attachedVentaList);
            List<Movimiento> attachedMovimientoList = new ArrayList<Movimiento>();
            for (Movimiento movimientoListMovimientoToAttach : producto.getMovimientoList()) {
                movimientoListMovimientoToAttach = em.getReference(movimientoListMovimientoToAttach.getClass(), movimientoListMovimientoToAttach.getIdMovimiento());
                attachedMovimientoList.add(movimientoListMovimientoToAttach);
            }
            producto.setMovimientoList(attachedMovimientoList);
            List<Inventario> attachedInventarioList = new ArrayList<Inventario>();
            for (Inventario inventarioListInventarioToAttach : producto.getInventarioList()) {
                inventarioListInventarioToAttach = em.getReference(inventarioListInventarioToAttach.getClass(), inventarioListInventarioToAttach.getIdinventario());
                attachedInventarioList.add(inventarioListInventarioToAttach);
            }
            producto.setInventarioList(attachedInventarioList);
            em.persist(producto);
            for (Venta ventaListVenta : producto.getVentaList()) {
                Producto oldProductoIdProductoOfVentaListVenta = ventaListVenta.getProductoIdProducto();
                ventaListVenta.setProductoIdProducto(producto);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldProductoIdProductoOfVentaListVenta != null) {
                    oldProductoIdProductoOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldProductoIdProductoOfVentaListVenta = em.merge(oldProductoIdProductoOfVentaListVenta);
                }
            }
            for (Movimiento movimientoListMovimiento : producto.getMovimientoList()) {
                Producto oldProductoIdProductoOfMovimientoListMovimiento = movimientoListMovimiento.getProductoIdProducto();
                movimientoListMovimiento.setProductoIdProducto(producto);
                movimientoListMovimiento = em.merge(movimientoListMovimiento);
                if (oldProductoIdProductoOfMovimientoListMovimiento != null) {
                    oldProductoIdProductoOfMovimientoListMovimiento.getMovimientoList().remove(movimientoListMovimiento);
                    oldProductoIdProductoOfMovimientoListMovimiento = em.merge(oldProductoIdProductoOfMovimientoListMovimiento);
                }
            }
            for (Inventario inventarioListInventario : producto.getInventarioList()) {
                Producto oldProductoIdProductoOfInventarioListInventario = inventarioListInventario.getProductoIdProducto();
                inventarioListInventario.setProductoIdProducto(producto);
                inventarioListInventario = em.merge(inventarioListInventario);
                if (oldProductoIdProductoOfInventarioListInventario != null) {
                    oldProductoIdProductoOfInventarioListInventario.getInventarioList().remove(inventarioListInventario);
                    oldProductoIdProductoOfInventarioListInventario = em.merge(oldProductoIdProductoOfInventarioListInventario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto(producto.getIdProducto()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            List<Venta> ventaListOld = persistentProducto.getVentaList();
            List<Venta> ventaListNew = producto.getVentaList();
            List<Movimiento> movimientoListOld = persistentProducto.getMovimientoList();
            List<Movimiento> movimientoListNew = producto.getMovimientoList();
            List<Inventario> inventarioListOld = persistentProducto.getInventarioList();
            List<Inventario> inventarioListNew = producto.getInventarioList();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its productoIdProducto field is not nullable.");
                }
            }
            for (Movimiento movimientoListOldMovimiento : movimientoListOld) {
                if (!movimientoListNew.contains(movimientoListOldMovimiento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movimiento " + movimientoListOldMovimiento + " since its productoIdProducto field is not nullable.");
                }
            }
            for (Inventario inventarioListOldInventario : inventarioListOld) {
                if (!inventarioListNew.contains(inventarioListOldInventario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inventario " + inventarioListOldInventario + " since its productoIdProducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            producto.setVentaList(ventaListNew);
            List<Movimiento> attachedMovimientoListNew = new ArrayList<Movimiento>();
            for (Movimiento movimientoListNewMovimientoToAttach : movimientoListNew) {
                movimientoListNewMovimientoToAttach = em.getReference(movimientoListNewMovimientoToAttach.getClass(), movimientoListNewMovimientoToAttach.getIdMovimiento());
                attachedMovimientoListNew.add(movimientoListNewMovimientoToAttach);
            }
            movimientoListNew = attachedMovimientoListNew;
            producto.setMovimientoList(movimientoListNew);
            List<Inventario> attachedInventarioListNew = new ArrayList<Inventario>();
            for (Inventario inventarioListNewInventarioToAttach : inventarioListNew) {
                inventarioListNewInventarioToAttach = em.getReference(inventarioListNewInventarioToAttach.getClass(), inventarioListNewInventarioToAttach.getIdinventario());
                attachedInventarioListNew.add(inventarioListNewInventarioToAttach);
            }
            inventarioListNew = attachedInventarioListNew;
            producto.setInventarioList(inventarioListNew);
            producto = em.merge(producto);
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Producto oldProductoIdProductoOfVentaListNewVenta = ventaListNewVenta.getProductoIdProducto();
                    ventaListNewVenta.setProductoIdProducto(producto);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldProductoIdProductoOfVentaListNewVenta != null && !oldProductoIdProductoOfVentaListNewVenta.equals(producto)) {
                        oldProductoIdProductoOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldProductoIdProductoOfVentaListNewVenta = em.merge(oldProductoIdProductoOfVentaListNewVenta);
                    }
                }
            }
            for (Movimiento movimientoListNewMovimiento : movimientoListNew) {
                if (!movimientoListOld.contains(movimientoListNewMovimiento)) {
                    Producto oldProductoIdProductoOfMovimientoListNewMovimiento = movimientoListNewMovimiento.getProductoIdProducto();
                    movimientoListNewMovimiento.setProductoIdProducto(producto);
                    movimientoListNewMovimiento = em.merge(movimientoListNewMovimiento);
                    if (oldProductoIdProductoOfMovimientoListNewMovimiento != null && !oldProductoIdProductoOfMovimientoListNewMovimiento.equals(producto)) {
                        oldProductoIdProductoOfMovimientoListNewMovimiento.getMovimientoList().remove(movimientoListNewMovimiento);
                        oldProductoIdProductoOfMovimientoListNewMovimiento = em.merge(oldProductoIdProductoOfMovimientoListNewMovimiento);
                    }
                }
            }
            for (Inventario inventarioListNewInventario : inventarioListNew) {
                if (!inventarioListOld.contains(inventarioListNewInventario)) {
                    Producto oldProductoIdProductoOfInventarioListNewInventario = inventarioListNewInventario.getProductoIdProducto();
                    inventarioListNewInventario.setProductoIdProducto(producto);
                    inventarioListNewInventario = em.merge(inventarioListNewInventario);
                    if (oldProductoIdProductoOfInventarioListNewInventario != null && !oldProductoIdProductoOfInventarioListNewInventario.equals(producto)) {
                        oldProductoIdProductoOfInventarioListNewInventario.getInventarioList().remove(inventarioListNewInventario);
                        oldProductoIdProductoOfInventarioListNewInventario = em.merge(oldProductoIdProductoOfInventarioListNewInventario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Venta> ventaListOrphanCheck = producto.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable productoIdProducto field.");
            }
            List<Movimiento> movimientoListOrphanCheck = producto.getMovimientoList();
            for (Movimiento movimientoListOrphanCheckMovimiento : movimientoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Movimiento " + movimientoListOrphanCheckMovimiento + " in its movimientoList field has a non-nullable productoIdProducto field.");
            }
            List<Inventario> inventarioListOrphanCheck = producto.getInventarioList();
            for (Inventario inventarioListOrphanCheckInventario : inventarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Inventario " + inventarioListOrphanCheckInventario + " in its inventarioList field has a non-nullable productoIdProducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
