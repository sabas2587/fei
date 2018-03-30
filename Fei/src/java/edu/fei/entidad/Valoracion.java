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
 * @author David
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByValoracion", query = "SELECT v FROM Valoracion v WHERE v.valoracion = :valoracion")
    , @NamedQuery(name = "Valoracion.findByFechaValoracion", query = "SELECT v FROM Valoracion v WHERE v.fechaValoracion = :fechaValoracion")
    , @NamedQuery(name = "Valoracion.findByTipoactividad", query = "SELECT v FROM Valoracion v WHERE v.tipoactividad = :tipoactividad")
    , @NamedQuery(name = "Valoracion.findByRecomendacion", query = "SELECT v FROM Valoracion v WHERE v.recomendacion = :recomendacion")
    , @NamedQuery(name = "Valoracion.findValoracionesUsuarioValidado", query = "SELECT v FROM Valoracion v WHERE v.usuariopkidUsuario = :usuariopkidUsuario")
    , @NamedQuery(name = "Valoracion.findValoracionesPorAdolecente", query = "SELECT v FROM Valoracion v WHERE v.adolescentepkidAdolescente = :adolescentepkidAdolescente ")
    , @NamedQuery(name = "Valoracion.findByConceptoIntegral", query = "SELECT v FROM Valoracion v WHERE v.conceptoIntegral = :conceptoIntegral")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "valoracion")
    private Integer valoracion;
    @Column(name = "fechaValoracion")
    @Temporal(TemporalType.DATE)
    private Date fechaValoracion;
    @Column(name = "tipoactividad")
    private String tipoactividad;
    @Column(name = "recomendacion")
    private String recomendacion;
    @Column(name = "concepto_integral")
    private String conceptoIntegral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valoracionValoracion", fetch = FetchType.EAGER)
    private List<Encuesta> encuestaList;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Valoracion() {
    }

    public Valoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getConceptoIntegral() {
        return conceptoIntegral;
    }

    public void setConceptoIntegral(String conceptoIntegral) {
        this.conceptoIntegral = conceptoIntegral;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
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
        hash += (valoracion != null ? valoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.valoracion == null && other.valoracion != null) || (this.valoracion != null && !this.valoracion.equals(other.valoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Valoracion[ valoracion=" + valoracion + " ]";
    }
    
}
