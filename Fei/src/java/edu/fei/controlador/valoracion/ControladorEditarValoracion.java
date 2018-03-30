/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.valoracion;

import edu.fei.entidad.Encuesta;
import edu.fei.entidad.Valoracion;
import edu.fei.facade.EncuestaFacade;
import edu.fei.facade.ValoracionFacade;
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
@Named(value = "controladorEditarValoracion")
@ConversationScoped
public class ControladorEditarValoracion implements Serializable {

    @EJB
    private ValoracionFacade valoracionFacade;
    @Inject
    @EJB
    private EncuestaFacade encuestaFacade;
    @Inject
    private Conversation conversation;
    private Valoracion valoracionSeleccionada;
    private Encuesta encuesta1;
    private Encuesta encuesta2;
    private Encuesta encuesta3;
    private Encuesta encuesta4;
    private Encuesta encuesta5;

    public ControladorEditarValoracion() {
    }

    public Valoracion getValoracionSeleccionada() {
        return valoracionSeleccionada;
    }

    public void setValoracionSeleccionada(Valoracion valoracionSeleccionada) {
        this.valoracionSeleccionada = valoracionSeleccionada;
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

    public void iniciarConversacion() {
        if (conversation.isTransient()) {
            conversation.begin();
        }

    }

    public void terminarConversacion() {
        if (!conversation.isTransient()) {
            conversation.end();
        }

    }

    public String cancelar() {
        terminarConversacion();
        return "/Views/Valoracion/ListarValoraciones.xhtml?faces-redirect=true";
    }

    public String prepararEditar(Valoracion valoracion) {
        iniciarConversacion();
        valoracionSeleccionada = valoracion;

        encuesta1 = valoracionSeleccionada.getEncuestaList().get(0);
        encuesta2 = valoracionSeleccionada.getEncuestaList().get(1);
        encuesta3 = valoracionSeleccionada.getEncuestaList().get(2);
        encuesta4 = valoracionSeleccionada.getEncuestaList().get(3);
        encuesta5 = valoracionSeleccionada.getEncuestaList().get(4);
        return "/Views/Valoracion/EditarValoracion.xhtml?faces-redirect=true";

    }

    public String editar() {
        encuesta1.setValoracionValoracion(valoracionSeleccionada);
        encuesta2.setValoracionValoracion(valoracionSeleccionada);
        encuesta3.setValoracionValoracion(valoracionSeleccionada);
        encuesta4.setValoracionValoracion(valoracionSeleccionada);
        encuesta5.setValoracionValoracion(valoracionSeleccionada);
        valoracionFacade.edit(valoracionSeleccionada);
        encuestaFacade.edit(encuesta1);
        encuestaFacade.edit(encuesta2);
        encuestaFacade.edit(encuesta3);
        encuestaFacade.edit(encuesta4);
        encuestaFacade.edit(encuesta5);
        terminarConversacion();
        return "/Views/Valoracion/ListarValoraciones.xhtml?faces-redirect=true";

    }

}
