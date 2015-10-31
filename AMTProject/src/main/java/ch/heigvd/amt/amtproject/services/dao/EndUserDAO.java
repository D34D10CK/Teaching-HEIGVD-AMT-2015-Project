/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import java.util.List;

/**
 *
 * @author Marc
 */
@Stateless
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal {

    @Override
    public List<EndUser> getEndUserList(Application app) {
        return em.createNamedQuery("EndUser.findByApp").setParameter("app", app).getResultList();
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<EndUser> findByAppAndPage(Application app, int pageSize, int pageIndex) {
        return em.createNamedQuery("EndUser.findByApp").setParameter("app", app).setMaxResults(pageSize).setFirstResult(pageIndex*pageSize).getResultList();
    }
    
}
