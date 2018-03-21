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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sabas
 */
@Entity
@Table(name = "intervecion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervecion.findAll", query = "SELECT i FROM Intervecion i")
    , @NamedQuery(name = "Intervecion.findByIdintervecion", query = "SELECT i FROM Intervecion i WHERE i.idintervecion = :idintervecion")
    , @NamedQuery(name = "Intervecion.findByFechaintervencion", query = "SELECT i FROM Intervecion i WHERE i.fechaintervencion = :fechaintervencion")
    , @NamedQuery(name = "Intervecion.findByTipointervencion", query = "SELECT i FROM Intervecion i WHERE i.tipointervencion = :tipointervencion")})
public class Intervecion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idintervecion")
    private Integer idintervecion;
    @Column(name = "fechaintervencion")
    private String fechaintervencion;
    @Column(name = "tipointervencion")
    private String tipointervencion;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;
    @JoinColumn(name = "Usuario_pk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariopkidUsuario;

    public Intervecion() {
    }

    public Intervecion(Integer idintervecion) {
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
        if (!(object instanceof Intervecion)) {
            return false;
        }
        Intervecion other = (Intervecion) object;
        if ((this.idintervecion == null && other.idintervecion != null) || (this.idintervecion != null && !this.idintervecion.equals(other.idintervecion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Intervecion[ idintervecion=" + idintervecion + " ]";
    }
    
}
