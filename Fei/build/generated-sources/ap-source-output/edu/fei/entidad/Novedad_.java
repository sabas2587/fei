package edu.fei.entidad;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Novedad.class)
public class Novedad_ { 

    public static volatile SingularAttribute<Novedad, String> descripcion;
    public static volatile SingularAttribute<Novedad, Integer> idintervecion;
    public static volatile SingularAttribute<Novedad, Adolescente> adolescentepkidAdolescente;
    public static volatile SingularAttribute<Novedad, String> fechaintervencion;
    public static volatile SingularAttribute<Novedad, String> tipointervencion;
    public static volatile SingularAttribute<Novedad, Usuario> usuariopkidUsuario;

}