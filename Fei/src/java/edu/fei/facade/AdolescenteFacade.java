/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

import edu.fei.entidad.Adolescente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sabas
 */
@Stateless
public class AdolescenteFacade extends AbstractFacade<Adolescente> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdolescenteFacade() {
        super(Adolescente.class);
    }

    public Adolescente searchAdolescente(int documento) {

        Adolescente a = null;

        try {

            TypedQuery<Adolescente> query = getEntityManager().createNamedQuery("Adolescente.findByNumeroDocument", Adolescente.class);
            query.setParameter("numeroDocumento", documento);
            a = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;

    }
    
    public List<Adolescente> adolescentesActivos(){
        List<Adolescente>listaAdolescentes = new ArrayList<>();
        Query q = getEntityManager().createQuery("SELECT a from Adolescente a WHERE a.estado = 1", Adolescente.class);
        listaAdolescentes = q.getResultList();
        return listaAdolescentes;
        
    }
    
}
