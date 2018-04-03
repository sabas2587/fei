    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.actividad;


import edu.fei.controlador.login.ControladorSesion;
import edu.fei.controlador.mail.Mailer;
import edu.fei.entidad.Actividad;
import edu.fei.facade.ActividadFacade;
import edu.fei.facade.UsuarioFacade;
import java.io.Serializable;
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
@Named(value = "controladorActividad")
@ViewScoped
public class ControladorActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Actividad actividad;
    private ScheduleModel eventomodelo;
    private List<Actividad> listaActividad;
    private List<Actividad> numeroIniciada;
    private List<Actividad> numeroProceso;
    private List<Actividad> numeroFinalizada;


    @EJB
    private ActividadFacade actividadFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @Inject
    private ControladorSesion controladorSesion;

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
    
    
    public ControladorActividad() {
        
    }
    
    
    @PostConstruct
    public void init() {
    
        eventomodelo = new DefaultScheduleModel();
        Mailer mail = new Mailer();

        try {
            
            listaActividad = actividadFacade.findSession(controladorSesion.getUsuarioSesion());
            numeroIniciada = actividadFacade.countIniciada(controladorSesion.getUsuarioSesion());
            numeroProceso = actividadFacade.countProceso(controladorSesion.getUsuarioSesion());
            numeroFinalizada = actividadFacade.countFinalizada(controladorSesion.getUsuarioSesion());
            
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
            }else if ("3".equals(ev.getEstado())) {               
                evt.setStyleClass("emp3");
            }
            

            eventomodelo.addEvent(evt);
        }
    }

 public void seleccionado(SelectEvent selectEvent) {

        ScheduleEvent act = (ScheduleEvent) selectEvent.getObject();

        for (Actividad ac: listaActividad) {
            if (ac.getNombreActividad() == act.getTitle()){
                actividad = ac;

            }
        }
    }
 
  public void eventNuevo(SelectEvent selectEvent) {

        ScheduleEvent act = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        actividad = new Actividad();
        actividad.setFechaInicial(new java.util.Date(act.getStartDate().getTime()));
        actividad.setFechaFinal(new java.util.Date(act.getEndDate().getTime()));
    }
  
   
  
    
   public void eventMovimiento(ScheduleEntryMoveEvent event) {

 
        for (Actividad ac : listaActividad) {
          
            if (ac.getNombreActividad()== event.getScheduleEvent().getTitle()) {
                actividad = ac;
                try {
                    actividadFacade.edit(actividad);
                    init();
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "redimenzionar", "error al ridimenzionar" + ex.getMessage()));
                }
                break;
            }

        }

    }

    public void eventRedimensionado(ScheduleEntryResizeEvent acti) {

        for (Actividad ac : listaActividad) {
            if (ac.getNombreActividad() ==  acti.getScheduleEvent().getTitle()) {
                actividad = ac;
                try {
                    actividadFacade.edit(actividad);
                    init();
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "redimenzionar", "error al ridimenzionar" + ex.getMessage()));
                }
                break;
            }

        }
    }
    
    
 public void guardar() {

        if (actividad.getPkidActividades()== null) {
            if (actividad.getFechaInicial().getTime() <= actividad.getFechaFinal().getTime()) {
                try {
                    actividad.setUsuariopkidUsuario(controladorSesion.getUsuarioSesion());
                    actividadFacade.create(actividad);
                    Mailer.send(controladorSesion.getUsuarioSesion().getMail(),"Actividad Creada",actividad );             
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "super","tarea guardada correctamente"));
                    init();
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "holaaarror evento al guardar", "fecha mal" + ex.getMessage()));
                }
                actividad = new Actividad();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "hello", "fecha mal"));
            }
        } else {
            try {
                actividadFacade.edit(actividad);
                init();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "eerror evento al guardar", "fecha mal" + ex.getMessage()));
            }

        }
 }
 
 
 
}
