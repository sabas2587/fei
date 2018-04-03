package edu.fei.entidad;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Encuesta;
import edu.fei.entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, String> recomendacion;
    public static volatile SingularAttribute<Valoracion, String> conceptoIntegral;
    public static volatile SingularAttribute<Valoracion, Integer> valoracion;
    public static volatile SingularAttribute<Valoracion, Date> fechaValoracion;
    public static volatile SingularAttribute<Valoracion, Adolescente> adolescentepkidAdolescente;
    public static volatile SingularAttribute<Valoracion, String> tipoactividad;
    public static volatile ListAttribute<Valoracion, Encuesta> encuestaList;
    public static volatile SingularAttribute<Valoracion, Usuario> usuariopkidUsuario;

}