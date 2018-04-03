package edu.fei.entidad;

import edu.fei.entidad.Valoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Encuesta.class)
public class Encuesta_ { 

    public static volatile SingularAttribute<Encuesta, Integer> pkIdencuesta;
    public static volatile SingularAttribute<Encuesta, Integer> escala;
    public static volatile SingularAttribute<Encuesta, String> pregunta;
    public static volatile SingularAttribute<Encuesta, Valoracion> valoracionValoracion;

}