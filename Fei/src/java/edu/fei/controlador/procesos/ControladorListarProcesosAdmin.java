/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.procesos;

import edu.fei.entidad.Proceso;
import edu.fei.facade.ProcesoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David
 */
@Named(value = "controladorListarProcesosAdmin")
@ViewScoped
public class ControladorListarProcesosAdmin implements Serializable{

    @EJB
    private ProcesoFacade procesoFacade;
    private List<Proceso>listaProcesos;

    public ControladorListarProcesosAdmin() {
    }
    
    @PostConstruct
    public void init(){
        listaProcesos = procesoFacade.findAll();
        
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

}