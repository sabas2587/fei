package edu.fei.entidad;

import edu.fei.entidad.Permiso;
import edu.fei.entidad.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile SingularAttribute<Permiso, Permiso> permisoPadre;
    public static volatile SingularAttribute<Permiso, Integer> pkidPermiso;
    public static volatile ListAttribute<Permiso, Permiso> subPermisos;
    public static volatile ListAttribute<Permiso, Rol> roles;
    public static volatile SingularAttribute<Permiso, String> icon;
    public static volatile SingularAttribute<Permiso, String> active;
    public static volatile SingularAttribute<Permiso, String> nombrePermiso;
    public static volatile SingularAttribute<Permiso, String> nombrePermisoEn;
    public static volatile SingularAttribute<Permiso, String> url;

}