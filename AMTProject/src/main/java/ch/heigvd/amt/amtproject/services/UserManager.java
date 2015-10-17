/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.User;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Marc
 */
@Stateless
public class UserManager implements UserManagerLocal {

    @EJB
    UserDAOLocal userDAO;
    
    @Override
    public long createUser(User u) {
        return userDAO.create(u);
    }
   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
