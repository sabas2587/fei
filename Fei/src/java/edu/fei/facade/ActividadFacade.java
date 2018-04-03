/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

import edu.fei.entidad.Actividad;
import edu.fei.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author sabas
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }

    public List<Actividad> findSession(Usuario usuario) {

        List<Actividad> a = new ArrayList();

        try {

            TypedQuery<Actividad> query = getEntityManager().createNamedQuery("Actividad.Usuario", Actividad.class);
            query.setParameter("usuario", usuario);
            a = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }

   public List<Actividad> countIniciada(Usuario usuario) {

        List<Actividad> a = new ArrayList();

        try {

            TypedQuery<Actividad> query = getEntityManager().createNamedQuery("Actividad.findByEstado", Actividad.class);
            query.setParameter("estado", "1");
            query.setParameter("usuario", usuario);
            a=query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }
   
     public List<Actividad> countProceso(Usuario usuario) {

        List<Actividad> a = new ArrayList();

        try {

            TypedQuery<Actividad> query = getEntityManager().createNamedQuery("Actividad.findByEstado", Actividad.class);
            query.setParameter("estado", "2");
            query.setParameter("usuario", usuario);
            a=query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }
       public List<Actividad> countFinalizada(Usuario usuario) {

        List<Actividad> a = new ArrayList();

        try {

            TypedQuery<Actividad> query = getEntityManager().createNamedQuery("Actividad.findByEstado", Actividad.class);
            query.setParameter("estado", "3");
            query.setParameter("usuario", usuario);
            a=query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }
       
        public List<Actividad> findSessionProfesional(Usuario usuario) {

        List<Actividad> a = new ArrayList();

        try {

            TypedQuery<Actividad> query = getEntityManager().createNamedQuery("Actividad.Usuario", Actividad.class);
            query.setParameter("usuario", usuario);
            a = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }
}
