/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.procesos;

import edu.fei.controlador.valoracion.*;
import edu.fei.controlador.adolecente.*;
import edu.fei.controlador.login.ControladorSesion;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Proceso;
import edu.fei.entidad.Rol;
import edu.fei.entidad.Valoracion;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.ProcesoFacade;
import edu.fei.facade.ValoracionFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author David
 */
@Named(value = "controladorListarProcesos")
@ViewScoped
public class ControladorListarProcesos implements Serializable {

    @EJB
    private ProcesoFacade procesoFacade;
    @Inject
    private ControladorSesion controladorSesion;
    private List<Proceso> listaProcesos;

    public ControladorListarProcesos() {
    }

    @PostConstruct
    public void init() {
        if (controladorSesion.getUsuarioSesion().getRolpkidRol().equals(new Rol(1))) {
            System.out.println("es admin");
            listaProcesos = procesoFacade.findAll();

        } else {
            System.out.println("es profecional");
            listaProcesos = procesoFacade.listarProcesosUsuarioSesion(controladorSesion.getUsuarioSesion());

        }

    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

}
