/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sabas
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByPkidUsuario", query = "SELECT u FROM Usuario u WHERE u.pkidUsuario = :pkidUsuario")
    , @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByMail", query = "SELECT u FROM Usuario u WHERE u.mail = :mail")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento AND u.contraseña = :clave")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idUsuario")
    private Integer pkidUsuario;
    @Basic(optional = false)
    @Column(name = "numeroDocumento")
    private long numeroDocumento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Informe> informeList;
    @JoinColumn(name = "Rol_pk_idRol", referencedColumnName = "pk_idRol")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolpkidRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Intervecion> intervecionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariopkidUsuario", fetch = FetchType.EAGER)
    private List<Proceso> procesoList;

    public Usuario() {
    }

    public Usuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public Usuario(Integer pkidUsuario, long numeroDocumento, String nombre, String apellidos, String mail, String estado, String contraseña) {
        this.pkidUsuario = pkidUsuario;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public Integer getPkidUsuario() {
        return pkidUsuario;
    }

    public void setPkidUsuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

    public Rol getRolpkidRol() {
        return rolpkidRol;
    }

    public void setRolpkidRol(Rol rolpkidRol) {
        this.rolpkidRol = rolpkidRol;
    }

    @XmlTransient
    public List<Intervecion> getIntervecionList() {
        return intervecionList;
    }

    public void setIntervecionList(List<Intervecion> intervecionList) {
        this.intervecionList = intervecionList;
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
