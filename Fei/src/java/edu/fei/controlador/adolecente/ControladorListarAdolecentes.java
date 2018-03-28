/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.adolecente;

import edu.fei.entidad.Adolescente;
import edu.fei.facade.AdolescenteFacade;
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
@Named(value = "controladorListarAdolecentes")
@ViewScoped
public class ControladorListarAdolecentes implements  Serializable{

    @EJB
    private AdolescenteFacade adolescenteFacade;
    private List<Adolescente>listaAdolecentes;
    
    public ControladorListarAdolecentes() {
    }
    
    @PostConstruct
    public void init(){
        listaAdolecentes = adolescenteFacade.findAll();
        
    }

    public List<Adolescente> getListaAdolecentes() {
        return listaAdolecentes;
    }

}