/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.valoracion;

import edu.fei.controlador.login.ControladorSesion;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Encuesta;
import edu.fei.entidad.Valoracion;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.EncuestaFacade;
import edu.fei.facade.ValoracionFacade;
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
 * @author Ismael
 */
@Named(value = "controladorCrearValoracion")
@ViewScoped
public class ControladorCrearValoracion implements Serializable {

    @EJB
    private ValoracionFacade valoracionFacade;
    @EJB
    private AdolescenteFacade adolescenteFacade;
    @EJB
    private EncuestaFacade encuestaFacade;
    @Inject
    private ControladorSesion controladorSesion;
    private List<Adolescente> listaAdolecentes;
    private List<Valoracion> listaValoraciones;
    private Encuesta encuesta1;
    private Encuesta encuesta2;
    private Encuesta encuesta3;
    private Encuesta encuesta4;
    private Encuesta encuesta5;
    private Valoracion valoracion;

    public ControladorCrearValoracion() {
    }

    @PostConstruct
    public void init() {
        listaValoraciones = valoracionFacade.findAll();
        listaAdolecentes = adolescenteFacade.adolescentesActivos();
        valoracion = new Valoracion();
        encuesta1 = new Encuesta("<cambiar pregunta>");
        encuesta2 = new Encuesta("<cambiar pregunta>");
        encuesta3 = new Encuesta("<cambiar pregunta>");
        encuesta4 = new Encuesta("<cambiar pregunta>");
        encuesta5 = new Encuesta("<cambiar pregunta>");
        validarAdolecentes(listaAdolecentes);

    }

    public List<Adolescente> getListaAdolecentes() {
        return listaAdolecentes;
    }

    public void setListaAdolecentes(List<Adolescente> listaAdolecentes) {
        this.listaAdolecentes = listaAdolecentes;
    }

    public Encuesta getEncuesta1() {
        return encuesta1;
    }

    public void setEncuesta1(Encuesta encuesta1) {
        this.encuesta1 = encuesta1;
    }

    public Encuesta getEncuesta2() {
        return encuesta2;
    }

    public void setEncuesta2(Encuesta encuesta2) {
        this.encuesta2 = encuesta2;
    }

    public Encuesta getEncuesta3() {
        return encuesta3;
    }

    public void setEncuesta3(Encuesta encuesta3) {
        this.encuesta3 = encuesta3;
    }

    public Encuesta getEncuesta4() {
        return encuesta4;
    }

    public void setEncuesta4(Encuesta encuesta4) {
        this.encuesta4 = encuesta4;
    }

    public Encuesta getEncuesta5() {
        return encuesta5;
    }

    public void setEncuesta5(Encuesta encuesta5) {
        this.encuesta5 = encuesta5;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public void validarAdolecentes(List<Adolescente> listaAdolecentes) {
        if (listaAdolecentes.isEmpty()) {
            System.out.println("esta vacio");
            this.listaAdolecentes = adolescenteFacade.adolescentesActivos();

        } else {
            System.out.println("no esta vacio");
            for (Adolescente adolescente : new ArrayList<>(listaAdolecentes)) {
                for (Valoracion v : adolescente.getValoracionList()) {
                    if (v.getUsuariopkidUsuario().equals(controladorSesion.getUsuarioSesion())) {
                        System.out.println(v.getAdolescentepkidAdolescente().getNombre());
                        this.listaAdolecentes.remove(v.getAdolescentepkidAdolescente());

                    }

                }

            }

        }

    }

    public String crearValoracion() {
        valoracion.setUsuariopkidUsuario(controladorSesion.getUsuarioSesion());
        valoracion.setFechaValoracion(new Date());
        encuesta1.setValoracionValoracion(valoracion);
        encuesta2.setValoracionValoracion(valoracion);
        encuesta3.setValoracionValoracion(valoracion);
        encuesta4.setValoracionValoracion(valoracion);
        encuesta5.setValoracionValoracion(valoracion);
        valoracionFacade.create(valoracion);
        encuestaFacade.create(encuesta1);
        encuestaFacade.create(encuesta2);
        encuestaFacade.create(encuesta3);
        encuestaFacade.create(encuesta4);
        encuestaFacade.create(encuesta5);
        return "/Views/Valoracion/ListarValoraciones.xhtml?faces-redirect=true";

    }

}
