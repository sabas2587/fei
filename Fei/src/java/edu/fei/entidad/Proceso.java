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
@Table(name = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    , @NamedQuery(name = "Proceso.findByPkidValoracion", query = "SELECT p FROM Proceso p WHERE p.pkidValoracion = :pkidValoracion")
    , @NamedQuery(name = "Proceso.findByTipoactividad", query = "SELECT p FROM Proceso p WHERE p.tipoactividad = :tipoactividad")
     , @NamedQuery(name = "Proceso.findByadolescenteValorado", query = "SELECT p FROM Proceso p WHERE p.adolescentepkidAdolescente = :adolescentepkidAdolescente AND p.usuariopkidUsuario = :usuariopkidUsuario AND p.tipoactividad = 'Seguimiento'")     
    , @NamedQuery(name = "Proceso.findByFechaValoracion", query = "SELECT p FROM Proceso p WHERE p.fechaValoracion = :fechaValoracion")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idValoracion")
    private Integer pkidValoracion;
    @Column(name = "tipoactividad")
    private String tipoactividad;
    @Basic(optional = false)
    @Column(name = "fechaValoracion")
    @Temporal(TemporalType.DATE)
    private Date fechaValoracion;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Encuesta_pk_idencuesta", referencedColumnName = "pk_idencuesta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Encuesta encuestapkidencuesta;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Proceso() {
    }

    public Proceso(Integer pkidValoracion) {
        this.pkidValoracion = pkidValoracion;
    }

    public Proceso(Integer pkidValoracion, Date fechaValoracion) {
        this.pkidValoracion = pkidValoracion;
        this.fechaValoracion = fechaValoracion;
    }

    public Integer getPkidValoracion() {
        return pkidValoracion;
    }

    public void setPkidValoracion(Integer pkidValoracion) {
        this.pkidValoracion = pkidValoracion;
    }

    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public Adolescente getAdolescentepkidAdolescente() {
        return adolescentepkidAdolescente;
    }

    public void setAdolescentepkidAdolescente(Adolescente adolescentepkidAdolescente) {
        this.adolescentepkidAdolescente = adolescentepkidAdolescente;
    }

    public Encuesta getEncuestapkidencuesta() {
        return encuestapkidencuesta;
    }

    public void setEncuestapkidencuesta(Encuesta encuestapkidencuesta) {
        this.encuestapkidencuesta = encuestapkidencuesta;
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
        hash += (pkidValoracion != null ? pkidValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.pkidValoracion == null && other.pkidValoracion != null) || (this.pkidValoracion != null && !this.pkidValoracion.equals(other.pkidValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Proceso[ pkidValoracion=" + pkidValoracion + " ]";
    }
    
}
