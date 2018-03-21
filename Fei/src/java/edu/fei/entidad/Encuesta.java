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
@Table(name = "Encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByPkIdencuesta", query = "SELECT e FROM Encuesta e WHERE e.pkIdencuesta = :pkIdencuesta")
    , @NamedQuery(name = "Encuesta.findByPregunta", query = "SELECT e FROM Encuesta e WHERE e.pregunta = :pregunta")
    , @NamedQuery(name = "Encuesta.findByCriterio", query = "SELECT e FROM Encuesta e WHERE e.criterio = :criterio")
    , @NamedQuery(name = "Encuesta.findByEscala", query = "SELECT e FROM Encuesta e WHERE e.escala = :escala")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idencuesta")
    private Integer pkIdencuesta;
    @Basic(optional = false)
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "criterio")
    private String criterio;
    @Column(name = "escala")
    private String escala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encuestapkidencuesta", fetch = FetchType.EAGER)
    private List<Proceso> procesoList;

    public Encuesta() {
    }

    public Encuesta(Integer pkIdencuesta) {
        this.pkIdencuesta = pkIdencuesta;
    }

    public Encuesta(Integer pkIdencuesta, String pregunta) {
        this.pkIdencuesta = pkIdencuesta;
        this.pregunta = pregunta;
    }

    public Integer getPkIdencuesta() {
        return pkIdencuesta;
    }

    public void setPkIdencuesta(Integer pkIdencuesta) {
        this.pkIdencuesta = pkIdencuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
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
        hash += (pkIdencuesta != null ? pkIdencuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.pkIdencuesta == null && other.pkIdencuesta != null) || (this.pkIdencuesta != null && !this.pkIdencuesta.equals(other.pkIdencuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.fei.entidad.Encuesta[ pkIdencuesta=" + pkIdencuesta + " ]";
    }
    
}
