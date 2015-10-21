/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;
import ch.heigvd.amt.amtproject.model.entities.User;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author Marc
 */
@Stateless
public class UserDAO extends GenericDAO<User, Long> implements UserDAOLocal {

    @Override
    public User testConnection(String username, String password) {
        User u = null;
        try{
            u = (User)em.createNamedQuery("User.testConnection").setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(NoResultException e){
            
        }
        return u;
    }

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
