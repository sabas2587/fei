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
 * @author sabas
 */
@Entity
@Table(name = "Informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i")
    , @NamedQuery(name = "Informe.findByIdinformeEx", query = "SELECT i FROM Informe i WHERE i.idinformeEx = :idinformeEx")
    , @NamedQuery(name = "Informe.findByTipoinforme", query = "SELECT i FROM Informe i WHERE i.tipoinforme = :tipoinforme")
    , @NamedQuery(name = "Informe.findByFechaDiagnostico", query = "SELECT i FROM Informe i WHERE i.fechaDiagnostico = :fechaDiagnostico")
    , @NamedQuery(name = "Informe.findByObjetivos", query = "SELECT i FROM Informe i WHERE i.objetivos = :objetivos")
    , @NamedQuery(name = "Informe.findByFortalecimiento", query = "SELECT i FROM Informe i WHERE i.fortalecimiento = :fortalecimiento")
    , @NamedQuery(name = "Informe.findByTrascendencia", query = "SELECT i FROM Informe i WHERE i.trascendencia = :trascendencia")
    , @NamedQuery(name = "Informe.findByCapacidadRestaurativa", query = "SELECT i FROM Informe i WHERE i.capacidadRestaurativa = :capacidadRestaurativa")
    , @NamedQuery(name = "Informe.findByConceptoIntegral", query = "SELECT i FROM Informe i WHERE i.conceptoIntegral = :conceptoIntegral")})
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinformeEx")
    private Integer idinformeEx;
    @Basic(optional = false)
    @Column(name = "tipoinforme")
    private String tipoinforme;
    @Basic(optional = false)
    @Column(name = "fechaDiagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Basic(optional = false)
    @Column(name = "objetivos")
    private String objetivos;
    @Basic(optional = false)
    @Column(name = "fortalecimiento")
    private String fortalecimiento;
    @Basic(optional = false)
    @Column(name = "trascendencia")
    private String trascendencia;
    @Basic(optional = false)
    @Column(name = "capacidadRestaurativa")
    private String capacidadRestaurativa;
    @Basic(optional = false)
    @Column(name = "conceptoIntegral")
    private String conceptoIntegral;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Informe() {
    }

    public Informe(Integer idinformeEx) {
        this.idinformeEx = idinformeEx;
    }

    public Informe(Integer idinformeEx, String tipoinforme, Date fechaDiagnostico, String objetivos, String fortalecimiento, String trascendencia, String capacidadRestaurativa, String conceptoIntegral) {
        this.idinformeEx = idinformeEx;
        this.tipoinforme = tipoinforme;
        this.fechaDiagnostico = fechaDiagnostico;
        this.objetivos = objetivos;
        this.fortalecimiento = fortalecimiento;
        this.trascendencia = trascendencia;
        this.capacidadRestaurativa = capacidadRestaurativa;
        this.conceptoIntegral = conceptoIntegral;
    }

    public Integer getIdinformeEx() {
        return idinformeEx;
    }

    public void setIdinformeEx(Integer idinformeEx) {
        this.idinformeEx = idinformeEx;
    }

    public String getTipoinforme() {
        return tipoinforme;
    }

    public void setTipoinforme(String tipoinforme) {
        this.tipoinforme = tipoinforme;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getFortalecimiento() {
        return fortalecimiento;
    }

    public void setFortalecimiento(String fortalecimiento) {
        this.fortalecimiento = fortalecimiento;
    }

    public String getTrascendencia() {
        return trascendencia;
    }

    public void setTrascendencia(String trascendencia) {
        this.trascendencia = trascendencia;
    }

    public String getCapacidadRestaurativa() {
        return capacidadRestaurativa;
    }

    public void setCapacidadRestaurativa(String capacidadRestaurativa) {
        this.capacidadRestaurativa = capacidadRestaurativa;
    }

    public String getConceptoIntegral() {
        return conceptoIntegral;
    }

    public void setConceptoIntegral(String conceptoIntegral) {
        this.conceptoIntegral = conceptoIntegral;
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
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.idinformeEx == null && other.idinformeEx != null) || (this.idinformeEx != null && !this.idinformeEx.equals(other.idinformeEx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Informe[ idinformeEx=" + idinformeEx + " ]";
    }
    
}
