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
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByPkidActividades", query = "SELECT a FROM Actividad a WHERE a.pkidActividades = :pkidActividades")
    , @NamedQuery(name = "Actividad.findByDescripcionActividad", query = "SELECT a FROM Actividad a WHERE a.descripcionActividad = :descripcionActividad")
    , @NamedQuery(name = "Actividad.findByEstado", query = "SELECT a FROM Actividad a WHERE a.estado = :estado")
    , @NamedQuery(name = "Actividad.findByFechaFinal", query = "SELECT a FROM Actividad a WHERE a.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Actividad.findByFechaInicial", query = "SELECT a FROM Actividad a WHERE a.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "Actividad.findByListaactividad", query = "SELECT a FROM Actividad a WHERE a.listaactividad = :listaactividad")
    , @NamedQuery(name = "Actividad.findByNombreActividad", query = "SELECT a FROM Actividad a WHERE a.nombreActividad = :nombreActividad")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idActividades")
    private Long pkidActividades;
    @Column(name = "descripcionActividad")
    private String descripcionActividad;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "fechaInicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "listaactividad")
    private String listaactividad;
    @Column(name = "nombreActividad")
    private String nombreActividad;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Actividad() {
    }

    public Actividad(Long pkidActividades) {
        this.pkidActividades = pkidActividades;
    }

    public Long getPkidActividades() {
        return pkidActividades;
    }

    public void setPkidActividades(Long pkidActividades) {
        this.pkidActividades = pkidActividades;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getListaactividad() {
        return listaactividad;
    }

    public void setListaactividad(String listaactividad) {
        this.listaactividad = listaactividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
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
        hash += (pkidActividades != null ? pkidActividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.pkidActividades == null && other.pkidActividades != null) || (this.pkidActividades != null && !this.pkidActividades.equals(other.pkidActividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Actividad[ pkidActividades=" + pkidActividades + " ]";
    }
    
}
