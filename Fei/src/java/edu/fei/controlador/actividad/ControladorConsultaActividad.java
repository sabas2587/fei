/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.actividad;

import edu.fei.controlador.login.ControladorSesion;
import edu.fei.controlador.mail.Mailer;
import edu.fei.entidad.Actividad;
import edu.fei.entidad.Usuario;
import edu.fei.facade.ActividadFacade;
import edu.fei.facade.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author sabas
 */
@Named(value = "controladorConsultaActividad")
@ViewScoped
public class ControladorConsultaActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Actividad actividad;
    private ScheduleModel eventomodelo;
    private List<Actividad> listaActividad;
    private List<Actividad> numeroIniciada;
    private List<Actividad> numeroProceso;
    private List<Actividad> numeroFinalizada;
    private Usuario usuarioseleccionado;
    private List<Usuario> listaUsuarios;

    @EJB
    private ActividadFacade actividadFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    @Inject
    private ControladorSesion controladorSesion;

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios=usuarioFacade.findAll();
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    
    
    public Usuario getUsuarioseleccionado() {
        return usuarioseleccionado;
    }

    public void setUsuarioseleccionado(Usuario usuarioseleccionado) {
        this.usuarioseleccionado = usuarioseleccionado;
    }

    public List<Actividad> getNumeroIniciada() {
        return numeroIniciada;
    }

    public void setNumeroIniciada(List<Actividad> numeroIniciada) {
        this.numeroIniciada = numeroIniciada;
    }

    public List<Actividad> getNumeroProceso() {
        return numeroProceso;
    }

    public void setNumeroProceso(List<Actividad> numeroProceso) {
        this.numeroProceso = numeroProceso;
    }

    public List<Actividad> getNumeroFinalizada() {
        return numeroFinalizada;
    }

    public void setNumeroFinalizada(List<Actividad> numeroFinalizada) {
        this.numeroFinalizada = numeroFinalizada;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public ScheduleModel getEventomodelo() {
        return eventomodelo;
    }

    public void setEventomodelo(ScheduleModel eventomodelo) {
        this.eventomodelo = eventomodelo;
    }

    public List<Actividad> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public ControladorConsultaActividad() {

    }

    @PostConstruct
    public void init() {

        eventomodelo = new DefaultScheduleModel();        
        cargarActividades();
       

        try {
           
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "error sql"));

        }

        for (Actividad ev : listaActividad) {

            DefaultScheduleEvent evt = new DefaultScheduleEvent();

            evt.setEndDate(ev.getFechaFinal());
            evt.setStartDate(ev.getFechaInicial());
            evt.setTitle(ev.getNombreActividad());
            evt.setData(ev.getPkidActividades());
            evt.setDescription(ev.getDescripcionActividad());
            evt.setAllDay(true);
            evt.setEditable(true);

            if ("1".equals(ev.getEstado())) {
                evt.setStyleClass("emp1");
            } else if ("2".equals(ev.getEstado())) {
                evt.setStyleClass("emp2");
            } else if ("3".equals(ev.getEstado())) {
                evt.setStyleClass("emp3");
            }

            eventomodelo.addEvent(evt);
        }
    }

    public void seleccionado(SelectEvent selectEvent) {

        ScheduleEvent act = (ScheduleEvent) selectEvent.getObject();

        for (Actividad ac : listaActividad) {
            if (ac.getNombreActividad() == act.getTitle()) {
                actividad = ac;

            }
        }
    }

    public void cargarActividades() {
        actividad = new Actividad(); 
        usuarioseleccionado = new Usuario();
        listaActividad = actividadFacade.findSessionProfesional(usuarioseleccionado);
      
    }

}
