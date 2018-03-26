/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.login;

import edu.fei.entidad.Permiso;
import edu.fei.entidad.Usuario;
import edu.fei.facade.UsuarioFacade;
import java.io.IOException;
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
@Named(value = "controladorSesion")
@SessionScoped
public class ControladorSesion implements Serializable {

    @EJB
    UsuarioFacade usuariosFacade;
    Usuario usuarioSesion;
    List<Usuario> listaUsuario;
    private int numdocumento;
    private String clave;
    private String stringMenu = "";

    public ControladorSesion() {
    }

    @PostConstruct
    public void init() {
    }

    public String getStringMenu() {
        return stringMenu;
    }

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

    public String iniciarSesion() {
        usuarioSesion = usuariosFacade.inicioSesion(numdocumento, clave);
        if (usuarioSesion != null) {
            System.out.println(usuarioSesion.getNombre());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLog", usuarioSesion);
            renderizarPermisos(usuarioSesion.getRolpkidRol().getPermisoList());
            return "/Views/PaginaInicioUsuario.xhtml?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario y/o clave incorrectas"));
            return "";

        }

    }

    public void mostrarSession() {
        Usuario usuarioSesionActiva = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog");

    }

    public void cerrarSesion() throws IOException {
        clave = "";
        stringMenu = "";
        numdocumento = 0;
        usuarioSesion = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.xhtml?faces-redirect=true");

    }

    public void renderizarPermisos(List<Permiso> permisos) {
        System.out.println("renderizando permisos");
        for (Permiso permiso : permisos) {
            if (permiso.getPermisoPadre() == null) {
                System.out.println("permiso: " + permiso.getNombrePermiso() + " - " + permiso.getPermisoPadre() + " - " + permiso.getUrl() + " - ");
                stringMenu += "<li class=\"sub-menu\">\n"
                        + "<a href=\"javascript:;\" >\n"
                        + "<i class=\"" + permiso.getIcon() + "\"></i>\n"
                        + "<span>" + permiso.getNombrePermiso() + "</span>\n"
                        + "</a>\n";
                for (Permiso subpermiso : permiso.getSubPermisos()) {
                    for (Permiso p1 : permisos) {
                        if (permiso.equals(p1)) {
                            System.out.println("subPermiso: " + subpermiso.getNombrePermiso() + " - " + subpermiso.getPermisoPadre() + " - " + subpermiso.getUrl() + " - ");
                            stringMenu += "<ul class=\"sub\">\n"
                                    + "<li><a  href=\"" + subpermiso.getUrl() + "\">" + subpermiso.getNombrePermiso() + "</a></li>\n"
                                    + "</ul>\n";

                        }

                    }

                }

            }

        }
        stringMenu += "</li>";
        System.out.println("\npermiso= " + stringMenu + "\n");

    }

    public void validarSesion() throws IOException {
        if (!isValidado()) {
            cerrarSesion();

        }

    }

    public boolean isValidado() {
        if (usuarioSesion != null) {
            return true;

        }
        return false;

    }

}
