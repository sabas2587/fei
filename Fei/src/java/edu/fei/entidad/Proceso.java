/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    , @NamedQuery(name = "Proceso.findByIdinformeEx", query = "SELECT p FROM Proceso p WHERE p.idinformeEx = :idinformeEx")
    , @NamedQuery(name = "Proceso.findByCapacidadRestaurativa", query = "SELECT p FROM Proceso p WHERE p.capacidadRestaurativa = :capacidadRestaurativa")
    , @NamedQuery(name = "Proceso.findByTipoConcepto", query = "SELECT p FROM Proceso p WHERE p.tipoConcepto = :tipoConcepto")
    , @NamedQuery(name = "Proceso.findByFechaDiagnostico", query = "SELECT p FROM Proceso p WHERE p.fechaDiagnostico = :fechaDiagnostico")
    , @NamedQuery(name = "Proceso.findByFortalecimiento", query = "SELECT p FROM Proceso p WHERE p.fortalecimiento = :fortalecimiento")
    , @NamedQuery(name = "Proceso.findByObjetivos", query = "SELECT p FROM Proceso p WHERE p.objetivos = :objetivos")
    , @NamedQuery(name = "Proceso.findByTipoproceso", query = "SELECT p FROM Proceso p WHERE p.tipoproceso = :tipoproceso")
    , @NamedQuery(name = "Proceso.findByTrascendencia", query = "SELECT p FROM Proceso p WHERE p.trascendencia = :trascendencia")
    , @NamedQuery(name = "Proceso.findByPathConceptoFinal", query = "SELECT p FROM Proceso p WHERE p.pathConceptoFinal = :pathConceptoFinal")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinformeEx")
    private Integer idinformeEx;
    @Column(name = "capacidadRestaurativa")
    private String capacidadRestaurativa;
    @Column(name = "tipo_concepto")
    private String tipoConcepto;
    @Column(name = "fechaDiagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Column(name = "fortalecimiento")
    private String fortalecimiento;
    @Column(name = "objetivos")
    private String objetivos;
    @Column(name = "tipoproceso")
    private String tipoproceso;
    @Column(name = "trascendencia")
    private String trascendencia;
    @Column(name = "path_concepto_final")
    private String pathConceptoFinal;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Proceso() {
    }

    public Proceso(Integer idinformeEx) {
        this.idinformeEx = idinformeEx;
    }

    public Integer getIdinformeEx() {
        return idinformeEx;
    }

    public void setIdinformeEx(Integer idinformeEx) {
        this.idinformeEx = idinformeEx;
    }

    public String getCapacidadRestaurativa() {
        return capacidadRestaurativa;
    }

    public void setCapacidadRestaurativa(String capacidadRestaurativa) {
        this.capacidadRestaurativa = capacidadRestaurativa;
    }

    public String getTipoConcepto() {
        return tipoConcepto;
    }

    public void setTipoConcepto(String tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getFortalecimiento() {
        return fortalecimiento;
    }

    public void setFortalecimiento(String fortalecimiento) {
        this.fortalecimiento = fortalecimiento;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public String getTrascendencia() {
        return trascendencia;
    }

    public void setTrascendencia(String trascendencia) {
        this.trascendencia = trascendencia;
    }

    public String getPathConceptoFinal() {
        return pathConceptoFinal;
    }

    public void setPathConceptoFinal(String pathConceptoFinal) {
        this.pathConceptoFinal = pathConceptoFinal;
    }

    public Adolescente getAdolescentepkidAdolescente() {
        return adolescentepkidAdolescente;
    }

    public void setAdolescentepkidAdolescente(Adolescente adolescentepkidAdolescente) {
        this.adolescentepkidAdolescente = adolescentepkidAdolescente;
    }

    public Usuario getUsuariopkidUsuario() {
        return usuariopkidUsuario;
    }

    public void setUsuariopkidUsuario(Usuario usuariopkidUsuario) {
        this.usuariopkidUsuario = usuariopkidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinformeEx != null ? idinformeEx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.idinformeEx == null && other.idinformeEx != null) || (this.idinformeEx != null && !this.idinformeEx.equals(other.idinformeEx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Proceso[ idinformeEx=" + idinformeEx + " ]";
    }
    
}
