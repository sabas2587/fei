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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByPkidRol", query = "SELECT r FROM Rol r WHERE r.pkidRol = :pkidRol")
    , @NamedQuery(name = "Rol.findByCargo", query = "SELECT r FROM Rol r WHERE r.cargo = :cargo")
    , @NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idRol")
    private Integer pkidRol;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "rolpkidRol", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;
    @JoinTable(name = "permisos_has_rol", joinColumns = {
        @JoinColumn(name = "Rol_pk_idRol", referencedColumnName = "pk_idRol")}, inverseJoinColumns = {
        @JoinColumn(name = "permisos_pk_idPermiso", referencedColumnName = "pk_idPermiso")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permiso> permisos;

    public Rol() {
    }

    public Rol(Integer pkidRol) {
        this.pkidRol = pkidRol;
    }

    public Integer getPkidRol() {
        return pkidRol;
    }

    public void setPkidRol(Integer pkidRol) {
        this.pkidRol = pkidRol;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidRol != null ? pkidRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.pkidRol == null && other.pkidRol != null) || (this.pkidRol != null && !this.pkidRol.equals(other.pkidRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Rol[ pkidRol=" + pkidRol + " ]";
    }
    
}
