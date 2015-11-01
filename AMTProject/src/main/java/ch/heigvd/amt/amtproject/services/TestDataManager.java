/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.*;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;

import ch.heigvd.amt.amtproject.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.RoleDAO;
import ch.heigvd.amt.amtproject.services.dao.RoleDAOLocal;

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
    
    @EJB
    ApiKeyDAOLocal apiKeyDAO;
    
    @EJB
    RoleDAOLocal roleDAO;
 
    @EJB
    EndUserDAOLocal enduUserDAO;

    @Override
    public void generateTestData() {
        User u = new User("test@t.com", "t", "t", "t");
        User u2 = new User("marc@heig-vd.ch", "Marc", "Pellet", "bonjour");
        
        userDAO.create(u);
        userDAO.create(u2);
        
        ApiKey key1 = new ApiKey();
        ApiKey key2 = new ApiKey();
        ApiKey key3 = new ApiKey();
        
        apiKeyDAO.create(key1);
        apiKeyDAO.create(key2);
        apiKeyDAO.create(key3);
        
        
        
        Application a1 = new Application(key1, u, "app1", "c'est la première app", true);
        Application a2 = new Application(key2, u2, "app2", "c'est une autre app", true);
        Application a3 = new Application(key3, u, "app3", "Et bim une troisième app", false);
        
        applicationDAO.create(a1);
        applicationDAO.create(a2);
        applicationDAO.create(a3);
        
        for(int i = 0; i < 154; i++){
            createEndUser(a3);
            createEndUser(a1);
            createEndUser(a2);
        }
           
        Role r1 = new Role("admin");
        Role r2 = new Role("developper");
        
        //roleDAO.create(r1);
        //roleDAO.create(r2);
    }
    
    private void createEndUser(Application app){
        EndUser e = new EndUser();
        e.setApp(app);
        enduUserDAO.create(e);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
