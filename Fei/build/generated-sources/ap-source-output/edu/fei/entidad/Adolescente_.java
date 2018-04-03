package edu.fei.entidad;

import edu.fei.entidad.Actividad;
import edu.fei.entidad.Acudiente;
import edu.fei.entidad.Novedad;
import edu.fei.entidad.Proceso;
import edu.fei.entidad.Remision;
import edu.fei.entidad.Valoracion;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Adolescente.class)
public class Adolescente_ { 

    public static volatile SingularAttribute<Adolescente, String> apellidos;
    public static volatile SingularAttribute<Adolescente, Integer> estado;
    public static volatile ListAttribute<Adolescente, Actividad> actividadList;
    public static volatile SingularAttribute<Adolescente, Date> fechaNacimiento;
    public static volatile SingularAttribute<Adolescente, String> pathDocument;
    public static volatile ListAttribute<Adolescente, Novedad> novedadList;
    public static volatile SingularAttribute<Adolescente, Integer> edad;
    public static volatile SingularAttribute<Adolescente, String> nombre;
    public static volatile SingularAttribute<Adolescente, Integer> pkidAdolescente;
    public static volatile SingularAttribute<Adolescente, String> escolaridad;
    public static volatile SingularAttribute<Adolescente, String> tipoDocumento;
    public static volatile ListAttribute<Adolescente, Acudiente> acudienteList;
    public static volatile SingularAttribute<Adolescente, Remision> remisionpkordenRemision;
    public static volatile SingularAttribute<Adolescente, BigInteger> numeroDocumento;
    public static volatile ListAttribute<Adolescente, Valoracion> valoracionList;
    public static volatile SingularAttribute<Adolescente, String> lugarNacimiento;
    public static volatile ListAttribute<Adolescente, Proceso> procesoList;

}