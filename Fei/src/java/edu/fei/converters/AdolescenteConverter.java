/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.converters;

import edu.fei.entidad.Acudiente;
import edu.fei.entidad.Adolescente;
import edu.fei.facade.AcudienteFacade;
import edu.fei.facade.AdolescenteFacade;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author David
 */
@FacesConverter(value = "adolescenteConverter")
public class AdolescenteConverter implements Converter{
    
    private AdolescenteFacade adolescenteFacade;
    
    public AdolescenteConverter(){
        adolescenteFacade = CDI.current().select(AdolescenteFacade.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            try {

                return adolescenteFacade.find(Integer.valueOf(value));
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Adolescente) {
            return ((Adolescente) value).getPkidAdolescente().toString();
        }
        return "";

    }
    
}
