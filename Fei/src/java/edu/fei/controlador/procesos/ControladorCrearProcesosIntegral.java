/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.procesos;

import edu.fei.controlador.login.ControladorSesion;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Proceso;
import edu.fei.entidad.Valoracion;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.ProcesoFacade;
import edu.fei.facade.ValoracionFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author David
 */
@Named(value = "ControladorCrearProcesosIntegral")
@RequestScoped
public class ControladorCrearProcesosIntegral implements Serializable {

    @EJB
    private ProcesoFacade procesoFacade;
    @EJB
    private ValoracionFacade valoracionFacade;
    @EJB
    private AdolescenteFacade adolescenteFacade;
    @Inject
    private ControladorSesion controladorSesion;
    private List<Adolescente> listaAdolescentes;
    private List<Valoracion> listaValoraciones;
    private List<Proceso> listaProcesos;
    private Proceso proceso;

    public ControladorCrearProcesosIntegral() {
    }

    @PostConstruct
    public void init() {
        listaValoraciones = valoracionFacade.findAll();
        listaProcesos = procesoFacade.findAll();
        listaAdolescentes = adolescenteFacade.adolescentesActivos();
        proceso = new Proceso();
        validarValoracionesAdolecente();

    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<Adolescente> getListaAdolescentes() {
        return listaAdolescentes;
    }

    public void setListaAdolescentes(List<Adolescente> listaAdolescentes) {
        this.listaAdolescentes = listaAdolescentes;
    }

    public List<Valoracion> getListaValoraciones() {
        return listaValoraciones;
    }

    public void setListaValoraciones(List<Valoracion> listaValoraciones) {
        this.listaValoraciones = listaValoraciones;
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(List<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public void validarValoracionesAdolecente() {

        for (Adolescente a : new ArrayList<>(this.listaAdolescentes)) {
            if (a.getValoracionList().size() < 4) {
                System.out.println(a.getNombre() + " " + a.getApellidos() + " no tiene 4 valoraciones: " + a.getValoracionList().size());
                this.listaAdolescentes.remove(a);
            }

           /* for (Proceso p : a.getProcesoList()) {
                if (p.getUsuariopkidUsuario().equals(controladorSesion.getUsuarioSesion())) {
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " fue valorado por: " + p.getUsuariopkidUsuario().getPkidUsuario());
                    listaAdolescentes.remove(a);

                }

            }*/

        }

    }

    public String crearProceso() {
        proceso.setTipoproceso("Seguimiento");
        proceso.setTipoConcepto("Concepto integral");
        proceso.setFechaDiagnostico(new Date());
        proceso.setUsuariopkidUsuario(controladorSesion.getUsuarioSesion());
        procesoFacade.create(proceso);
        return "/Views/Proceso/ListarProcesos.xhtml?faces-redirect=true";
        
    }

}