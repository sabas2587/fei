/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.adolecente;

import edu.fei.entidad.Adolescente;
import edu.fei.facade.AdolescenteFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author David
 */
@Named(value = "controladorEditarAdolecente")
@ConversationScoped
public class ControladorEditarAdolecente implements Serializable{

    @EJB
    private AdolescenteFacade adolescenteFacade;
    @Inject
    private Conversation conversation;
    private Adolescente adolescenteSeleccionado;
    
    public ControladorEditarAdolecente() {
    }

    public Adolescente getAdolescenteSeleccionado() {
        return adolescenteSeleccionado;
    }

    public void setAdolescenteSeleccionado(Adolescente adolescenteSeleccionado) {
        this.adolescenteSeleccionado = adolescenteSeleccionado;
    }
    
    public void iniciarConversacion(){
        if(conversation.isTransient()){
            conversation.begin();
        }
        
    }
    
    public void terminarConversacion(){
        if(!conversation.isTransient()){
            conversation.end();
        }
        
    }
    
    public String cancelar(){
        terminarConversacion();
        return "/Views/Adolescente/listAdolescente.xhtml?faces-redirect=true";
    }
    
    public String prepararEditar(Adolescente adolescente){
        iniciarConversacion();
        adolescenteSeleccionado = adolescente;
        return "/Views/Adolescente/editAdolescente.xhtml?faces-redirect=true";
        
    }
    
    public String editar(){
        adolescenteFacade.edit(adolescenteSeleccionado);
        terminarConversacion();
        return "/Views/Adolescente/listAdolescente.xhtml?faces-redirect=true";
    
    }
    
}
