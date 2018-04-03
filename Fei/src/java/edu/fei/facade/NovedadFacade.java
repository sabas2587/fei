/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Novedad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author David
 */
@Stateless
public class NovedadFacade extends AbstractFacade<Novedad> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadFacade() {
        super(Novedad.class);
    }
    
    public List<Novedad> listarNovedadesPorAdolecente(Adolescente a){
        List<Novedad>listaNovedades = new ArrayList<>();
        Query q = getEntityManager().createQuery("SELECT n from Novedad n WHERE n.adolescentepkidAdolescente = :adolescentepkidAdolescente", Novedad.class);
        q.setParameter("adolescentepkidAdolescente", a);
        listaNovedades = q.getResultList();
        return listaNovedades;
    
    }
    
}