/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByPkidUsuario", query = "SELECT u FROM Usuario u WHERE u.pkidUsuario = :pkidUsuario")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuario.findByMail", query = "SELECT u FROM Usuario u WHERE u.mail = :mail")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento AND u.contraseña = :contraseña")
    , @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idUsuario")
    private Integer pkidUsuario;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "estado")
    private String estado;
    @Column(name = "mail")
    private String mail;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;
    @OneToMany(mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Novedad> novedadList;
    @JoinColumn(name = "Rol_pk_idRol", referencedColumnName = "pk_idRol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rolpkidRol;
    @OneToMany(mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Valoracion> valoracionList;
    @OneToMany(mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Actividad> actividadList;
    @OneToMany(mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Proceso> procesoList;

    public Usuario() {
    }

    public Usuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public Integer getPkidUsuario() {
        return pkidUsuario;
    }

    public void setPkidUsuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    public Rol getRolpkidRol() {
        return rolpkidRol;
    }

    public void setRolpkidRol(Rol rolpkidRol) {
        this.rolpkidRol = rolpkidRol;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidUsuario != null ? pkidUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.pkidUsuario == null && other.pkidUsuario != null) || (this.pkidUsuario != null && !this.pkidUsuario.equals(other.pkidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Usuario[ pkidUsuario=" + pkidUsuario + " ]";
    }
    
}
