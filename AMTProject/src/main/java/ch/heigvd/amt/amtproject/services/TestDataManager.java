/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;
import ch.heigvd.amt.amtproject.model.entities.User;
import ch.heigvd.amt.amtproject.model.entities.Application;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marc
 */
@Stateless
public class TestDataManager implements TestDataManagerLocal {
    
    @EJB
    UserDAOLocal userDAO;
    
    @EJB
    ApplicationDAOLocal applicationDAO;

    @Override
    public void generateTestData() {
        User u = new User("test@t.com", "t", "t", "t");
        User u2 = new User("marc@heig-vd.ch", "Marc", "Pellet", "bonjour");
        
        userDAO.create(u);
        userDAO.create(u2);
        
        Application a = new Application(applicationDAO.makeApiKey(), u, "app1", "c'est la première app");
        Application a2 = new Application(applicationDAO.makeApiKey(), u2, "app2", "c'est une autre app");
        Application a3 = new Application(applicationDAO.makeApiKey(), u, "app3", "Et bim une troisième app");
        
        applicationDAO.create(a);
        applicationDAO.create(a2);
        applicationDAO.create(a3);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
