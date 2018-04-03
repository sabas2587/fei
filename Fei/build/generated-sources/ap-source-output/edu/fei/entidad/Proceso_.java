package edu.fei.entidad;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Proceso.class)
public class Proceso_ { 

    public static volatile SingularAttribute<Proceso, String> capacidadRestaurativa;
    public static volatile SingularAttribute<Proceso, String> objetivos;
    public static volatile SingularAttribute<Proceso, String> tipoproceso;
    public static volatile SingularAttribute<Proceso, String> trascendencia;
    public static volatile SingularAttribute<Proceso, Integer> idinformeEx;
    public static volatile SingularAttribute<Proceso, Adolescente> adolescentepkidAdolescente;
    public static volatile SingularAttribute<Proceso, Date> fechaDiagnostico;
    public static volatile SingularAttribute<Proceso, String> fortalecimiento;
    public static volatile SingularAttribute<Proceso, String> tipoConcepto;
    public static volatile SingularAttribute<Proceso, String> pathConceptoFinal;
    public static volatile SingularAttribute<Proceso, Usuario> usuariopkidUsuario;

}