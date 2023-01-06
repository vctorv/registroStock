package cl.cerveceria.Model;

import cl.cerveceria.Model.Venta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-29T16:13:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> emailCliente;
    public static volatile SingularAttribute<Cliente, String> comunaCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile SingularAttribute<Cliente, String> tipoEmpresa;
    public static volatile SingularAttribute<Cliente, String> appaternoCliente;
    public static volatile ListAttribute<Cliente, Venta> ventaList;
    public static volatile SingularAttribute<Cliente, String> apmaternoCliente;
    public static volatile SingularAttribute<Cliente, String> direccionCliente;
    public static volatile SingularAttribute<Cliente, Integer> telefonoCliente;
    public static volatile SingularAttribute<Cliente, Integer> numrutCliente;
    public static volatile SingularAttribute<Cliente, String> dvrutCliente;
    public static volatile SingularAttribute<Cliente, String> nombreEmpresa;

}