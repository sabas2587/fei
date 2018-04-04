/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fei.facade;

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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "FeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario inicioSesion(int numdocuemnto, String clave) {
        List<Usuario>listaUsuarios = new ArrayList<>();
        Usuario usuario = null;

        try {

            TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.login", Usuario.class);
            query.setParameter("numeroDocumento", numdocuemnto);
            query.setParameter("contraseña", clave);
            listaUsuarios = query.getResultList();
            for(Usuario u: listaUsuarios){
                usuario = u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
