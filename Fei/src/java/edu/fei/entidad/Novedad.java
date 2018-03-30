/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByIdintervecion", query = "SELECT n FROM Novedad n WHERE n.idintervecion = :idintervecion")
    , @NamedQuery(name = "Novedad.findByFechaintervencion", query = "SELECT n FROM Novedad n WHERE n.fechaintervencion = :fechaintervencion")
    , @NamedQuery(name = "Novedad.findByTipointervencion", query = "SELECT n FROM Novedad n WHERE n.tipointervencion = :tipointervencion")
    , @NamedQuery(name = "Novedad.findByDescripcion", query = "SELECT n FROM Novedad n WHERE n.descripcion = :descripcion")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idintervecion")
    private Integer idintervecion;
    @Column(name = "fechaintervencion")
    private String fechaintervencion;
    @Column(name = "tipointervencion")
    private String tipointervencion;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Novedad() {
    }

    public Novedad(Integer idintervecion) {
        this.idintervecion = idintervecion;
    }

    public Integer getIdintervecion() {
        return idintervecion;
    }

    public void setIdintervecion(Integer idintervecion) {
        this.idintervecion = idintervecion;
    }

    public String getFechaintervencion() {
        return fechaintervencion;
    }

    public void setFechaintervencion(String fechaintervencion) {
        this.fechaintervencion = fechaintervencion;
    }

    public String getTipointervencion() {
        return tipointervencion;
    }

    public void setTipointervencion(String tipointervencion) {
        this.tipointervencion = tipointervencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idintervecion != null ? idintervecion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.idintervecion == null && other.idintervecion != null) || (this.idintervecion != null && !this.idintervecion.equals(other.idintervecion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Novedad[ idintervecion=" + idintervecion + " ]";
    }
    
}
