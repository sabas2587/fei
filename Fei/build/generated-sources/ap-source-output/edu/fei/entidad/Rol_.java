package edu.fei.entidad;

import edu.fei.entidad.Permiso;
import edu.fei.entidad.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> cargo;
    public static volatile ListAttribute<Rol, Usuario> usuarios;
    public static volatile ListAttribute<Rol, Permiso> permisos;
    public static volatile SingularAttribute<Rol, String> nombre;
    public static volatile SingularAttribute<Rol, Integer> pkidRol;

}