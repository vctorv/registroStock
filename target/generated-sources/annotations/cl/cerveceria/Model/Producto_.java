package cl.cerveceria.Model;

import cl.cerveceria.Model.Inventario;
import cl.cerveceria.Model.Movimiento;
import cl.cerveceria.Model.Venta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-29T16:13:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> tipoProducto;
    public static volatile SingularAttribute<Producto, Integer> costo;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile SingularAttribute<Producto, String> formato;
    public static volatile ListAttribute<Producto, Movimiento> movimientoList;
    public static volatile ListAttribute<Producto, Inventario> inventarioList;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> precioVenta;
    public static volatile SingularAttribute<Producto, String> nombreProducto;
    public static volatile SingularAttribute<Producto, Float> gradoEtilico;

}