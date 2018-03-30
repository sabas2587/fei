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
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByPkIdencuesta", query = "SELECT e FROM Encuesta e WHERE e.pkIdencuesta = :pkIdencuesta")
    , @NamedQuery(name = "Encuesta.findByEscala", query = "SELECT e FROM Encuesta e WHERE e.escala = :escala")
    , @NamedQuery(name = "Encuesta.findByPregunta", query = "SELECT e FROM Encuesta e WHERE e.pregunta = :pregunta")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idencuesta")
    private Integer pkIdencuesta;
    @Column(name = "escala")
    private Integer escala;
    @Column(name = "pregunta")
    private String pregunta;
    @JoinColumn(name = "valoracion_valoracion", referencedColumnName = "valoracion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Valoracion valoracionValoracion;

    public Encuesta() {
    }

    public Encuesta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    public Encuesta(Integer pkIdencuesta) {
        this.pkIdencuesta = pkIdencuesta;
    }

    public Integer getPkIdencuesta() {
        return pkIdencuesta;
    }

    public void setPkIdencuesta(Integer pkIdencuesta) {
        this.pkIdencuesta = pkIdencuesta;
    }

    public Integer getEscala() {
        return escala;
    }

    public void setEscala(Integer escala) {
        this.escala = escala;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Valoracion getValoracionValoracion() {
        return valoracionValoracion;
    }

    public void setValoracionValoracion(Valoracion valoracionValoracion) {
        this.valoracionValoracion = valoracionValoracion;
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
