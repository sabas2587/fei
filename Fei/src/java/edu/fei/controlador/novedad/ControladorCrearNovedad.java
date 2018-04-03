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
import java.util.Date;
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
@Named(value = "controladorCrearNovedad")
@ViewScoped
public class ControladorCrearNovedad implements Serializable{

    @EJB
    private NovedadFacade novedadFacade;
    @EJB
    private AdolescenteFacade adolescenteFacade;
    @Inject
    private ControladorSesion controladorSesion;
    private List<Adolescente> listaAdolescentes;
    private Novedad novedad;

    public ControladorCrearNovedad() {
    }

    @PostConstruct
    public void init() {
        listaAdolescentes = adolescenteFacade.adolescentesActivos();
        novedad = new Novedad();
        validarValoracionesAdolescente();
    }

    public List<Adolescente> getListaAdolescentes() {
        return listaAdolescentes;
    }

    public void setListaAdolescentes(List<Adolescente> listaAdolescentes) {
        this.listaAdolescentes = listaAdolescentes;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public void validarValoracionesAdolescente() {
        for (Adolescente a : new ArrayList<>(listaAdolescentes)) {
            if (a.getValoracionList().isEmpty()) {
                System.out.println(a.getNombre() + " " + a.getApellidos() + " no tiene valoraciones");
                listaAdolescentes.remove(a);

            }

        }

    }

    public String crear() {
        novedad.setFechaintervencion(new Date().toString());
        novedad.setUsuariopkidUsuario(controladorSesion.getUsuarioSesion());
        novedadFacade.create(novedad);
        return "/Views/novedad/ListarNovedades.xhtml?faces-redirect=true";

    }

}