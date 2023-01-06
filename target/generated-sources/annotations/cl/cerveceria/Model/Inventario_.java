package cl.cerveceria.Model;

import cl.cerveceria.Model.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-29T16:13:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Integer> idinventario;
    public static volatile SingularAttribute<Inventario, Producto> productoIdProducto;
    public static volatile SingularAttribute<Inventario, Integer> stock;

}