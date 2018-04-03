/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.novedad;

import edu.fei.controlador.login.ControladorSesion;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Novedad;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.NovedadFacade;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "controladorListarNovedad")
@ViewScoped
public class ControladorListarNovedad implements Serializable {

    @EJB
    private NovedadFacade novedadFacade;
    @EJB
    private AdolescenteFacade adolescenteFacade;
    private List<Adolescente> listaAdolescentes;
    private List<Novedad> listaNovedades;
    private Adolescente adolescente;

    public ControladorListarNovedad() {
    }

    @PostConstruct
    public void init() {
        listaAdolescentes = adolescenteFacade.adolescentesActivos();
    }

    public List<Adolescente> getListaAdolescentes() {
        return listaAdolescentes;
    }

    public void setListaAdolescentes(List<Adolescente> listaAdolescentes) {
        this.listaAdolescentes = listaAdolescentes;
    }

    public List<Novedad> getListaNovedades() {
        return listaNovedades;
    }

    public void setListaNovedades(List<Novedad> listaNovedades) {
        this.listaNovedades = listaNovedades;
    }

    public Adolescente getAdolescente() {
        return adolescente;
    }

    public void setAdolescente(Adolescente adolescente) {
        this.adolescente = adolescente;
    }

    public List<Novedad> listarNovedades(){
        return novedadFacade.listarNovedadesPorAdolecente(adolescente);
    }
    
}
