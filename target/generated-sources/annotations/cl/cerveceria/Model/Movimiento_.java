package cl.cerveceria.Model;

import cl.cerveceria.Model.Producto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-29T16:13:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Integer> idMovimiento;
    public static volatile SingularAttribute<Movimiento, Integer> cantidadMovimiento;
    public static volatile SingularAttribute<Movimiento, String> tipoMovimiento;
    public static volatile SingularAttribute<Movimiento, Producto> productoIdProducto;
    public static volatile SingularAttribute<Movimiento, Date> fechaMovimiento;

}