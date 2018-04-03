/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.adolecente;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Proceso;
import edu.fei.facade.AdolescenteFacade;
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
@Named(value = "controladorListarAdolecentesInactivos")
@ViewScoped
public class ControladorListarAdolecentesInactivos implements  Serializable{

    @EJB
    private ProcesoFacade procesoFacade;
    private List<Proceso>listaProcesos;
    
    public ControladorListarAdolecentesInactivos() {
    }
    
    @PostConstruct
    public void init(){
        listaProcesos = procesoFacade.listarAdolescentesInactivos();
        
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

}