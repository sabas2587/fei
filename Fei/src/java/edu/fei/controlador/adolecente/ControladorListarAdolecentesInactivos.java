/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.adolecente;

import edu.fei.controlador.login.ControladorSesion;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Proceso;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.ProcesoFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author David
 */
@Named(value = "controladorListarAdolecentesInactivos")
@ViewScoped
public class ControladorListarAdolecentesInactivos implements Serializable {

    @EJB
    private ProcesoFacade procesoFacade;
    @Inject
    private ControladorSesion controladorSesion;
    private List<Proceso> listaProcesos;
    private JasperPrint jasperPrint;

    public ControladorListarAdolecentesInactivos() {
    }

    @PostConstruct
    public void init() {
        listaProcesos = procesoFacade.listarAdolescentesInactivos();

    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void prepararReporte(Proceso p) throws JRException {

        Map<String, Object> params = new HashMap<>();
        params.put("Usuario", controladorSesion.getUsuarioSesion().getNombre() + " " + controladorSesion.getUsuarioSesion().getApellidos());
        params.put("capacidadRestaurativa", p.getCapacidadRestaurativa());
        params.put("fortalecimiento", p.getFortalecimiento());
        params.put("objetivos", p.getObjetivos());
        params.put("trascendencia", p.getTrascendencia());
        params.put("nombreAdolescente", p.getAdolescentepkidAdolescente().getNombre());
        params.put("numeroDocumento", p.getAdolescentepkidAdolescente().getNumeroDocumento());
        params.put("fechaIngreso", p.getAdolescentepkidAdolescente().getRemisionpkordenRemision().getFechaRemision());
        params.put("tipoRemision", p.getAdolescentepkidAdolescente().getRemisionpkordenRemision().getTipoRemision());
        params.put("autoridad", p.getAdolescentepkidAdolescente().getRemisionpkordenRemision().getAutoridad());
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "WEB-INF/reportes/report.jasper";
        JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(new ArrayList<>());
        jasperPrint = JasperFillManager.fillReport(path, params, new JREmptyDataSource());

    }

    public void exportarPDF(Proceso p) throws JRException, IOException {
        prepararReporte(p);
        ServletOutputStream servletOutputStream = null;
        String contentType = "aplication/PDF";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext.getResponse();
        httpServletResponse.setContentType(contentType);
        httpServletResponse.setHeader("Content-disposition", "attachment; filename=\"ReporteUsuarios.pdf\"");
        servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        facesContext.responseComplete();

    }

}
