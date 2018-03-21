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
 * @author sabas
 */
@Entity
@Table(name = "acudiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acudiente.findAll", query = "SELECT a FROM Acudiente a")
    , @NamedQuery(name = "Acudiente.findByPkidAcudiente", query = "SELECT a FROM Acudiente a WHERE a.pkidAcudiente = :pkidAcudiente")
    , @NamedQuery(name = "Acudiente.findByNombre", query = "SELECT a FROM Acudiente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Acudiente.findByTelefono", query = "SELECT a FROM Acudiente a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Acudiente.findByEmail", query = "SELECT a FROM Acudiente a WHERE a.email = :email")})
public class Acudiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idAcudiente")
    private Integer pkidAcudiente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "Adolescente_pk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Adolescente adolescentepkidAdolescente;

    public Acudiente() {
    }

    public Acudiente(Integer pkidAcudiente) {
        this.pkidAcudiente = pkidAcudiente;
    }

    public Acudiente(Integer pkidAcudiente, String nombre, int telefono, String email) {
        this.pkidAcudiente = pkidAcudiente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getPkidAcudiente() {
        return pkidAcudiente;
    }

    public void setPkidAcudiente(Integer pkidAcudiente) {
        this.pkidAcudiente = pkidAcudiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adolescente getAdolescentepkidAdolescente() {
        return adolescentepkidAdolescente;
    }

    public void setAdolescentepkidAdolescente(Adolescente adolescentepkidAdolescente) {
        this.adolescentepkidAdolescente = adolescentepkidAdolescente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidAcudiente != null ? pkidAcudiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acudiente)) {
            return false;
        }
        Acudiente other = (Acudiente) object;
        if ((this.pkidAcudiente == null && other.pkidAcudiente != null) || (this.pkidAcudiente != null && !this.pkidAcudiente.equals(other.pkidAcudiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Acudiente[ pkidAcudiente=" + pkidAcudiente + " ]";
    }
    
}
