package cl.cerveceria.Model;

import cl.cerveceria.Model.Cliente;
import cl.cerveceria.Model.Producto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-29T16:13:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> cantidadVenta;
    public static volatile SingularAttribute<Venta, Integer> totalPrecioVenta;
    public static volatile SingularAttribute<Venta, Cliente> clienteNumrutCliente;
    public static volatile SingularAttribute<Venta, Producto> productoIdProducto;
    public static volatile SingularAttribute<Venta, Integer> idVenta;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}