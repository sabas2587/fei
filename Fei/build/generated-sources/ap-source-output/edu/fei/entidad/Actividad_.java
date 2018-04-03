package edu.fei.entidad;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, Long> pkidActividades;
    public static volatile SingularAttribute<Actividad, Boolean> estado;
    public static volatile SingularAttribute<Actividad, Date> fechaInicial;
    public static volatile SingularAttribute<Actividad, String> nombreActividad;
    public static volatile SingularAttribute<Actividad, Date> fechaFinal;
    public static volatile SingularAttribute<Actividad, String> listaactividad;
    public static volatile SingularAttribute<Actividad, String> descripcionActividad;
    public static volatile SingularAttribute<Actividad, Adolescente> adolescentepkidAdolescente;
    public static volatile SingularAttribute<Actividad, Usuario> usuariopkidUsuario;

}