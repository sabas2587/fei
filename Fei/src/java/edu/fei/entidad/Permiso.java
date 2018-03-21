/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sabas
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByPkidPermiso", query = "SELECT p FROM Permiso p WHERE p.pkidPermiso = :pkidPermiso")
    , @NamedQuery(name = "Permiso.findByNombrePermiso", query = "SELECT p FROM Permiso p WHERE p.nombrePermiso = :nombrePermiso")
    , @NamedQuery(name = "Permiso.findByNombrePermisoEn", query = "SELECT p FROM Permiso p WHERE p.nombrePermisoEn = :nombrePermisoEn")
    , @NamedQuery(name = "Permiso.findByIcon", query = "SELECT p FROM Permiso p WHERE p.icon = :icon")
    , @NamedQuery(name = "Permiso.findByActive", query = "SELECT p FROM Permiso p WHERE p.active = :active")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPermiso")
    private Integer pkidPermiso;
    @Basic(optional = false)
    @Column(name = "nombre_permiso")
    private String nombrePermiso;
    @Basic(optional = false)
    @Column(name = "nombre_permiso_en")
    private String nombrePermisoEn;
    @Lob
    @Column(name = "url")
    private String url;
    @Column(name = "icon")
    private String icon;
    @Column(name = "active")
    private String active;
    @ManyToMany(mappedBy = "permisoList", fetch = FetchType.EAGER)
    private List<Rol> rolList;
    @OneToMany(mappedBy = "permisoPadre", fetch = FetchType.EAGER)
    private List<Permiso> permisoList;
    @JoinColumn(name = "permiso_padre", referencedColumnName = "pk_idPermiso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Permiso permisoPadre;

    public Permiso() {
    }

    public Permiso(Integer pkidPermiso) {
        this.pkidPermiso = pkidPermiso;
    }

    public Permiso(Integer pkidPermiso, String nombrePermiso, String nombrePermisoEn) {
        this.pkidPermiso = pkidPermiso;
        this.nombrePermiso = nombrePermiso;
        this.nombrePermisoEn = nombrePermisoEn;
    }

    public Integer getPkidPermiso() {
        return pkidPermiso;
    }

    public void setPkidPermiso(Integer pkidPermiso) {
        this.pkidPermiso = pkidPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getNombrePermisoEn() {
        return nombrePermisoEn;
    }

    public void setNombrePermisoEn(String nombrePermisoEn) {
        this.nombrePermisoEn = nombrePermisoEn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getPermisoPadre() {
        return permisoPadre;
    }

    public void setPermisoPadre(Permiso permisoPadre) {
        this.permisoPadre = permisoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPermiso != null ? pkidPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.pkidPermiso == null && other.pkidPermiso != null) || (this.pkidPermiso != null && !this.pkidPermiso.equals(other.pkidPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Permiso[ pkidPermiso=" + pkidPermiso + " ]";
    }
    
}
