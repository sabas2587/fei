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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "remision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remision.findAll", query = "SELECT r FROM Remision r")
    , @NamedQuery(name = "Remision.findByPkordenRemision", query = "SELECT r FROM Remision r WHERE r.pkordenRemision = :pkordenRemision")
    , @NamedQuery(name = "Remision.findByAutoridad", query = "SELECT r FROM Remision r WHERE r.autoridad = :autoridad")
    , @NamedQuery(name = "Remision.findByFechaRemision", query = "SELECT r FROM Remision r WHERE r.fechaRemision = :fechaRemision")
    , @NamedQuery(name = "Remision.findByTipoRemision", query = "SELECT r FROM Remision r WHERE r.tipoRemision = :tipoRemision")})
public class Remision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ordenRemision")
    private Integer pkordenRemision;
    @Column(name = "autoridad")
    private String autoridad;
    @Column(name = "fechaRemision")
    @Temporal(TemporalType.DATE)
    private Date fechaRemision;
    @Column(name = "tipoRemision")
    private String tipoRemision;
    @OneToMany(mappedBy = "remisionpkordenRemision", fetch = FetchType.EAGER)
    private List<Adolescente> adolescenteList;

    public Remision() {
    }

    public Remision(Integer pkordenRemision) {
        this.pkordenRemision = pkordenRemision;
    }

    public Integer getPkordenRemision() {
        return pkordenRemision;
    }

    public void setPkordenRemision(Integer pkordenRemision) {
        this.pkordenRemision = pkordenRemision;
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }

    public Date getFechaRemision() {
        return fechaRemision;
    }

    public void setFechaRemision(Date fechaRemision) {
        this.fechaRemision = fechaRemision;
    }

    public String getTipoRemision() {
        return tipoRemision;
    }

    public void setTipoRemision(String tipoRemision) {
        this.tipoRemision = tipoRemision;
    }

    @XmlTransient
    public List<Adolescente> getAdolescenteList() {
        return adolescenteList;
    }

    public void setAdolescenteList(List<Adolescente> adolescenteList) {
        this.adolescenteList = adolescenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkordenRemision != null ? pkordenRemision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remision)) {
            return false;
        }
        Remision other = (Remision) object;
        if ((this.pkordenRemision == null && other.pkordenRemision != null) || (this.pkordenRemision != null && !this.pkordenRemision.equals(other.pkordenRemision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Remision[ pkordenRemision=" + pkordenRemision + " ]";
    }
    
}
