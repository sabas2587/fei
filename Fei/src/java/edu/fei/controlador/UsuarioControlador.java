/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador;

import edu.fei.entidad.Permiso;
import edu.fei.entidad.Usuario;
import edu.fei.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfgm
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    public UsuarioControlador() {
    }
    @EJB
    UsuarioFacade usuariosFacade;

    Usuario usuarioSesion;
    List<Usuario> listaUsuario;
    private int numdocumento;
    private String clave;

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public UsuarioFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuarioFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    @PostConstruct
    public void init() {

    }

    public String iniciarSesion() {

        try {
            usuarioSesion = usuariosFacade.inicioSesion(numdocumento, clave);

            if (usuarioSesion != null) {
                System.out.println(usuarioSesion.getNombre());

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLog", usuarioSesion);

                for (Permiso p : usuarioSesion.getRolpkidRol().getPermisoList()) {
                    System.out.println(p.getNombrePermiso());
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario y/o clave incorrectas"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));

        }

        return "/Views/Valoracion.xhtml?faces-redirect=true";
    }

    public void mostrarSession() {

        Usuario usuarioSesionActiva = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog");
    }

    public String cerrarSesion() {
        String redireccion = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return redireccion = "../index.xhtml";

    }
}
