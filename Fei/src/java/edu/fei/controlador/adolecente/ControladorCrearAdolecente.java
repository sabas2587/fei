/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.controlador.adolecente;

import edu.fei.entidad.Acudiente;
import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Remision;
import edu.fei.facade.AcudienteFacade;
import edu.fei.facade.AdolescenteFacade;
import edu.fei.facade.RemisionFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Ismael
 */
@Named(value = "controladorCrearAdolecente")
@ViewScoped
public class ControladorCrearAdolecente implements Serializable {

    private final static String UPLOAD_DIR = "/archivos/";

    @EJB
    private AdolescenteFacade adolescenteFacade;
    @EJB
    private AcudienteFacade acudienteFacade;
    @EJB
    private RemisionFacade remisionFacade;
    private List<Acudiente> listaAcudientes;
    private Adolescente adolescente;
    private Remision remision;

    public ControladorCrearAdolecente() {
    }

    @PostConstruct
    public void init() {
        listaAcudientes = acudienteFacade.findAll();
        adolescente = new Adolescente();
        remision = new Remision();

    }

    public List<Acudiente> getListaAcudientes() {
        return listaAcudientes;
    }

    public void setListaAcudientes(List<Acudiente> listaAcudientes) {
        this.listaAcudientes = listaAcudientes;
    }

    public Adolescente getAdolescente() {
        return adolescente;
    }

    public void setAdolescente(Adolescente adolescente) {
        this.adolescente = adolescente;
    }

    public Remision getRemision() {
        return remision;
    }

    public void setRemision(Remision remision) {
        this.remision = remision;
    }

    public void upload() {
        try {
            String name = "";
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            List<FileBean> filesBeans = getFilesUpload(ec);
            for (FileBean fileBean : filesBeans) {
                savePart(ec, fileBean);
                System.out.println("Datos: " + fileBean.toString());
                name = fileBean.getFileNameFull();
            }
            //deleteFile(ec, "Tablero y TV.c4d");
            remisionFacade.create(remision);
            adolescente.setRemisionpkordenRemision(remision);
            adolescente.setPathDocument(UPLOAD_DIR + name);
            adolescenteFacade.create(adolescente);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }

    }

    private List<FileBean> getFilesUpload(ExternalContext ec) throws IOException, ServletException {
        List<FileBean> files = new ArrayList<>();
        Collection<Part> parts = getParts(ec);
        for (Part part : parts) {
            if (part.getSize() > 0 && part.getSubmittedFileName() != null) {
                files.add(new FileBean(part.getName(), part.getContentType(), part.getSize(), part));
            }
        }
        return files;

    }

    private Collection<Part> getParts(ExternalContext ec) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) ec.getRequest();
        return rq.getParts();
    }

    private void savePart(ExternalContext ec, FileBean fileBean) throws IOException {
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
