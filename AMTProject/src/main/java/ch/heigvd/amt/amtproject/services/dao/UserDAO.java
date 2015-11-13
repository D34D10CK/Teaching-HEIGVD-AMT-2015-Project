/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;
import ch.heigvd.amt.amtproject.model.entities.Account;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author Marc
 */
@Stateless
public class UserDAO extends GenericDAO<Account, Long> implements UserDAOLocal {

    @Override
    public Account testConnection(String username, String password) {
        Account u = null;
        try{
            u = (Account)em.createNamedQuery("User.testConnection").setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(NoResultException e){
            
        }
        return u;
    }

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
