package edu.fei.entidad;

import edu.fei.entidad.Adolescente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-02T23:08:54")
@StaticMetamodel(Remision.class)
public class Remision_ { 

    public static volatile SingularAttribute<Remision, Date> fechaRemision;
    public static volatile SingularAttribute<Remision, Integer> pkordenRemision;
    public static volatile SingularAttribute<Remision, String> tipoRemision;
    public static volatile SingularAttribute<Remision, String> autoridad;
    public static volatile ListAttribute<Remision, Adolescente> adolescenteList;

}