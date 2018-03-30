/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

import edu.fei.entidad.Usuario;
import edu.fei.entidad.Valoracion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author David
 */
@Stateless
public class ValoracionFacade extends AbstractFacade<Valoracion> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionFacade() {
        super(Valoracion.class);
    }

    public List<Valoracion> listarValoracionesUsuarioEnSesion(Usuario usuario) {
        List<Valoracion>listaValoraciones = new ArrayList<>();
        try {
            TypedQuery<Valoracion> query = getEntityManager().createNamedQuery("Valoracion.findValoracionesUsuarioValidado", Valoracion.class);
            query.setParameter("usuariopkidUsuario", usuario);
            listaValoraciones = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return listaValoraciones;
    }

}