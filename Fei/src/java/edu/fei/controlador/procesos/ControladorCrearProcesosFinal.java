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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author David
 */
@Named(value = "controladorCrearProcesosFinal")
@RequestScoped
public class ControladorCrearProcesosFinal implements Serializable {

    private final static String UPLOAD_DIR = "/archivos/Juez/";
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

    public ControladorCrearProcesosFinal() {
    }

    @PostConstruct
    public void init() {
        listaValoraciones = valoracionFacade.findAll();
        listaProcesos = procesoFacade.findAll();
        listaAdolescentes = procesoFacade.listarAdolescentesDeSalida();
        proceso = new Proceso();
        //validarValoracionesAdolecente();

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
        for (Proceso p : listaProcesos) {
            listaAdolescentes.add(p.getAdolescentepkidAdolescente());

        }
        /*for (Adolescente a : new ArrayList<>(this.listaAdolescentes)) {
            if (a.getValoracionList().size() < 4) {
                System.out.println(a.getNombre() + " " + a.getApellidos() + " no tiene 4 valoraciones");
                this.listaAdolescentes.remove(a);
            }

            for (Proceso p : a.getProcesoList()) {
                if (!p.getTipoproceso().equals("Informe de seguimiento")) {
                    System.out.println(a.getNombre() + " " + a.getApellidos() + " no puede salir de la fundacion: ");
                    listaAdolescentes.remove(a);

                }

            }
        
        }*/

    }


    public String crearProceso() throws JRException {
        try {

            String name = "";
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            List<edu.fei.controlador.adolecente.FileBean> filesBeans = getFilesUpload(ec);
            for (edu.fei.controlador.adolecente.FileBean fileBean : filesBeans) {
                savePart(ec, fileBean);
                System.out.println("Datos: " + fileBean.toString());
                name = fileBean.getFileNameFull();

            }
            //deleteFile(ec, "Tablero y TV.c4d");
            proceso.setPathConceptoFinal(UPLOAD_DIR + name);
            proceso.setTipoConcepto("Informe final");
            proceso.setTipoproceso("Informe de seguimiento");
            proceso.setFechaDiagnostico(new Date());
            proceso.setUsuariopkidUsuario(controladorSesion.getUsuarioSesion());
            procesoFacade.create(proceso);
            Adolescente a = proceso.getAdolescentepkidAdolescente();
            a.setEstado(0);
            adolescenteFacade.edit(a);

            return "/Views/Proceso/ListarProcesos.xhtml?faces-redirect=true";

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";

        } catch (ServletException ex) {
            ex.printStackTrace();
            return "";

        }

    }

    private List<edu.fei.controlador.adolecente.FileBean> getFilesUpload(ExternalContext ec) throws IOException, ServletException {
        List<edu.fei.controlador.adolecente.FileBean> files = new ArrayList<>();
        Collection<Part> parts = getParts(ec);
        for (Part part : parts) {
            if (part.getSize() > 0 && part.getSubmittedFileName() != null) {
                files.add(new edu.fei.controlador.adolecente.FileBean(part.getName(), part.getContentType(), part.getSize(), part));
            }
        }
        return files;

    }

    private Collection<Part> getParts(ExternalContext ec) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) ec.getRequest();
        return rq.getParts();
    }

    private void savePart(ExternalContext ec, edu.fei.controlador.adolecente.FileBean fileBean) throws IOException {
        File dir = new File(ec.getRealPath("") + UPLOAD_DIR);
        dir.mkdirs();
        File file = new File(dir, fileBean.getFileNameFull());
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = fileBean.getPart().getInputStream();

        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }

    private void deleteFile(ExternalContext ec, String name) {
        File dir = new File(ec.getRealPath("") + UPLOAD_DIR);
        dir.mkdirs();
        File file = new File(dir, name);
        file.delete();
    }

}
