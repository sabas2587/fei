/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.converters;

import edu.fei.entidad.Acudiente;
import edu.fei.facade.AcudienteFacade;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author David
 */
public class AcudienteConverter implements Converter{
    
    private AcudienteFacade acudienteFacade;
    
    public AcudienteConverter(){
        acudienteFacade = CDI.current().select(AcudienteFacade.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            try {

                return acudienteFacade.find(Integer.valueOf(value));
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Acudiente) {
            return ((Acudiente) value).getPkidAcudiente().toString();
        }
        return "";

    }
    
}
