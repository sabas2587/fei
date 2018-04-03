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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
      
      public List<Proceso> listarProcesosUsuarioSesion(Usuario u){
          List<Proceso> listaProcesos = new ArrayList<>();
          Query q = getEntityManager().createNamedQuery("Proceso.procesos", Proceso.class);
          q.setParameter("usuariopkidUsuario", u);
          listaProcesos = q.getResultList();
          return listaProcesos;
          
      }
      
      public List<Adolescente> listarAdolescentesDeSalida(){
          List<Proceso> listaProcesos = new ArrayList<>();
          List<Adolescente> listaAdolescentes = new ArrayList<>();
          Set<Adolescente> listaAdolescentesSinRepetir = new HashSet<>();
          Query q = getEntityManager().createNamedQuery("Proceso.adolescenteListoSalir", Proceso.class);
          listaProcesos = q.getResultList();
          for(Proceso p: listaProcesos){
              listaAdolescentesSinRepetir.add(p.getAdolescentepkidAdolescente());
          
          }
          listaAdolescentes.addAll(listaAdolescentesSinRepetir);
          return listaAdolescentes;
      
      }
      
      public List<Proceso> listarAdolescentesInactivos(){
          List<Proceso> listaProcesos = new ArrayList<>();
          Query q = getEntityManager().createQuery("SELECT p FROM Proceso p where p.adolescentepkidAdolescente.estado = 0 AND p.tipoConcepto = 'Informe final'", Proceso.class);
          listaProcesos = q.getResultList();
          return listaProcesos;
      
      }
      
}