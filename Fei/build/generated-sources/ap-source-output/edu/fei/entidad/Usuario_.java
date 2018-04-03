package edu.fei.entidad;

import edu.fei.entidad.Actividad;
import edu.fei.entidad.Novedad;
import edu.fei.entidad.Proceso;
import edu.fei.entidad.Rol;
import edu.fei.entidad.Valoracion;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile ListAttribute<Usuario, Actividad> actividadList;
    public static volatile SingularAttribute<Usuario, String> mail;
    public static volatile SingularAttribute<Usuario, BigInteger> numeroDocumento;
    public static volatile ListAttribute<Usuario, Novedad> novedadList;
    public static volatile SingularAttribute<Usuario, Rol> rolpkidRol;
    public static volatile ListAttribute<Usuario, Valoracion> valoracionList;
    public static volatile SingularAttribute<Usuario, Integer> pkidUsuario;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> contraseña;
    public static volatile ListAttribute<Usuario, Proceso> procesoList;

}