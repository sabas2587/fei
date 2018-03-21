/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

import edu.fei.entidad.Adolescente;
import edu.fei.entidad.Proceso;
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
public class ProcesoFacade extends AbstractFacade<Proceso> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesoFacade() {
        super(Proceso.class);
    }
    
      public List<Proceso> searchProceso(Adolescente adolescente,Usuario usuario){
        
        List<Proceso> p = new ArrayList<>();
        
        try {
            
            TypedQuery<Proceso> query = getEntityManager().createNamedQuery("Proceso.findByadolescenteValorado",Proceso.class);
            query.setParameter("adolescentepkidAdolescente", adolescente);
            query.setParameter("usuariopkidUsuario", usuario);
            p = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        return p;
    
    }
}
