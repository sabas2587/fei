/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sabas
 */
@Entity
@Table(name = "Adolescente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adolescente.findAll", query = "SELECT a FROM Adolescente a")
    , @NamedQuery(name = "Adolescente.findByPkidAdolescente", query = "SELECT a FROM Adolescente a WHERE a.pkidAdolescente = :pkidAdolescente")
    , @NamedQuery(name = "Adolescente.findByTipoDocumento", query = "SELECT a FROM Adolescente a WHERE a.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Adolescente.findByNumeroDocumento", query = "SELECT a FROM Adolescente a WHERE a.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Adolescente.findByNombre", query = "SELECT a FROM Adolescente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Adolescente.findByApellidos", query = "SELECT a FROM Adolescente a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Adolescente.findByFechaNacimiento", query = "SELECT a FROM Adolescente a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Adolescente.findByLugarNacimiento", query = "SELECT a FROM Adolescente a WHERE a.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Adolescente.findByEdad", query = "SELECT a FROM Adolescente a WHERE a.edad = :edad")
    , @NamedQuery(name = "Adolescente.findByEscolaridad", query = "SELECT a FROM Adolescente a WHERE a.escolaridad = :escolaridad")})
public class Adolescente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idAdolescente")
    private Integer pkidAdolescente;
    @Basic(optional = false)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numeroDocumento")
    private long numeroDocumento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugarNacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "escolaridad")
    private String escolaridad;
    @Lob
    @Column(name = "path_document")
    private String pathDocument;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adolescentepkidAdolescente", fetch = FetchType.EAGER)
    private List<Informe> informeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adolescentepkidAdolescente", fetch = FetchType.EAGER)
    private List<Acudiente> acudienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adolescentepkidAdolescente", fetch = FetchType.EAGER)
    private List<Intervecion> intervecionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adolescentepkidAdolescente", fetch = FetchType.EAGER)
    private List<Actividad> actividadList;
    @JoinColumn(name = "Remision_pk_ordenRemision", referencedColumnName = "pk_ordenRemision")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Remision remisionpkordenRemision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adolescentepkidAdolescente", fetch = FetchType.EAGER)
    private List<Proceso> procesoList;

    public Adolescente() {
    }

    public Adolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Adolescente(Integer pkidAdolescente, String tipoDocumento, long numeroDocumento, String nombre, String apellidos, Date fechaNacimiento, int edad, String escolaridad) {
        this.pkidAdolescente = pkidAdolescente;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.escolaridad = escolaridad;
    }

    public Integer getPkidAdolescente() {
        return pkidAdolescente;
    }

    public void setPkidAdolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getPathDocument() {
        return pathDocument;
    }

    public void setPathDocument(String pathDocument) {
        this.pathDocument = pathDocument;
    }

    @XmlTransient
    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

    @XmlTransient
    public List<Acudiente> getAcudienteList() {
        return acudienteList;
    }

    public void setAcudienteList(List<Acudiente> acudienteList) {
        this.acudienteList = acudienteList;
    }

    @XmlTransient
    public List<Intervecion> getIntervecionList() {
        return intervecionList;
    }

    public void setIntervecionList(List<Intervecion> intervecionList) {
        this.intervecionList = intervecionList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public Remision getRemisionpkordenRemision() {
        return remisionpkordenRemision;
    }

    public void setRemisionpkordenRemision(Remision remisionpkordenRemision) {
        this.remisionpkordenRemision = remisionpkordenRemision;
    }

    @XmlTransient
    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidAdolescente != null ? pkidAdolescente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adolescente)) {
            return false;
        }
        Adolescente other = (Adolescente) object;
        if ((this.pkidAdolescente == null && other.pkidAdolescente != null) || (this.pkidAdolescente != null && !this.pkidAdolescente.equals(other.pkidAdolescente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Adolescente[ pkidAdolescente=" + pkidAdolescente + " ]";
    }
    
}
